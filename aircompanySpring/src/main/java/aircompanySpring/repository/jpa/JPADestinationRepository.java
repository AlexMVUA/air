package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.Destination;
import aircompanySpring.repository.DestinationRepository;
import aircompanySpring.repository.NotUniqueEntityException;

@Repository
public class JPADestinationRepository implements DestinationRepository {

	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;

	@Override
	public void save(Destination destination) {
		em.persist(destination);
	}

	@Override
	public void update(Destination destination) {
		if (destination.getId() != null) {
			em.merge(destination);
		}
	}

	@Override
	public void remove(Long id) {
		Destination destination = em.find(Destination.class, id);
		if (destination != null) {
			em.remove(destination);
		}
	}

	@Override
	public Destination findById(Long id) {
		return em.find(Destination.class, id);
	}

	@Override
	public List<Destination> findAllDestinations() {
		TypedQuery<Destination> query = em.createNamedQuery(
				"Destination.findAllDestinations", Destination.class);
		return query.getResultList();
	}

	@Override
	public boolean findSameDestination(Destination destination) throws NotUniqueEntityException {
		TypedQuery<Destination> query = em.createNamedQuery(
				"Destination.findSameDestination", Destination.class);
		query.setParameter("airport", destination.getAirport());
		query.setParameter("city", destination.getCity());
		query.setParameter("country", destination.getCountry());		
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
