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
import aircompanySpring.domain.Destination;
import aircompanySpring.repository.NotUniqueEntityException;

@Controller
@RequestMapping("/admin")
public class DestinationController extends AbstractController{

	@RequestMapping(value = "/addDestination", method = {RequestMethod.GET})
	public String addDestination(ModelMap model) {
		model.addAttribute("destination", new Destination());
		return "destination/add_destination";
	}

	@RequestMapping(value = "/confirmAddDestination", method = {RequestMethod.POST})
	public String confirmAddDestination(			
			@Valid Destination destination, 
			BindingResult result, 
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(result.hasErrors()) {			
			model.addAttribute("error", "added new destination fail due to input errors");
			return "destination/add_destination";			
		}

		try {
			destinationService.save(destination);
			redirectAttributes.addFlashAttribute("success", "added new destination successfully");
			return "redirect:home";
		} catch(NotUniqueEntityException ex) {
			model.addAttribute("error", "added new destination fail - such destination already exist");			
			model.addAttribute("destination", new Destination());
			return "destination/add_destination";
		}
	}

	@RequestMapping(value = "/removeDestination", method = {RequestMethod.GET})
	public String removeDestination(
			Model model, 
			@RequestParam("destinationId") Destination destination) {
		model.addAttribute("destination", destination);

		return "destination/delete_destination";
	}		

	@RequestMapping(value = "/confirmRemoveDestination", method = {RequestMethod.POST})
	public String confirmRemoveDestination(
			Model model, 
			@RequestParam Long destinationId) {
		destinationService.remove(destinationId);
		return "redirect:";
	}

	@RequestMapping(value = "/editDestination", method = {RequestMethod.GET})
	public String editPlane(
			@RequestParam("destinationId") Long destinationId, 
			Model model,
			@ModelAttribute("destination") Destination destination) {

		if (model.asMap().containsKey("editDestinationFormBindingResult")) {
			model.addAttribute("org.springframework.validation.BindingResult.destination",
					model.asMap().get("editDestinationFormBindingResult"));
		}

		model.addAttribute("destinationId", destinationId);
		model.addAttribute("destinationOriginal", destinationService.findById(destinationId));
		model.addAttribute("destination", destination);		

		return "destination/edit_destination";
	}

	@RequestMapping(value = "/confirmEditDestination", method = {RequestMethod.POST})
	public String confirmEditDestination(
			@RequestParam("destinationId") Destination destinationInitial,
			@Valid  @ModelAttribute("destination") Destination destination,			
			final BindingResult bindingResult,			
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "editing existing destination fail due to input errors");				
			redirectAttributes.addFlashAttribute("destination", destination);
			redirectAttributes.addFlashAttribute("editDestinationFormBindingResult", bindingResult);
			return "redirect:editDestination?destinationId=" + destinationInitial.getId();
		}	
		if (destinationInitial.equals(destination)) {			
			redirectAttributes.addFlashAttribute("success", "now changes were made");
			return "redirect:home";
		}		
		try {			
			destinationInitial.setAirport(destination.getAirport());
			destinationInitial.setCity(destination.getCity());
			destinationInitial.setCountry(destination.getCountry());
			destinationService.update(destinationInitial);
			redirectAttributes.addFlashAttribute("success", "edited existing destination successfully");
			return "redirect:home";
		} catch(NotUniqueEntityException ex) {			
			
			redirectAttributes.addFlashAttribute("error", "editing existing destination fail - such destination already exist");
			//redirectAttributes.addFlashAttribute("destinationId", destinationInitial.getId());	
			//model.addAttribute("error", "editing existing destination fail - such destination already exist");
			//model.addAttribute("destinationId", destinationInitial.getId());	
			return "redirect:editDestination?destinationId=" + destinationInitial.getId();
		}		
	}



	@RequestMapping(value = "/viewDestinations", method = {RequestMethod.GET})
	public String viewDestinations(Model model) {
		List<Destination> destinationList = destinationService.findAllDestinations();
		model.addAttribute("destinationList", destinationList);

		return "destination/destinations";
	}
}
