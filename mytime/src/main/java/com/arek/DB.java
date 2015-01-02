package com.arek;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DB {
	Connection c = null;
	
	
	public static void main(String[] args) {
	   DB db = new DB();
	   db.openConnection();
	   //db.createTable();
	   db.insert();
	   db.close();

	}
	
	private void insert(){
		String sql = "INSERT INTO myTime(myDate, myDateTime) values(?,?);";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = c.prepareStatement(sql);
			
			
			preparedStatement.setDate(1, new Date(0));
			preparedStatement.setTimestamp(2, new Timestamp(0));
			
			System.out.println("query: " + preparedStatement.getClass().getCanonicalName());
			
			preparedStatement.execute();
			System.out.println("dodano rekord");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		if (preparedStatement!=null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
	}
	
	private void createTable(){
		 Statement stmt = null;
		 try {
			stmt = c.createStatement();
			
			 String sql = "CREATE TABLE myTime(myDate DATE, myDateTime DATETIME);";
			 stmt.executeUpdate(sql);
			 System.out.println("created table");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void close(){
		if(c!=null){
    		try {
				c.close();
				System.out.println("closed connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    
	}

	private  void openConnection() {
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );

	      e.printStackTrace();
	    }
	}

}
