package com.youtube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.youtube.rest.inventory.V1_inventory;

public class daoTester {

	public static void main(String[]args) throws Exception {
		
		V1_inventory inventory = new V1_inventory();
		inventory.returnAllClientes();
	}

		}
