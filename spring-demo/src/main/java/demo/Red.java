package demo;

import org.springframework.stereotype.Component;

@Component // @Named
public class Red implements Color {

	@Override
	public String getColor() {
		return "red";
	}

}
