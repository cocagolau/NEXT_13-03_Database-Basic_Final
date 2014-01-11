package com.dbbasic.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.dao.DAO;

public abstract class JdbcDAO implements DAO{
	
	protected static final Logger log = LoggerFactory.getLogger(JdbcDAO.class);
	
	protected Connection conn = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	protected DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int create(String query) {
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			int affectedRows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			log.info("DA success");
			
			if (affectedRows != 0) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					log.info("JdbcDAO- id: " + rs.getInt(1));
					return rs.getInt(1);
				}
			}
			stmt.close();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		finally {
			close();
		}
		return -1;
	}


	protected void close() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
