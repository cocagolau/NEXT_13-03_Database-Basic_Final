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


public class JdbcAccidentDAO extends JdbcDAO
{
	
	@Override
	public List<Accident> read(String query) {
		List<Accident> list = new ArrayList<Accident>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Accident(rs.getInt("id"), rs.getString("date"), rs.getString("detail"), rs.getInt("usedcar_id")));
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