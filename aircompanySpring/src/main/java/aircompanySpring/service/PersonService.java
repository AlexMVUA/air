package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.Person;
import aircompanySpring.repository.NotUniqueEntityException;

public interface PersonService {
	
	public void save(Person person) throws NotUniqueEntityException;

	public void update(Person person) throws NotUniqueEntityException;
	
	public void remove(Long id);

	public Person findById(Long id);

	public List<Person> findAllPersons();
	
	public List<Person> searchPersons(String searchString);
	
	public boolean isUnique(Person person) throws NotUniqueEntityException;
}
