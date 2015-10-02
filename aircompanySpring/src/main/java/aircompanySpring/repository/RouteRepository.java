package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Route;

public interface RouteRepository {
	
	public void save(Route route);
	
	public void update(Route route);
	
	public void remove(Long id);
	
	public Route findById(Long id);
	
	public List<Route> findAllRoutes();

	public List<Route> searchRoutes(String string);

	public boolean findSameRoute(Route route) throws NotUniqueEntityException;
}
