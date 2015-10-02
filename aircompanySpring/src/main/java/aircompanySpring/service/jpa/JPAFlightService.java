package aircompanySpring.service.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aircompanySpring.domain.Flight;
import aircompanySpring.domain.Plane;
import aircompanySpring.repository.FlightRepository;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.service.FlightService;

@Service
public class JPAFlightService implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;	
	
	@Override
	public List<Flight> findAllFlights() {		
		return flightRepository.findAllFlights();
	}

	@Override
	public List<Flight> findAllFlightsByRoute(Long routeId) {
		return flightRepository.findAllFlightsByRoute(routeId);
	}

	@Override
	@Transactional
	public void save(Flight flight) throws NotUniqueEntityException {
		if (isUnique(flight)) {
			flightRepository.save(flight);			
		}
	}

	@Override
	@Transactional
	public void update(Flight flight) throws NotUniqueEntityException {
		if (isUnique(flight)) {
			flightRepository.update(flight);			
		}
	}

	@Override
	@Transactional
	public void remove(Long id) {
		flightRepository.remove(id);
	}

	@Override
	public Flight findById(Long id) {
		return flightRepository.findById(id);
	}

	@Override
	public List<Flight> searchFlights(String searchString) {
		return flightRepository.searchFlights(searchString);
	}
	
	@Override
	public boolean isUnique(Flight flight) throws NotUniqueEntityException {
		return !flightRepository.findSameFlight(flight);
	}
	
}
