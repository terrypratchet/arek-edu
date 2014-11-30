package com.arek;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class  Plum implements Serializable{
	 String color ="red";
	 transient String taste = "sour"
			 ;
	private void writeObject(ObjectOutputStream o){
		System.out.println("zapisuje");
		try {
			o.defaultWriteObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return color + " - " + taste;
	}
	
}

public class Serialization {

	public static void main(String[] args) {
		Plum plum = new Plum();
		plum.color = "yellow";
		

		System.out.println("plum: " + plum);
		
		try {
			FileOutputStream os = new FileOutputStream("serial");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(plum);
			oos.flush();
			oos.close();
			
			InputStream is = new FileInputStream("serial");
			ObjectInputStream ois = new ObjectInputStream(is);
			Plum plum2 = (Plum) ois.readObject();
			ois.close();
			
			System.out.println("plum2: " + plum2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		

	}

}
