package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfiugration.class)
@ActiveProfiles("dev")
public class PaintTest {
	@Autowired 
	@Qualifier("red")
	Color color;
	
	@Test
	public void test(){
		System.out.println("color:" + color.getColor());
	}
}
