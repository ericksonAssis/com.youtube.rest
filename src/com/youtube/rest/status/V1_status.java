package com.youtube.rest.status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class V1_status {

	private static final String api_version = "00.01.00";
	String returnString = null;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
		
	}
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version:</p>" + api_version;
		
	}
		@Path("/database")
		@GET
		@Produces(MediaType.TEXT_HTML)
		public String returnSelectDatabase() throws Exception{
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
				System.out.println(conn);
				query  = conn.prepareStatement("select * from cliente");
				
				ResultSet rs = query.executeQuery();
				while(rs.next()){
					firstname = rs.getString(2);
					lastname = rs.getString(3);
					email = rs.getString(4);
					date = rs.getString(5);
					
				}
				
				query.close();
				
				returnString = "<p>Nome: " + firstname + "</p>";
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally{
				if(conn != null) conn.close();
				
			}
			
				return returnString;
		}
			
		
	}
