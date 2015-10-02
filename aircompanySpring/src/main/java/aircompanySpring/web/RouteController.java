package aircompanySpring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aircompanySpring.domain.Destination;
import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Route;
import aircompanySpring.repository.NotUniqueEntityException;

@Controller
@RequestMapping("/admin")
public class RouteController extends AbstractController {

	@RequestMapping(value = "/addRoute", method = {RequestMethod.GET})
	public String addRoute(ModelMap model) {

		List<Destination> destinationList = destinationService.findAllDestinations();
		model.addAttribute("destinationList", destinationList);
		model.addAttribute("route", new Route());

		return "route/add_route";
	}

	@RequestMapping(value = "/confirmAddRoute", method = {RequestMethod.POST})
	public String confirmAddRoute(
			@RequestParam("destinationFromId") Destination destinationFrom,
			@RequestParam("destinationToId") Destination destinationTo,
			RedirectAttributes redirectAttributes,
			Model model) {
		Route route = new Route();				
		route.setDestinationFrom(destinationFrom);		
		route.setDestinationTo(destinationTo);	
		
		if (destinationFrom.equals(destinationTo)) {
			redirectAttributes.addFlashAttribute("error", "added new route fail - destinations must differ");			
			return "redirect:addRoute";
		}	
		
		try{
			routeService.save(route);
			redirectAttributes.addFlashAttribute("success",  "added new route successfully");
			return "redirect:home";
		} catch(NotUniqueEntityException ex) {
			redirectAttributes.addFlashAttribute("error", "added new route fail - such route already exist");			
			return "redirect:addRoute";
		}		
	}

	@RequestMapping(value = "/removeRoute", method = {RequestMethod.GET})
	public String removeRoute(
			Model model, 
			@RequestParam("routeId") Route route) {

		model.addAttribute("route", route);
		return "route/delete_route";
	}


	@RequestMapping(value = "/confirmRemoveRoute", method = {RequestMethod.POST})
	public String confirmRemoveRoute(
			Model model, 
			@RequestParam Long routeId) {
		routeService.remove(routeId);
		return "redirect:";
	}

	@RequestMapping(value = "/editRoute", method = {RequestMethod.GET})
	public String editFLight(
			@RequestParam("routeId") Route route,
			@RequestParam Long routeId,
			Model model) {
		model.addAttribute(route);
		List<Destination> destinationList = destinationService.findAllDestinations();
		model.addAttribute("destinationList", destinationList);
		model.addAttribute("routeId", routeId);
		
		return "route/edit_route";
	}

	@RequestMapping(value = "/confirmEditRoute", method = {RequestMethod.POST})
	public String confirmEditRoute(
			@RequestParam("routeId") Route route,
			@RequestParam("destinationFromId") Destination destinationFrom,
			@RequestParam("destinationToId") Destination destinationTo,
			RedirectAttributes redirectAttributes,
			Model model) {

		if (route.getDestinationFrom().equals(destinationFrom) && 
				route.getDestinationTo().equals(destinationTo))	{
			redirectAttributes.addFlashAttribute("success",  "no changes were made");
			return "redirect:home";
		}
		
		if (destinationFrom.equals(destinationTo)) {
			redirectAttributes.addFlashAttribute("error", "editing new route fail - destinations must differ");			
			return "redirect:editRoute?routeId=" + route.getId();
		}
		
		route.setDestinationFrom(destinationFrom);		
		route.setDestinationTo(destinationTo);
		
		try {
			routeService.update(route);
			redirectAttributes.addFlashAttribute("success",  "editing existing route was successfull");
			return "redirect:home";
		} catch (NotUniqueEntityException e) {
			redirectAttributes.addFlashAttribute("error", "edited route fail - such route already exist");			
			return "redirect:editRoute?routeId=" + route.getId();
		}		
	}

	@RequestMapping(value = "/searchRoutes", method = {RequestMethod.GET})
	public String searchRoutes(
			Model model,
			@RequestParam String searchString) {

		List<Route> routeList = routeService.searchRoutes(searchString);
		model.addAttribute("routeList", routeList);
		model.addAttribute("searchString", searchString);

		return "route/search_routes";
	}

	@RequestMapping(value = "/viewRoutes", method = {RequestMethod.GET})
	public String viewRoutes(Model model) {
		List<Route> routeList = routeService.findAllRoutes();
		model.addAttribute("routeList", routeList);

		return "route/routes";
	}



}
