package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil 
{

	Connection con;
	public Connection getConnection() throws ClassNotFoundException, SQLException
	
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root", "Welcome123");
		return con;
		
		
	
	}
}
