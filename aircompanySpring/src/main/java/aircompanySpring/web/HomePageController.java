package aircompanySpring.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
	
	
	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	public String goHome() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        
        for (GrantedAuthority ga : auth.getAuthorities() ) {
        	if  (ga.getAuthority().equalsIgnoreCase("role_admin")) {				
				return "redirect:admin/";
			} else if (ga.getAuthority().equalsIgnoreCase("role_supervisor")) {
				return "redirect:supervisor/";
			}      	
        }				
		return "redirect:";
	}
}
