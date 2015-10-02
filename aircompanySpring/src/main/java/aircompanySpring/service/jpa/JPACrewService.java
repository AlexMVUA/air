package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aircompanySpring.domain.Crew;
import aircompanySpring.repository.CrewRepository;
import aircompanySpring.service.CrewService;

@Service
public class JPACrewService implements CrewService {

	@Resource
	private CrewRepository crewRepository;
	
	@Override
	@Transactional
	public void save(Crew crew) {
		crewRepository.save(crew);
	}

	@Override
	@Transactional
	public void update(Crew crew) {
		crewRepository.update(crew);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		crewRepository.remove(id);
	}

	@Override
	public Crew findById(Long id) {
		return crewRepository.findById(id);
	}

	@Override
	public List<Crew> findAllCrews() {
		return crewRepository.findAllCrews();
	}

	@Override
	public List<Crew> findAllCrewsByPerson(Long personId) {
		return crewRepository.findAllCrewsByPerson(personId);
	}
	
	@Override
	public List<Crew> findAllCrewsByRoute(Long flightId) {
		return crewRepository.findAllCrewsByRoute(flightId);
	}

}
