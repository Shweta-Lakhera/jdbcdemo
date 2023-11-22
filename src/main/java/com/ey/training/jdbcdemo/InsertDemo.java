package com.ey.training.jdbcdemo;
import java.sql.*;
public class InsertDemo {

	public static void main(String[] args) {
		Connection con=null;
        Statement stmt;
        ResultSet rs;  //virtual table - retrieve data and store here.
        int count;
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create a connection object using getConnection()
        	// creates session between java & mysql
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/college","root","rps@123");
        	
        	//create statement obj
        	stmt=con.createStatement();
        	String str="insert into course values(107,'IS',9500,'is@mycollege.com')";
        	
        	// for dml operations are executed with executeUpdate() statement
        	count=stmt.executeUpdate(str);
        		if(count>0) {
        		System.out.println(count+" Record inserted successfully");
        		}con.close();
        }
        catch(Exception ex) {
		ex.printStackTrace();}

}
}