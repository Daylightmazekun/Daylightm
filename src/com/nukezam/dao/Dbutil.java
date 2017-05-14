package com.nukezam.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	
	String url = "jdbc:mysql://localhost:3306/root" + "user=root&password=misakamikoto&useUnicode=true&characterEncoding=UTF8";

	private String jdbcName = "com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(url);
		return con;
	}
	public void closeCon(Connection con) throws Exception{
		if(con != null){
			con.close();
		}
		
	}
	//test
	public static void main(String[] args){
		Dbutil dbutil = new Dbutil();
		try {
			dbutil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
