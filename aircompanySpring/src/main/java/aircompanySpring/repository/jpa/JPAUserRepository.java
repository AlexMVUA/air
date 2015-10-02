package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.User;
import aircompanySpring.domain.UserRole;
import aircompanySpring.repository.UserRepository;

@Repository
public class JPAUserRepository implements UserRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	EntityManager em;
	
	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public void update(User user) {
		if (user.getId() != null) {
			em.merge(user);
		}
	}

	@Override
	public void remove(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.getAllUsers",
				User.class);
		return query.getResultList();
	}	

	@Override
	public User getByLogin(String login) {
		TypedQuery<User> query = em.createNamedQuery("User.getByLogin",
				User.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

}
