package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Route;
import aircompanySpring.repository.NotUniqueEntityException;
import aircompanySpring.repository.RouteRepository;
import aircompanySpring.service.RouteService;

@Service
public class JPARouteService implements RouteService {

	@Resource
	private RouteRepository routeRepository;
	
	@Override
	@Transactional
	public void save(Route route) throws NotUniqueEntityException {
		if (isUnique(route)) {
			routeRepository.save(route);			
		}
	}

	@Override
	@Transactional
	public void update(Route route) throws NotUniqueEntityException {
		if (isUnique(route)) {
			routeRepository.update(route);			
		}
	}

	@Override
	@Transactional
	public void remove(Long id) {
		routeRepository.remove(id);
	}

	@Override
	public Route findById(Long id) {
		return routeRepository.findById(id);
	}

	@Override
	public List<Route> findAllRoutes() {
		return routeRepository.findAllRoutes();
	}

	@Override
	public List<Route> searchRoutes(String string) {
		return routeRepository.searchRoutes(string);
	}
	
	@Override
	public boolean isUnique(Route route) throws NotUniqueEntityException {
		return !routeRepository.findSameRoute(route);
	}
}
