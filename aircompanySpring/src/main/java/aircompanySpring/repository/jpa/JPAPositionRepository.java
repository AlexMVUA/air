package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.Route;
import aircompanySpring.domain.Position;
import aircompanySpring.repository.PositionRepository;

@Repository
public class JPAPositionRepository implements PositionRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public List<Position> findAllPositions() {
		TypedQuery<Position> query = 
				em.createNamedQuery("Position.findAllPositions", Position.class);
		
		return query.getResultList();
	}

	@Override
	public Position findById(Long id) {
		return em.find(Position.class, id);
	}

}
