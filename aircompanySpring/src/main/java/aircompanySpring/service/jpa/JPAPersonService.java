package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aircompanySpring.domain.Person;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.PersonRepository;
import aircompanySpring.service.PersonService;

@Service
public class JPAPersonService implements PersonService {

	@Resource
	private PersonRepository personRepository;
	
	@Override
	@Transactional
	public void save(Person person) throws NotUniqueEntityException {
		if (isUnique(person)) {
			personRepository.save(person);			
		}
	}

	@Override
	@Transactional
	public void update(Person person) throws NotUniqueEntityException {
		if (isUnique(person)) {
			personRepository.update(person);			
		}
	}

	@Override
	@Transactional
	public void remove(Long id) {
		personRepository.remove(id);
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public List<Person> findAllPersons() {
		return personRepository.findAllPersons();
	}

	@Override
	public List<Person> searchPersons(String searchString) {
		return personRepository.searchPersons(searchString);
	}
	
	@Override
	public boolean isUnique(Person person) throws NotUniqueEntityException {
		return !personRepository.findSamePerson(person);
	}
}
