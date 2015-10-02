package aircompanySpring.web;


import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aircompanySpring.domain.Plane;
import aircompanySpring.domain.User;
import aircompanySpring.domain.UserRole;
import aircompanySpring.service.PositionService;
import aircompanySpring.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	PositionService positionService;

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}


	@RequestMapping(value = "/registrationConfirm", method={RequestMethod.POST})
	public String confirmRegistration(		
			@Valid User user, 
			BindingResult result, 					
			@RequestParam String passwordConfirmation,
			Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("error", "New user wasn't register due to input errors");			
			return "registration";
		}
		
		try {
			userService.getByLogin(user.getLogin());
			model.addAttribute("error", "Already exist user with login: " + user.getLogin());
			return "registration";
		} catch (NoResultException ex) {
			if (!user.getPassword().equals(passwordConfirmation)) {
				model.addAttribute("error", "Password ("+user.getPassword() +")"
						+ " differs from password confirmation (" + passwordConfirmation);
				return "registration";
			}
		}
		
						
		user.setUserRole(UserRole.ROLE_ADMIN);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		model.addAttribute("success", "New user was successfully registered");
		return "index";
	}




	


}



