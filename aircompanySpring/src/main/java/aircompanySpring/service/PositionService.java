package aircompanySpring.service;

import java.util.List;
import aircompanySpring.domain.Position;

public interface PositionService {
	
	public List<Position> findAllPositions();	
	public Position findById(Long id);
}
