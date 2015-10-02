package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.Destination;
import aircompanySpring.repository.NotUniqueEntityException;

public interface DestinationService {
	
	public void save(Destination destination) throws NotUniqueEntityException;

	public void update(Destination destination) throws NotUniqueEntityException;
	
	public void remove(Long id);

	public Destination findById(Long id);

	public List<Destination> findAllDestinations();
	
	public boolean isUnique(Destination destination) throws NotUniqueEntityException;
}
