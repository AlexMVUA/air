package aircompanySpring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aircompanySpring.domain.Person;
import aircompanySpring.domain.Plane;
import aircompanySpring.domain.Position;
import aircompanySpring.repository.NotUniqueEntityException;

@Controller
@RequestMapping("/supervisor")
public class PersonController  extends AbstractController {	

	@RequestMapping(value = "/addPerson", method = {RequestMethod.GET})
	public String addPerson(ModelMap model) {
		
		model.addAttribute("positionList", positionService.findAllPositions());
		model.addAttribute("person", new Person());
		return "person/add_person";
	}

	@RequestMapping(value = "/confirmAddPerson", method = {RequestMethod.POST})
	public String confirmAddPerson(
			@Valid Person person, 
			BindingResult result, 
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(result.hasErrors()) {			
			model.addAttribute("positionList", positionService.findAllPositions());
			model.addAttribute("error", "adding new person fails due to errors");
			return "person/add_person";
		}		
		try {
			personService.save(person);
			redirectAttributes.addFlashAttribute("success", "added new person successfully");
			return "redirect:home";
		} catch (NotUniqueEntityException e) {
			model.addAttribute("error", "added new person fail - such person already exist");			
			return "person/add_person";
		}		
	}

	@RequestMapping(value = "/removePerson", method = {RequestMethod.GET})
	public String removeFlight(
			Model model, 
			@RequestParam("personId") Person person) {

		model.addAttribute("person", person);
		return "person/delete_person";
	}	

	@RequestMapping(value = "/confirmRemovePerson", method = {RequestMethod.POST})
	public String confirmRemovePerson(
			Model model, 
			@RequestParam Long personId) {
		personService.remove(personId);
		model.addAttribute("success", "remove existing person successfully");
		return "redirect:";
	}	

	@RequestMapping(value = "/editPerson", method = {RequestMethod.GET})
	public String editPerson(
			@RequestParam("personId") Long personId,
			@ModelAttribute("person") Person person,
			Model model) {

		if (model.asMap().containsKey("editPersonFormBindingResult")) {
			model.addAttribute("org.springframework.validation.BindingResult.person",
					model.asMap().get("editPersonFormBindingResult"));
		}		
		List<Position> positionList = positionService.findAllPositions();
		model.addAttribute("positionList", positionList);
		model.addAttribute("person", person);
		model.addAttribute("personId", personId);
		model.addAttribute("personOriginal", personService.findById(personId));
		return "person/edit_person";
	}

	@RequestMapping(value = "/confirmEditPerson", method = {RequestMethod.POST})
	public String confirmEditPerson(
			@RequestParam("personId") Person personInitial,
			@Valid  @ModelAttribute("person") Person person,			
			final BindingResult bindingResult,			
			ModelMap model,
			RedirectAttributes redirectAttributes){

		if(bindingResult.hasErrors()) {			
			model.addAttribute("positionList", positionService.findAllPositions());	
			model.addAttribute("error", "edit existing person fails due to errors");
			redirectAttributes.addFlashAttribute("person", person);
			redirectAttributes.addFlashAttribute("editPersonFormBindingResult", bindingResult);
			return "redirect:editPerson?personId=" + personInitial.getId();
		}
		
		if (personInitial.equals(person)) {			
			redirectAttributes.addFlashAttribute("success", "no changes were made");
			return "redirect:home";
		}
		personInitial.setSurname(person.getSurname());
		personInitial.setName(person.getName());
		personInitial.setLastName(person.getLastName());
		personInitial.setMobile(person.getMobile());
		personInitial.setEmail(person.getEmail());
		personInitial.setBirthday(person.getBirthday());
		personInitial.setExperience(person.getExperience());
		personInitial.setPosition(person.getPosition());		

		try {
			personService.update(personInitial);
			redirectAttributes.addFlashAttribute("success", "editing existing person was successful");
			return "redirect:home";
		} catch (NotUniqueEntityException e) {
			redirectAttributes.addFlashAttribute("error", "editing existing plane - such plane already exist");		
			redirectAttributes.addFlashAttribute("personId", personInitial.getId());
			return "redirect:editPerson?personId=" + personInitial.getId();
		}
		
	}

	@RequestMapping(value = "/searchPersons", method = {RequestMethod.GET})
	public String searchPersons(
			Model model,
			@RequestParam String searchString) {
		List<Person> personList = personService.searchPersons(searchString);
		model.addAttribute("personList", personList);
		model.addAttribute("searchString", searchString);
		return "person/search_persons";
	}

	@RequestMapping(value = "/viewPersons", method = {RequestMethod.GET})
	public String viewPersons(Model model) {
		List<Person> personList = personService.findAllPersons();
		model.addAttribute("personList", personList);

		return "person/persons";
	}
}
