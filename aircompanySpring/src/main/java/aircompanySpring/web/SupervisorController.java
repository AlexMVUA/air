package aircompanySpring.web;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aircompanySpring.domain.Destination;
import aircompanySpring.domain.Route;
import aircompanySpring.domain.Person;
import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Position;
import aircompanySpring.service.RouteService;
import aircompanySpring.service.PersonService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController extends AbstractController {	
	
	@RequestMapping(value = {"/", "/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String goHomeSupervisorPage(Model model, HttpSession session) {
		
		List<Person> personList = personService.findAllPersons();
		List<Route> routeList = routeService.findAllRoutes();
				
		session.setAttribute("personList", personList);
	    session.setAttribute("flightList", routeList);		
		
        return "homesupervisor";
    }
		
}
