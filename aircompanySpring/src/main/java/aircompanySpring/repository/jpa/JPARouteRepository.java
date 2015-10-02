package aircompanySpring.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import aircompanySpring.domain.Route;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.RouteRepository;

@Repository
public class JPARouteRepository implements RouteRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public void save(Route route) {
		em.persist(route);
	}

	@Override
	public void update(Route route) {
		if (route.getId() != null) {
			em.merge(route);
		}
	}

	@Override
	public void remove(Long id) {
		Route route = em.find(Route.class, id);
		if (route != null) {
			em.remove(route);
		}
	}

	@Override
	public Route findById(Long id) {
		return em.find(Route.class, id);
	}

	@Override
	public List<Route> findAllRoutes() {
		TypedQuery<Route> query = em.createNamedQuery(
				"Route.findAllRoutes", Route.class);
		return query.getResultList();
	}

	@Override
	public List<Route> searchRoutes(String string) {
		TypedQuery<Route> query = em.createNamedQuery(
				"Route.searchRoutes", Route.class);
		query.setParameter("searchString", "%"+string+"%");		
		return query.getResultList();
	}
	
	@Override
	public boolean findSameRoute(Route route) throws NotUniqueEntityException {
		TypedQuery<Route> query = em.createNamedQuery(
				"Route.findSameRoute", Route.class);		
		query.setParameter("destinationFromID", route.getDestinationFrom().getId());		
		query.setParameter("destinationToID", route.getDestinationTo().getId());		
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
