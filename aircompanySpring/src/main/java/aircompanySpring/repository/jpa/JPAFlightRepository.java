package aircompanySpring.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import aircompanySpring.domain.Flight;
import aircompanySpring.repository.FlightRepository;
import aircompanySpring.repository.NotUniqueEntityException;

@Repository
public class JPAFlightRepository implements FlightRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public List<Flight> findAllFlights() {
		TypedQuery<Flight> query =
				em.createNamedQuery("Flight.findAllFlights", Flight.class);
		return query.getResultList();
	}

	@Override
	public List<Flight> findAllFlightsByRoute(Long routeId) {
		TypedQuery<Flight> query =
				em.createNamedQuery("Flight.findAllFlightsByFlightId", Flight.class);
		return query.setParameter("routeId", routeId).getResultList();	
	}

	@Override
	public void save(Flight flight) {
		em.persist(flight);
	}

	@Override
	public void update(Flight flight) {
		if (flight.getId() != null) {
			em.merge(flight);
		}
	}

	@Override
	public void remove(Long id) {
		Flight flight = em.find(Flight.class, id);
		if (flight != null) {
			em.remove(flight);
		}		
	}

	@Override
	public Flight findById(Long id) {
		return em.find(Flight.class, id);
	}

	@Override
	public List<Flight> searchFlights(String string) {
		TypedQuery<Flight> query = em.createNamedQuery(
				"Flight.searchFlights", Flight.class);
		query.setParameter("searchString", "%"+string+"%");
		
		return query.getResultList();
	}
	
	@Override
	public boolean findSameFlight(Flight flight) throws NotUniqueEntityException {
		TypedQuery<Flight> query = em.createNamedQuery(
				"Flight.findSameFlight", Flight.class);
		//query.setParameter("name", flight.getName());	
		query.setParameter("route", flight.getRoute());		
		query.setParameter("departure", flight.getDeparture());		
		query.setParameter("arrival", flight.getArrival());				
		try {
			query.getSingleResult();
			throw new NotUniqueEntityException();
		} catch(NoResultException ex) {
			return false;
		} catch (NonUniqueResultException ex) {
			throw new NotUniqueEntityException();
		}
	}
}
