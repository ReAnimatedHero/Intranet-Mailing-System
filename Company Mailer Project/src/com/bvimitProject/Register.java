package com.bvimitProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bvimitProject.ConProvider;
import com.bvimitProject.Formatter;
public class Register {

	public static int save(String name,String department,String email,String password,String gender,String dob,String addressLine,String city,String state,String country,String contact){
		int status=0;
		java.sql.Date sqlDOB=Formatter.getSqlDate(dob);
		try{
			Connection con=ConProvider.getConnection();
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			PreparedStatement ps=con.prepareStatement("insert into company_user(name,department,email,password,gender,dob,addressLine,city,state,country,contact,registereddate,authorized) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,department);
			ps.setString(3,email);
			ps.setString(4,password);
			ps.setString(5,gender);
			ps.setDate(6,sqlDOB);
			ps.setString(7,addressLine);
			ps.setString(8,city);
			ps.setString(9,state);
			ps.setString(10,country);
			ps.setString(11,contact);
			ps.setDate(12,Formatter.getCurrentDate());
			ps.setString(13,"yes");
			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		
		
		return status;
	}
	
}
