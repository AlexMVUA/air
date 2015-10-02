package aircompanySpring.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import aircompanySpring.domain.Person;
import aircompanySpring.domain.Plane;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.PersonRepository;

@Repository
public class JPAPersonRepository implements PersonRepository {
	
	@PersistenceContext(name = "HibernateMySQL")
	private EntityManager em;
	
	@Override
	public void save(Person person) {
		em.persist(person);
	}

	@Override
	public void update(Person person) {
		if (person.getId() != null) {
			em.merge(person);
		}
	}

	@Override
	public void remove(Long id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			em.remove(person);
		}
	}

	@Override
	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> findAllPersons() {
		TypedQuery<Person> query = em.createNamedQuery(
				"Person.findAllPersons", Person.class);
		return query.getResultList();
	}
	
	@Override
	public List<Person> searchPersons(String searchString) {
		TypedQuery<Person> query = em.createNamedQuery(
				"Person.searchPersons", Person.class);
		String searchParam = "%"+searchString+"%";
		query.setParameter("searchString", searchParam);
		
		return query.getResultList();
	}
	
	@Override
	public boolean findSamePerson(Person person) throws NotUniqueEntityException {
		TypedQuery<Person> query = em.createNamedQuery(
				"Person.findSamePerson", Person.class);
		query.setParameter("surname", person.getSurname());
		query.setParameter("email", person.getEmail());
		
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
