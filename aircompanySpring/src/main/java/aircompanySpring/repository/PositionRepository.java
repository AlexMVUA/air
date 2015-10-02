package aircompanySpring.repository;

import java.util.List;
import aircompanySpring.domain.Position;

public interface PositionRepository {
	
	public List<Position> findAllPositions();
	public Position findById(Long id);
}
