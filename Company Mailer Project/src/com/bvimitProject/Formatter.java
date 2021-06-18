package com.bvimitProject;

import java.text.SimpleDateFormat;

public class Formatter {

	public static java.sql.Date getSqlDate(String strDate){
		java.sql.Date sqlDate=null;
		try{
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate=format.parse(strDate);
		sqlDate=new java.sql.Date(utilDate.getTime());
		}catch(Exception e){System.out.println(e);}
		return sqlDate;
	}
	
	public static java.sql.Date getCurrentDate(){
		java.sql.Date sqlCurrentDate=null;
		try{
			java.util.Date utilDate=java.util.Calendar.getInstance().getTime();
			sqlCurrentDate=new java.sql.Date(utilDate.getTime());
			
		}catch(Exception e){System.out.println(e);}
		return sqlCurrentDate;
	}
}
