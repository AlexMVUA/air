package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.Route;
import aircompanySpring.repository.NotUniqueEntityException;

public interface RouteService {
	
	public void save(Route route) throws NotUniqueEntityException;

	public void update(Route route) throws NotUniqueEntityException;
	
	public void remove(Long id);

	public Route findById(Long id);

	public List<Route> findAllRoutes();
	
	public List<Route> searchRoutes(String string);
	
	public boolean isUnique(Route route) throws NotUniqueEntityException;
}
