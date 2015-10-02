package aircompanySpring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LanguageController {

	@RequestMapping(value = "**/changeLanguage", method = {RequestMethod.POST})
	public String changeLanguage(
			@RequestParam String locale,		
			HttpServletRequest request,
			HttpSession session) {
		request.getSession().setAttribute("locale", locale);		
		String referrer = request.getHeader("referer");
		return "redirect:" + referrer;
		
	}
}
