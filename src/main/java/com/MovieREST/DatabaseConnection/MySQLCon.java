package com.MovieREST.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;


public class MySQLCon {
	
	private static Dotenv dotEnv = Dotenv.configure().directory("F:\\Java Projects 2024\\Java RestFul Web services\\Movies").load();
	
	private static final String UserName =dotEnv.get("USERNAME_DB");
	private static final String Password =dotEnv.get("PASSWORD_DB");
	
	
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("configuring vedant property");
			System.out.println("UserName :- "+UserName+" Password :- "+Password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getMYSQLConnection() {
		
		
		
		
		
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdb",UserName,Password);
			return con;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Failed to establish a database connection"); 
		}
		
		
	}
	
	
}
