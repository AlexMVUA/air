package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.Flight;
import aircompanySpring.repository.NotUniqueEntityException;

public interface FlightService {
	
	public List<Flight> findAllFlights();
	
	public List<Flight> findAllFlightsByRoute(Long routeId);
	
	public void save(Flight flight) throws NotUniqueEntityException;

	public void update(Flight flight) throws NotUniqueEntityException;
	
	public void remove(Long id);

	public Flight findById(Long id);

	public List<Flight> searchFlights(String searchString);
	
	public boolean isUnique(Flight flight) throws NotUniqueEntityException;
	
}
