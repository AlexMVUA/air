package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Person;

public interface PersonRepository {
	
	public void save(Person person);
	
	public void update(Person person);
	
	public void remove(Long id);
	
	public Person findById(Long id);
	
	public List<Person> findAllPersons();

	public List<Person> searchPersons(String searchString);	

	boolean findSamePerson(Person person) throws NotUniqueEntityException;
}
