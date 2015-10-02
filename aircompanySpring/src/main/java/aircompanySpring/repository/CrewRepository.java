package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.Crew;

public interface CrewRepository {
	
	public void save(Crew crew);
	
	public void update(Crew crew);
	
	public void remove(Long id);
	
	public Crew findById(Long id);
	
	public List<Crew> findAllCrews();

	public List<Crew> findAllCrewsByPerson(Long personId);

	public List<Crew> findAllCrewsByRoute(Long routeId);
}
