package com.dbbasic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.model.Car;
import com.dbbasic.model.Company;
import com.dbbasic.model.Dealer;


public class JdbcCarDAO extends JdbcDAO
{
	@Override
	public List<Car> read(String query) {
		List<Car> list = new ArrayList<Car>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Car(rs.getInt("id"), rs.getString("company_name"), rs.getString("name"), rs.getString("type"), rs.getString("engine_type"), rs.getInt("engine_displacement"), rs.getString("engine_gas_type"), rs.getFloat("engine_gas_efficiency"), rs.getInt("engine_output"), rs.getString("drive_type"), rs.getString("gearbox"), rs.getInt("passenger"), rs.getInt("model_year")));
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