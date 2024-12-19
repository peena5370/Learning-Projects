package com.learning.demo.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:6036/demo_db";
  static final String USER = "root";
  static final String PASS = "password";

  public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	       // register JDBC driver
	       Class.forName(JDBC_DRIVER);

	       // Opening connection
	       System.out.println("Connecting database...");
	       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	       // Query SELECT
	       System.out.println(" Visualize statement object...");
	       stmt = conn.createStatement();
	       String sql;
	       sql = "SELECT CustID, CustName, CustAddress, CustPhone FROM customer";
	       ResultSet rs = stmt.executeQuery(sql);

	       while(rs.next()){
	           // get input
	           int id  = rs.getInt("CustID");
	           String name = rs.getString("CustName");
	           String addr = rs.getString("CustAddress");
	           String phone = rs.getString("CustPhone");

	               // output
	           System.out.print("ID: " + id);
	           System.out.print(", Name: " + name);
	           System.out.print(", Address: " + addr);
	           System.out.print(", Phone: " + phone);
	           System.out.print("\n");
	       }

	       rs.close();
	       stmt.close();
	       conn.close();
	   }catch(SQLException se){
	       // exception for JDBC error
	       se.printStackTrace();
	   }catch(Exception e){
	       // exception for Class.forName error
	       e.printStackTrace();
	   }finally{
	       // closing connection
	       try{
	           if(stmt!=null) stmt.close();
	       }catch(SQLException se2){
	    	// nothing to do here
	       }
	       try{
	           if(conn!=null) conn.close();
	       }catch(SQLException se){
	           se.printStackTrace();
	       }
	   }
	   System.out.println("Goodbye!");
  }
}
