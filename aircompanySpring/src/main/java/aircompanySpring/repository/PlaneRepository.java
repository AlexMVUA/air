package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Plane;

public interface PlaneRepository {
	
	public void save(Plane plane);
	
	public void update(Plane plane);
	
	public void remove(Long id);
	
	public Plane findById(Long id);
	
	public List<Plane> findAllPlanes();

	public boolean findSamePlane(Plane plane) throws NotUniqueEntityException;
}
