package aircompanySpring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import aircompanySpring.domain.Plane;
import aircompanySpring.repository.NotUniqueEntityException;

@Controller
@RequestMapping("/admin")
public class PlaneControler extends AbstractController {

	@RequestMapping(value = "/addPlane", method = {RequestMethod.GET})
	public String addPlane(ModelMap model) {
		model.addAttribute("plane", new Plane());
		return "plane/add_plane";
	}

	@RequestMapping(value = "/confirmAddPlane", method = {RequestMethod.POST})
	public String confirmAddPlane(
			@Valid Plane plane, 
			BindingResult result, 
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(result.hasErrors()) {
			model.addAttribute("error", "added new plane fails due to input errors");			
			return "plane/add_plane";
		}		
		try {
			planeService.save(plane);
			redirectAttributes.addFlashAttribute("success",  "added new plane successfully");
			return "redirect:home";
		} catch(NotUniqueEntityException ex) {
			model.addAttribute("error", "added new plane fail - such plane already exist");
			model.addAttribute("plane", new Plane());
			return "plane/add_plane";
		}			
	}


	@RequestMapping(value = "/removePlane", method = {RequestMethod.GET})
	public String removePlane(
			Model model, 
			@RequestParam("planeId") Plane plane) {
		model.addAttribute("plane", plane);

		return "plane/delete_plane";
	}


	@RequestMapping(value = "/confirmRemovePlane", method = {RequestMethod.POST})
	public String confirmRemovePlane(
			Model model, 
			@RequestParam Long planeId) {
		planeService.remove(planeId);
		return "redirect:";
	}
	
	@RequestMapping(value = "/editPlane", method = {RequestMethod.GET})
	public String editPlane(
			@RequestParam("planeId") Long planeId, 
			Model model,
			@ModelAttribute("plane") Plane plane) {

		if (model.asMap().containsKey("editPlaneFormBindingResult")) {
			model.addAttribute("org.springframework.validation.BindingResult.plane",
					model.asMap().get("editPlaneFormBindingResult"));
		}

		model.addAttribute("planeId", planeId);
		model.addAttribute("planeOriginal", planeService.findById(planeId));
		model.addAttribute("plane", plane);		
		return "plane/edit_plane";
	}

	@RequestMapping(value = "/confirmEditPlane", method = {RequestMethod.POST})
	public String confirmEditPlane(
			@RequestParam("planeId") Plane planeInitial,
			@Valid  @ModelAttribute("plane") Plane plane,			
			final BindingResult bindingResult,			
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "editing existing plane fail due to input errors");				
			redirectAttributes.addFlashAttribute("plane", plane);
			redirectAttributes.addFlashAttribute("editPlaneFormBindingResult", bindingResult);
			return "redirect:editPlane?planeId=" + planeInitial.getId();
		}	
		if (planeInitial.equals(plane)) {			
			redirectAttributes.addFlashAttribute("success", "no changes were made");
			return "redirect:home";
		}
		try {
			planeInitial.setModel(plane.getModel());
			planeInitial.setPilotNeeds(plane.getPilotNeeds());
			planeInitial.setNavigatorNeeds(plane.getNavigatorNeeds());
			planeInitial.setRadiomanNeeds(plane.getRadiomanNeeds());
			planeInitial.setStewardessNeeds(plane.getStewardessNeeds());			
			planeService.update(planeInitial);
			redirectAttributes.addFlashAttribute("success", "editing existing plane was successful");
			return "redirect:home";
		} catch(NotUniqueEntityException ex) {			
			redirectAttributes.addFlashAttribute("error", "editing existing plane - such plane already exist");			
			return "redirect:editPlane?planeId=" + planeInitial.getId();
		}
	}
	

	@RequestMapping(value = "/viewPlanes", method = {RequestMethod.GET})
	public String viewPlanes(Model model) {
		List<Plane> planeList = planeService.findAllPlanes();
		model.addAttribute("planeList", planeList);

		return "plane/planes";
	}

}
