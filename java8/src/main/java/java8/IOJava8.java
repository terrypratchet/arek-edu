package java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOJava8 {

	public static void main(String[] args) {
		try(
				BufferedReader reader=
				new BufferedReader(
						new FileReader(
								new File("/var/log/iked.log")
								)
						);
				){
			
			Stream<String> stream = reader.lines();
			stream.forEach(System.out::println);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	
		
		Path path = Paths.get("/var/log/iked.log");
		try(
				Stream<String> line = Files.lines(path)){
			
			
			line.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Stream<Path> files = Files.list(Paths.get("/tm"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Files.walk(start, options) // subdirectory
	}

}
