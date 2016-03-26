package demo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.Spittle;

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

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		//List<Spittle> findSpittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		Spittle s = new Spittle( "hello", new Date(3L));
		List<Spittle> findSpittles = new ArrayList<Spittle>();
		findSpittles.add(s);
		model.addAttribute(findSpittles);
		model.addAttribute("age", "young"); // ${age}
		
		// attribute key: spittleList because type: List<Spittle>
		return "spittles";
	}

	/*// the same as before
	 * @RequestMapping(method=RequestMethod.GET) public List<Spittle> spittles()
	 * { return spittleRepository.findSpittles(Long.MAX_VALUE, 20)); }
	 */
}
