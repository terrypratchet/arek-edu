package demo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.Spittle;
import demo.data.Person;
//http://localhost:8080/spittles
@Controller
@RequestMapping("/spittles")
public class SpittleController {
	//private ArekRepository spittleRepository;

	/*@Autowired
	public SpittleController(
	// Inject ArekRepository
			ArekRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}*/

	// http://localhost:8080/spittles?sth=moon
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model, @RequestParam( name = "sth",defaultValue="defaultArek") String sth) {
		//List<Spittle> findSpittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		Spittle s = new Spittle( "hello", new Date(3L));
		List<Spittle> findSpittles = new ArrayList<Spittle>();
		findSpittles.add(s);
		model.addAttribute(findSpittles);
		model.addAttribute("age", "young " + sth); // ${age}
		
		// attribute key: spittleList because type: List<Spittle>
		return "spittles";
	}

	//http://localhost:8080/spittles/cos/blue
	@RequestMapping(method = RequestMethod.GET, value = "cos/{color}")
	public String spittles2(Model model, @PathVariable String color) {
		//List<Spittle> findSpittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		Spittle s = new Spittle( "hello", new Date(3L));
		List<Spittle> findSpittles = new ArrayList<Spittle>();
		findSpittles.add(s);
		model.addAttribute(findSpittles);
		model.addAttribute("color", "It is: " + color); // ${age}
		
		// attribute key: spittleList because type: List<Spittle>
		return "myColor"; // WebConfig maps to myColor.jsp
	}
	
	
	
	/*// the same as before
	 * @RequestMapping(method=RequestMethod.GET) public List<Spittle> spittles()
	 * { return spittleRepository.findSpittles(Long.MAX_VALUE, 20)); }
	 */
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegisterForm(Model model){
		model.addAttribute("arekModleAtttribueName", new Person());
		// without name it would be type name (person)
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("arekModleAtttribueName") Person arekModleAtttribueName,  Errors  errors){

		/*
		 * it’s important
that the Errors parameter immediately follow the @Valid -annotated parameter that’s
being validated
		 */
		System.out.println("arekModleAtttribueName: " + arekModleAtttribueName.getFirstName());
		if(errors.hasErrors()){
			System.out.println("validation failed");
			return "registerForm";
		}
		System.out.println("saved " + arekModleAtttribueName.getFirstName());
		return "redirect:/spittles/p/"+arekModleAtttribueName.getFirstName();
		// or forward - considered by InternalResourceViewResolver
	}
	
	@RequestMapping(value="/p/{username}", method = RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model){
		model.addAttribute(username);
		return "profile";
	}
	
	
}
