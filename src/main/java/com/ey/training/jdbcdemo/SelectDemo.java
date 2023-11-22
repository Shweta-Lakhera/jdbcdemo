package com.ey.training.jdbcdemo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con=null;
        Statement stmt;
        ResultSet rs;  //virtual table - retrieve data and store here.
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create a connection object using getConnection()
        	// creates session between java & mysql
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/college","root","rps@123");
        	
        	//create statement obj
        	stmt=con.createStatement();
        	
        	//execute query & store data in Resultset
        	rs=stmt.executeQuery("select courseid,coursename,fees from course");
        	
        	//Traverse the Resultset
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
        	}
        	con.close();
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }

	}

}
