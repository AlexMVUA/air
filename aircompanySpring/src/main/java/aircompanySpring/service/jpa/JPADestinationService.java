package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aircompanySpring.domain.Destination;
import aircompanySpring.repository.DestinationRepository;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.service.DestinationService;

@Service
public class JPADestinationService implements DestinationService {

	@Resource
	private DestinationRepository destinationRepository;

	@Override
	@Transactional
	public void save(Destination destination) throws NotUniqueEntityException {
		if (isUnique(destination)) {
			destinationRepository.save(destination);			
		}
	}

	@Override
	@Transactional
	public void update(Destination destination) throws NotUniqueEntityException {
		if (isUnique(destination)) {
			destinationRepository.update(destination);			
		} 
	}

	@Override
	@Transactional
	public void remove(Long id) {
		destinationRepository.remove(id);
	}

	@Override
	public Destination findById(Long id) {
		return destinationRepository.findById(id);
	}

	@Override
	public List<Destination> findAllDestinations() {
		return destinationRepository.findAllDestinations();
	}

	@Override
	public boolean isUnique(Destination destination) throws NotUniqueEntityException {
		return !destinationRepository.findSameDestination(destination);
	}


}
