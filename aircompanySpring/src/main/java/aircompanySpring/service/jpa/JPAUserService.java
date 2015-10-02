package aircompanySpring.service.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aircompanySpring.domain.User;
import aircompanySpring.repository.UserRepository;
import aircompanySpring.service.UserService;

@Service
public class JPAUserService implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		userRepository.remove(id);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	@Override
	public User getByLogin(String login) {
		return userRepository.getByLogin(login);
	}

		

}
