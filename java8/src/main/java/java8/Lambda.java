package java8;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Consumer;

public class Lambda {
	public static void main(String[] args){
		// to make instances of anonymous classes easier to write and read
		
		
		FileFilter filFilter = new FileFilter(){

			@Override
			public boolean accept(File file) {
				return file.getName().endsWith("java");
			}
			
		};
		
		FileFilter filter = (File file) -> file.getName().endsWith("java");
		
	}
	
	public void methodReferences(){
		Consumer<String> c = s-> System.out.println(s);
		Consumer<String> c2 = System.out::print;
		
	}
	
	// lambda type is a functional interface
	// functional interface is an interface with only one abstract method
    // methods from the Object class don't count
	
	// Lambda is an object without and identity
	
	// static methods are alllowed in interfaces
	// default method in interfaces ( foreach)
	
}
