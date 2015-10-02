package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.Plane;
import aircompanySpring.repository.NotUniqueEntityException;

public interface PlaneService {
	
	public void save(Plane plane) throws NotUniqueEntityException;

	public void update(Plane plane) throws NotUniqueEntityException;
	
	public void remove(Long id);

	public Plane findById(Long id);

	public List<Plane> findAllPlanes();
	
	public boolean isUnique(Plane plane) throws NotUniqueEntityException;
}
