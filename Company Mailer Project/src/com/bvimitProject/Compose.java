package com.bvimitProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bvimitProject.ConProvider;
import com.bvimitProject.Formatter;

public class Compose {

	public static int save(String sender,String receiver,String subject,String message){
		int status=0;
		try{
			Connection con=ConProvider.getConnection();
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			PreparedStatement ps=con.prepareStatement("insert into mailer_message(id,sender,receiver,subject,message,trash,messagedate) values(id.nextval,?,?,?,?,?,?)");
			ps.setString(1,sender);
			ps.setString(2,receiver);
			ps.setString(3,subject);
			ps.setString(4,message);
			ps.setString(5,"no");
			ps.setDate(6,Formatter.getCurrentDate());
			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
				
		return status;
	}
	
}
