package com.dbbasic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.model.Accident;
import com.dbbasic.model.Car;
import com.dbbasic.model.Company;
import com.dbbasic.model.Dealer;
import com.dbbasic.model.Subview;


public class JdbcSubviewDAO extends JdbcDAO
{
	
	@Override
	public List<Subview> read(String query) {
		List<Subview> list = new ArrayList<Subview>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Subview(rs.getInt("id"), rs.getString("fileName"), rs.getInt("hits"), rs.getInt("price"), rs.getString("car_name"), rs.getString("company_name")));
			}			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			close();
		}
		
		return list;
	}
	
}