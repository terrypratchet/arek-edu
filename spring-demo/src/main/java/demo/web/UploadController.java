package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
@RequestMapping("/arek")
public class UploadController {
	
	
	@RequestMapping( value="/form", method=RequestMethod.GET)
	public String showForm(){
		return "uploadForm";
	}
	
	@RequestMapping( value = "/form", method=RequestMethod.POST)
	public String uploadPhoto(@RequestPart("profilePicture") byte[] picture){
		System.out.println("size: " + picture.length);
		return "myColor";
	}
}
