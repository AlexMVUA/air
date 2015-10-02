package aircompanySpring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = {"/index**", "/" })
	public String index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();        

		for (GrantedAuthority ga : auth.getAuthorities() ) {
			if  (ga.getAuthority().equalsIgnoreCase("role_admin")) {				
				return "redirect:admin/";
			} else if (ga.getAuthority().equalsIgnoreCase("role_supervisor")) {
				return "redirect:supervisor/";
			}        	
		}	


		return "index";
	}
	
	/*@RequestMapping(value = "hashpass", method = RequestMethod.GET)
	@ResponseBody
	public String adminPass(@RequestParam String pass) {
		String hashedPass = passwordEncoder.encode(pass);
		System.out.println(hashedPass);
		
		return hashedPass;
	}*/
	
}
