package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.Crew;
import aircompanySpring.repository.CrewRepository;

@Repository
public class JPACrewRepository implements CrewRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public void save(Crew crew) {
		em.persist(crew);
	}

	@Override
	public void update(Crew crew) {
		if (crew.getId() != null) {
			em.merge(crew);
		}
	}

	@Override
	public void remove(Long id) {
		Crew crew = em.find(Crew.class, id);
		if (crew != null) {
			em.remove(crew);
		}
	}

	@Override
	public Crew findById(Long id) {
		return em.find(Crew.class, id);
	}

	@Override
	public List<Crew> findAllCrews() {
		TypedQuery<Crew> query = em.createNamedQuery(
				"Crew.findAllCrews", Crew.class);
		
		return query.getResultList();
	}

	@Override
	public List<Crew> findAllCrewsByPerson(Long personId) {
		TypedQuery<Crew> query = em.createNamedQuery(
				"Crew.findAllCrewsByPerson", Crew.class);
		query.setParameter("personId", personId);
		return query.getResultList();
	}
	
	@Override
	public List<Crew> findAllCrewsByRoute(Long flightId) {
		TypedQuery<Crew> query = em.createNamedQuery(
				"Crew.findAllCrewsByRoute", Crew.class);
		query.setParameter("flightId", flightId);
		return query.getResultList();
	}

}
