package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("yellow")
//@Qualifier("favourite")
public class Yellow implements Color {

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
