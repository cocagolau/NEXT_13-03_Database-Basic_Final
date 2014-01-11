package com.dbbasic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.model.Car;
import com.dbbasic.model.Company;
import com.dbbasic.model.Dealer;
import com.dbbasic.model.Usedcar;


public class JdbcUsedcarDAO extends JdbcDAO
{
	
	@Override
	public List<Usedcar> read(String query) {
		List<Usedcar> list = new ArrayList<Usedcar>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Usedcar(rs.getInt("id"), rs.getInt("mileage"), rs.getString("color"), rs.getInt("number_of_photo"), rs.getInt("number_of_accident"), rs.getString("dealing_condition"), rs.getInt("dealing_price"), rs.getString("dealing_solddate"), rs.getString("detail"), rs.getString("registration_date"), rs.getInt("hits"), rs.getInt("car_id"), rs.getString("dealer_email")));
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