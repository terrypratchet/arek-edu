package demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // @Named
@Primary
public class Red implements Color {

	@Override
	public String getColor() {
		return "red";
	}

}
