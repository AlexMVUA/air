package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Destination;

public interface DestinationRepository {
	
	public void save(Destination destination);
	
	public void update(Destination destination);
	
	public void remove(Long id);
	
	public Destination findById(Long id);
	
	public List<Destination> findAllDestinations();

	public boolean findSameDestination(Destination destination) throws NotUniqueEntityException;
}
