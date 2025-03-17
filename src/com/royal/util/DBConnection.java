package com.royal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection 
{
	private static Connection conn = null;
	// 1) private constructor
	private DBConnection() 
	{
		
	} 
	// 2) make one static method
	public static Connection getConnection() 
	{
		if(conn != null) 
		{
			return conn;
		}else 
		{
			conn = getConnectionObject();
		}
		return conn;
	}
	
	private static Connection getConnectionObject() 
	{
		FileInputStream fin = null;
		Properties prop = null;
		try {
			fin = new FileInputStream(
					"");

			prop = new Properties();

			prop.load(fin);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String urlName = prop.getProperty("urlName").trim();
		String driverClass = prop.getProperty("driverClass").trim();
		String userName = prop.getProperty("userName").trim();
		String password = prop.getProperty("password").trim();

		Connection conn = null;
		try {
			// 1) load driverClass
			Class.forName(driverClass);

			// 2) pass credential to DruverManager
			conn = DriverManager.getConnection(urlName, userName, password);

			if (conn != null) {
				System.out.println("Db Connected");
			} else {
				System.out.println("Db not Connected");
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
