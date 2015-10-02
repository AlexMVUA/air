package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.Plane;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.PlaneRepository;

@Repository
public class JPAPlaneRepository implements PlaneRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public void save(Plane plane) {
		em.persist(plane);
	}

	@Override
	public void update(Plane plane) {
		if (plane.getId() != null) {
			em.merge(plane);
		}
	}

	@Override
	public void remove(Long id) {
		Plane plane = em.find(Plane.class, id);
		if (plane != null) {
			em.remove(plane);
		}
	}

	@Override
	public Plane findById(Long id) {
		return em.find(Plane.class, id);
	}

	@Override
	public List<Plane> findAllPlanes() {
		TypedQuery<Plane> query = em.createNamedQuery(
				"Plane.findAllPlanes", Plane.class);
		return query.getResultList();
	}

	@Override
	public boolean findSamePlane(Plane plane) throws NotUniqueEntityException {
		TypedQuery<Plane> query = em.createNamedQuery(
				"Plane.findSamePlane", Plane.class);
		query.setParameter("model", plane.getModel());			
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
