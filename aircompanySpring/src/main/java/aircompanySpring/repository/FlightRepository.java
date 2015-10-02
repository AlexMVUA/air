package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Flight;

public interface FlightRepository {

	public List<Flight> findAllFlights();

	public void save(Flight flight);

	public void update(Flight flight);

	public void remove(Long id);

	public Flight findById(Long id);

	public List<Flight> findAllFlightsByRoute(Long routeId);

	public List<Flight> searchFlights(String searchString);

	public boolean findSameFlight(Flight flight) throws NotUniqueEntityException;

}
