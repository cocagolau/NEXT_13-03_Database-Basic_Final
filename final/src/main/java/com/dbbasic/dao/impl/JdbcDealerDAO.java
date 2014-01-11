package com.dbbasic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.model.Dealer;


public class JdbcDealerDAO extends JdbcDAO
{

	@Override
	public List<Dealer> read(String query) {
		List<Dealer> list = new ArrayList<Dealer>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Dealer(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getString("phone"), rs.getString("admission_date"), rs.getInt("number_of_completion")));
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