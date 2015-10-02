package aircompanySpring.repository;

import java.util.List;

import aircompanySpring.domain.User;
import aircompanySpring.domain.UserRole;

public interface UserRepository {
	
	public void save(User user);
	
	public void update(User user);
	
	public void remove(Long id);
	
	public User findById(Long id);
	
	public List<User> findAllUsers();
	
	public User getByLogin(String login);

}
