package aircompanySpring.service;

import java.util.List;

import aircompanySpring.domain.User;

public interface UserService {
	
	public void save(User user);
	
	public void remove(Long id);

	public void update(User user);

	public User findById(Long id);

	public List<User> findAllUsers();

	public User getByLogin(String login);


}
