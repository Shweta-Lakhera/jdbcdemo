package com.ey.training.jdbcdemo;

/**
 * jdbc program to connect to mysql db & fetch records
 *
 */
import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        Connection con=null;
        Statement stmt;
        ResultSet rs;  //virtual table - retrieve data and store here.
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create a connection object using getConnection()
        	// creates session between java & mysql
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/classicmodels","root","rps@123");
        	
        	//create statement obj
        	stmt=con.createStatement();
        	
        	//execute query & store data in Resultset
        	rs=stmt.executeQuery("select * from employees");
        	
        	//Traverse the Resultset
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")
        		+" "+rs.getString(8));
        	}
        	con.close();
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
