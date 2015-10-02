package aircompanySpring.web;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import aircompanySpring.domain.Crew;
import aircompanySpring.domain.Destination;
import aircompanySpring.domain.Route;
import aircompanySpring.domain.Person;
import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Position;
import aircompanySpring.domain.Flight;
import aircompanySpring.service.CrewService;
import aircompanySpring.service.DestinationService;
import aircompanySpring.service.RouteService;
import aircompanySpring.service.PersonService;
import aircompanySpring.service.PlaneService;
import aircompanySpring.service.PositionService;
import aircompanySpring.service.FlightService;

public abstract class AbstractController {

	@Autowired
	RouteService routeService;

	@Autowired
	PlaneService planeService;

	@Autowired
	PersonService personService;

	@Autowired
	DestinationService destinationService;

	@Autowired
	PositionService positionService;

	@Autowired
	FlightService flightService;

	@Autowired
	CrewService crewService;

	

	@InitBinder
	private void planeBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Plane.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String planeId) {
						Plane plane = null;
						if (planeId != null && !planeId.trim().isEmpty()) {
							Long id = Long.valueOf(planeId);
							plane = getPlaneById(id);
						}
						setValue(plane);
					}
				});
	}

	protected Plane getPlaneById(Long id) {		 
		Plane plane = planeService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (plane == null) {
			throw new RuntimeException("Plane with Id: " + id + " not found");
		}
		return plane;
	}

	@InitBinder
	private void flightBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Flight.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String flight) {
						Flight timeTable = null;
						if (flight != null && !flight.trim().isEmpty()) {
							Long id = Long.valueOf(flight);
							timeTable = getFlightById(id);
						}
						setValue(timeTable);
					}
				});
	}

	private Flight getFlightById(Long id) {
		Flight flight = flightService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (flight == null) {
			throw new RuntimeException("Flight with Id: " + id + " not found");
		}
		
		return flight;
	}

	@InitBinder
	private void destinationBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Destination.class,
				new PropertyEditorSupport(){
					@Override
					public void setAsText(String destinationId) {
						Destination newDestination = null;
						if (destinationId != null && !destinationId.trim().isEmpty()) {
							Long id = Long.valueOf(destinationId);
							newDestination = getDestinationById(id);
						}
						setValue(newDestination);
					}
				});
	}
	
	protected Destination getDestinationById(Long id) {		
		Destination destination = destinationService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (destination == null) {
			throw new RuntimeException("Destination with Id: " + id + " not found");
		}		
		return destination;
	}

	@InitBinder
	private void routeBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Route.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String routeId) {
						Route route = null;
						if (routeId != null && !routeId.trim().isEmpty()) {
							Long id = Long.valueOf(routeId);
							route = getRouteById(id);
						}
						setValue(route);
					}
				});
	}


	protected Route getRouteById(Long id) {		
		Route route = routeService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (route == null) {
			throw new RuntimeException("Route with Id: " + id + " not found");
		}		
		return route;
	}

	@InitBinder
	private void personBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Person.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String personId) {
						Person person = null;
						if (personId != null && !personId.trim().isEmpty()) {
							Long id = Long.valueOf(personId);
							person = getPersonById(id);
						}
						setValue(person);
					}
				});
	}


	protected Person getPersonById(Long id) {
		Person person = personService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (person == null) {
			throw new RuntimeException("Person with Id: " + id + " not found");
		}		
		return person;
	}

	@InitBinder
	private void positionBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Position.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String positionId) {
						Position position = null;
						if (positionId != null && !positionId.trim().isEmpty()) {
							Long id = Long.valueOf(positionId);
							position = getPositionById(id);
						}
						setValue(position);
					}
				});
	}


	protected Position getPositionById(Long id) {	
		Position position = positionService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (position == null) {
			throw new RuntimeException("Person with Id: " + id + " not found");
		}		
		return position;
	}

	@InitBinder
	private void crewBinder(WebDataBinder binder) {
		binder.registerCustomEditor(
				Crew.class,
				new PropertyEditorSupport(){

					@Override
					public void setAsText(String crewId) {
						Crew crew = null;
						if (crewId != null && !crewId.trim().isEmpty()) {
							Long id = Long.valueOf(crewId);
							crew = getCrewById(id);
						}
						setValue(crew);
					}
				});
	}

	protected Crew getCrewById(Long id) {
		Crew crew = crewService.findById(id);
		if (id <= 0)
			throw new IllegalArgumentException("ID<0");
		if (crew == null) {
			throw new RuntimeException("Crew with Id: " + id + " not found");
		}		
		return crew;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}	
	
}
