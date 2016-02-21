package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.data.ArekRepository;

public class SpittleController {
	private ArekRepository spittleRepository;

	@Autowired
	public SpittleController(
	// Inject ArekRepository
			ArekRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		// attribute key: spittleList
		return "spittles";
	}

	/*
	 * @RequestMapping(method=RequestMethod.GET) public List<Spittle> spittles()
	 * { return spittleRepository.findSpittles(Long.MAX_VALUE, 20)); }
	 */
}
