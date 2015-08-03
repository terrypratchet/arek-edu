package demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Paint {
	@Autowired
	Color color;
	
	
	
	public void paint(){
		System.out.println("color: " + color.getColor());
	}
}
