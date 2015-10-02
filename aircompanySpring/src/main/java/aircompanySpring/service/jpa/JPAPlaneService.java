package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import aircompanySpring.domain.Plane;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.PlaneRepository;
import aircompanySpring.service.PlaneService;

@Service
public class JPAPlaneService implements PlaneService {

	@Resource
	private PlaneRepository planeRepository;

	@Override
	@Transactional
	public void save(Plane plane)  throws NotUniqueEntityException {
		if (isUnique(plane)) {
			planeRepository.save(plane);			
		}
	}

	@Override
	@Transactional()
	public void update(Plane plane) throws NotUniqueEntityException {
		if (isUnique(plane)) {
			planeRepository.update(plane);			
		} 
	}

	@Override
	@Transactional
	public void remove(Long id) {
		planeRepository.remove(id);
	}

	@Override
	public Plane findById(Long id) {
		return planeRepository.findById(id);
	}

	@Override
	public List<Plane> findAllPlanes() {
		return planeRepository.findAllPlanes();
	}

	@Override
	public boolean isUnique(Plane plane) throws NotUniqueEntityException {
		return !planeRepository.findSamePlane(plane);
	}
}
