package com.arek;
import java.io.File;
import java.io.IOException;
public class FileCreation {

	public static void createFile(){
		try {
			File file = new File("fruit", "orange");
			System.out.println("createNewFile:" + file.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		createFile();

	}

}
