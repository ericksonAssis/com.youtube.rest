package com.youtube.rest.inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.youtube.dao.*;
import com.youtube.util.*;

@Path("/v1/inventory")
public class V1_inventory {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllClientes() throws Exception{
		
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		DAO dao = new DAO();
		Response rb = null;
		try {
			conn = dao.DAOConn();
			query = conn.prepareStatement("Select * from cliente");
			ResultSet rs = query.executeQuery();
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJsonArray(rs);
			query.close();
			
			returnString = json.toString();
			rb = Response.ok(returnString).build();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null) conn.close();
		}
		return rb; 
	
	}

}
