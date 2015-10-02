package aircompanySpring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aircompanySpring.domain.Crew;
import aircompanySpring.domain.Person;
import aircompanySpring.domain.Flight;

@Controller
@RequestMapping("/supervisor")
public class CrewController extends AbstractController {

	@RequestMapping("/viewCrews")
	public String viewCrews(Model model) {
		List<Crew> crewList = crewService.findAllCrews();
		model.addAttribute("crewList", crewList);
		return "crew/crews";
	}
	
	
	@RequestMapping("/viewCrewsByPerson")
	public String viewCrewsByPerson(
			Model model,
			@RequestParam Long personId) {
		List<Crew> crewList = crewService.findAllCrewsByPerson(personId);
		model.addAttribute("crewList", crewList);
		return "crew/crews_person";
	}
	
	@RequestMapping("/viewCrewsByRoute")
	public String viewCrewsByFlight(Model model,
			@RequestParam Long routeId) {
		List<Crew> crewList = crewService.findAllCrewsByRoute(routeId);
		model.addAttribute("crewList", crewList);
		return "crew/crews_flight";
	}
	
	@RequestMapping("/addCrew")
	public String addCrew(Model model) {
		List<Person> personList = personService.findAllPersons();
		List<Flight> flightList = flightService.findAllFlights();
		
		model.addAttribute("personList", personList);
		model.addAttribute("flightList", flightList);
		
		return "crew/add_crew";
	}
	
	@RequestMapping(value = "/confirmAddCrew", method = {RequestMethod.POST})
	public String confirmAddCrew(
			@RequestParam("flightId") Flight flight,
			@RequestParam("personId") Person person) {
		Crew crew = new Crew();
		crew.setFlight(flight);
		crew.setPerson(person);		
		crewService.save(crew);		
		
		return "redirect:";
	}
	
	@RequestMapping("/editCrew")
	public String editCrew(
			Model model,
			@RequestParam("crewId") Crew crew) {
		
		List<Person> personList = personService.findAllPersons();
		List<Flight> flightList = flightService.findAllFlights();
		
		model.addAttribute("personList", personList);
		model.addAttribute("flightList", flightList);
		model.addAttribute("crew", crew);
		
		return "crew/edit_crew";
	}
	
	@RequestMapping(value = "/confirmEditCrew", method = {RequestMethod.POST})
	public String confirmEditCrew(
			@RequestParam("flightId") Flight flight,
			@RequestParam("personId") Person person,
			@RequestParam("crewId") Crew crew) {
		
		crew.setFlight(flight);
		crew.setPerson(person);		
		crewService.update(crew);
		
		return "redirect:";
	}
	
	@RequestMapping("/removeCrew")
	public String removeCrew(
			Model model,
			@RequestParam("crewId") Crew crew) {
				
		model.addAttribute("crew", crew);
		
		return "crew/delete_crew";
	}
	
	@RequestMapping(value = "/confirmRemoveCrew", method = {RequestMethod.POST})
	public String confirmRemoveCrew(@RequestParam Long crewId) {
		crewService.remove(crewId);
		return "redirect:";
	}
}
