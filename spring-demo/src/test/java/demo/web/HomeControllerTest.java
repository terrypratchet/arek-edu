package demo.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import demo.Spittle;
import demo.data.ArekRepository;

public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		assertEquals("home", controller.home());
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

	/*
	@Test
	public void shouldShowRecentSpittles() throws Exception {
	List<Spittle> expectedSpittles = createSpittleList(20);
	ArekRepository mockRepository =mock(ArekRepository.class);
	when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
	.thenReturn(expectedSpittles);
	SpittleController controller =
	new SpittleController(mockRepository);
	SpittleController controller =
	new SpittleController(mockRepository);
	MockMvc mockMvc = standaloneSetup(controller)
	Mock Spring MVC
	.setSingleView(
	new InternalResourceView("/WEB-INF/views/spittles.jsp"))
	.build();
	mockMvc.perform(get("/spittles"))
	GET /spittles
	.andExpect(view().name("spittles"))
	.andExpect(model().attributeExists("spittleList"))
	.andExpect(model().attribute("spittleList",
	hasItems(expectedSpittles.toArray())));
	}
	*/
}
