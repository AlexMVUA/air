package aircompanySpring.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Route;
import aircompanySpring.domain.Flight;
import aircompanySpring.repository.NotUniqueEntityException;

@Controller
@RequestMapping("/admin")
public class FlightController extends AbstractController {


	@RequestMapping(value = "/addFlight")
	public String addFlight(ModelMap model) {

		List<Route> routeList = routeService.findAllRoutes();
		model.addAttribute("routeList", routeList);
		List<Plane> planeList = planeService.findAllPlanes();
		model.addAttribute("planeList", planeList);
		model.addAttribute("flight", new Flight());

		return "flight/add_flight";
	}

	
	@RequestMapping(value = "/confirmAddFlight")
	public String confirmAddTimeTable(
			@Valid Flight flight,
			BindingResult result,
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if (flight.getArrival().before(flight.getDeparture())) {
			redirectAttributes.addFlashAttribute("error", "added new flight fail - check input date values, departure must be BEFORE arrival ");
			return "redirect:addFlight";
		}
		
		if (result.hasErrors()) {
			List<Route> routeList = routeService.findAllRoutes();
			model.addAttribute("routeList", routeList);
			List<Plane> planeList = planeService.findAllPlanes();
			model.addAttribute("planeList", planeList);
			model.addAttribute("error", "adding new flight fails due to errors");
			return "flight/add_flight";
		}		
		
		try {			
			flightService.save(flight);
			redirectAttributes.addFlashAttribute("success",  "added new flight successfully");
			return "redirect:home";
		} catch (NotUniqueEntityException e) {
			redirectAttributes.addFlashAttribute("error", "added new flight fail - there is flight for this route and departure/arrival time (within 1 day) ");
			return "redirect:addFlight";
		}	
		
	}

	@RequestMapping(value = "/addFlightForRoute")
	public String addFlightForRoute(
			ModelMap model,
			@RequestParam("routeId") Route route) {

		List<Plane> planeList = planeService.findAllPlanes();
		model.addAttribute("planeList", planeList);
		model.addAttribute("flight", new Flight());
		model.addAttribute("route", route);

		return "flight/add_flight_for_route";
	}

	@RequestMapping(value = "/confirmAddFlightForRoute")
	public String confirmAddFlightForRoute(
			@Valid Flight flight,
			@RequestParam("routeId") Route route,
			BindingResult result,
			ModelMap model,
			RedirectAttributes redirectAttributes){
		
		if (flight.getArrival().before(flight.getDeparture())) {
			redirectAttributes.addFlashAttribute("error", "added new flight fail - check input date values, departure must be BEFORE arrival ");
			redirectAttributes.addFlashAttribute("routeId", route.getId());
			redirectAttributes.addFlashAttribute("route", route);
			return "redirect:addFlightForRoute?routeId=" + route.getId();
		}
		
		if (result.hasErrors()) {
			List<Plane> planeList = planeService.findAllPlanes();			
			redirectAttributes.addFlashAttribute("planeList", planeList);
			
			redirectAttributes.addFlashAttribute("error", "adding new flight fails due to errors");
			redirectAttributes.addFlashAttribute("flight", new Flight());
			redirectAttributes.addFlashAttribute("route", route);
			redirectAttributes.addFlashAttribute("routeId", route.getId());
			
			return "redirect:addFlightForRoute?routeId=" + route.getId();
			
		}

		
		try {
			flightService.save(flight);
			model.addAttribute("success", "added new flight successfully");
			return "redirect:";
		} catch (NotUniqueEntityException e) {
			redirectAttributes.addFlashAttribute("error", "added new flight fail -"
					+ " there is flight for this route and departure/arrival time (WITHIN 1 day) ");
			model.addAttribute("routeId", route.getId());
			return "redirect:addFlightForRoute?routeId=" + route.getId();
		}				
	}


	@RequestMapping(value = "/viewAllFlights")
	public String viewAllFlights(Model model) {

		List<Flight> flightList = flightService.findAllFlights();
		model.addAttribute("flightList", flightList);

		return "flight/flights";
	}

	@RequestMapping(value = "/searchFlights")
	public String searchFlights(
			ModelMap model,
			@RequestParam String searchString) {

		List<Flight> flightList = flightService.searchFlights(searchString);
		model.addAttribute("flightList", flightList);
		model.addAttribute("searchString", searchString);
		return "flight/search_flights";
	}

	@RequestMapping(value = "/viewRouteFlights")
	public String viewRouteFlights(
			Model model,
			@RequestParam Long routeId) {

		List<Flight> flightList = flightService.findAllFlightsByRoute(routeId);
		model.addAttribute("flightList", flightList);
		
		return "flight/route_flights";
	}

	@RequestMapping(value = "/editFlight")
	public String editFlight(
			@RequestParam("flightId") Long flightId, 
			Model model,
			@ModelAttribute("flight") Flight flight) {
		
		if (model.asMap().containsKey("editFlightFormBindingResult")) {
			model.addAttribute("org.springframework.validation.BindingResult.flight",
					model.asMap().get("editFlightFormBindingResult"));
		}
		List<Route> routeList = routeService.findAllRoutes();
		model.addAttribute("routeList", routeList);
		List<Plane> planeList = planeService.findAllPlanes();
		model.addAttribute("planeList", planeList);
		model.addAttribute("flightId", flightId);
		model.addAttribute("flightOriginal", flightService.findById(flightId));
		model.addAttribute("flight", flight);			

		return "flight/edit_flight";
	}

	@RequestMapping(value = "/confirmEditFlight")
	public String confirmEditFlight(			
			@RequestParam("flightId") Flight flightInitial,			
			@Valid  @ModelAttribute("flight") Flight flight,			
			final BindingResult bindingResult,			
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(bindingResult.hasErrors()) {
			List<Route> routeList = routeService.findAllRoutes();
			redirectAttributes.addFlashAttribute("routeList", routeList);
			List<Plane> planeList = planeService.findAllPlanes();
			redirectAttributes.addFlashAttribute("planeList", planeList);
			redirectAttributes.addFlashAttribute("error", "editing existing flight fails due to input errors");
			redirectAttributes.addFlashAttribute("flight", flight);
			redirectAttributes.addFlashAttribute("editFlightFormBindingResult", bindingResult);
			return "redirect:editFlight?flightId=" + flightInitial.getId();
		}
				
		flightInitial.setName(flight.getName());
		flightInitial.setPlane(flight.getPlane());
		flightInitial.setRoute(flight.getRoute());
		flightInitial.setDeparture(flight.getDeparture());
		flightInitial.setArrival(flight.getArrival());

		try {
			flightService.update(flightInitial);
			redirectAttributes.addFlashAttribute("success", "editing existing flight was successful");
			return "redirect:home";
		} catch (NotUniqueEntityException e) {
			redirectAttributes.addFlashAttribute("error", "editing existing flight - such flight already exist");
			model.addAttribute("error", "editing existing flight - such flight already exist");
			return "redirect:editFlight?flightId=" + flightInitial.getId();
		}
		
	}


	@RequestMapping(value = "/removeFlight")
	public String removeTimeTable(
			Model model,
			@RequestParam("flightId") Flight flight) {

		model.addAttribute("flight", flight);

		return "flight/delete_flight";
	}

	@RequestMapping(value = "/confirmRemoveFlight")
	public String confirmRemoveFlight(@RequestParam Long flightId) {

		flightService.remove(flightId);

		return "redirect:";
	}
}
