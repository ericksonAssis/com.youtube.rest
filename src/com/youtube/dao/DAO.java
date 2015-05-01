package com.youtube.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.naming.*;
import javax.sql.*;

public class DAO {
	
	public Connection DAOConn(){
		
		Connection conn = null;
		PreparedStatement query = null;
		String returnString = null;
		String firstname = null;
		String lastname = null;
		String email = null;
		String date = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root","root");
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}

	
}
