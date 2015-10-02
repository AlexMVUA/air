package aircompanySpring.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aircompanySpring.domain.Position;
import aircompanySpring.repository.PositionRepository;
import aircompanySpring.service.PositionService;

@Service
public class JPAPositionService implements PositionService {

	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public List<Position> findAllPositions() {
		return positionRepository.findAllPositions();
	}

	@Override
	public Position findById(Long id) {
		return positionRepository.findById(id);
	}

}
