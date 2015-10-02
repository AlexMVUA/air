package aircompanySpring.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aircompanySpring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {
	
	@Autowired
	UserService userService;	
	
	@RequestMapping(value = "/", method={RequestMethod.GET}) 
	public String goHomeUserPage(Model model, Locale locale) {
		System.out.println("LOCALE:" + locale.toString());
		return "homeuser";
	}
	
}
