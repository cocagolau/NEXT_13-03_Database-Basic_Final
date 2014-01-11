package com.dbbasic.dao;

import java.util.List;


public interface DAO {

	public int create(String query);
	
	public List<?> read (String query);
	

}
