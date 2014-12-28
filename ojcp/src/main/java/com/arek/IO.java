package com.arek;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class IO {

	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter("writer.txt");
			pw.print("Arek");
			pw.close();
			
			PrintWriter pw2 = new PrintWriter("writer.txt");
			pw2.append("Toman");
			
			pw2.close();
			
			FileWriter fw = new FileWriter("fw.txt");
			fw.append("cudo");
			fw.close();;
			
			
			Writer wr = new FileWriter("bw.txt");
			BufferedWriter bf = new BufferedWriter(wr);
			bf.write("hej");
			bf.close();
			
			Integer.valueOf("");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
