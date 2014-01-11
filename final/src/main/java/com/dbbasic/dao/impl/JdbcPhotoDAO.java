package com.dbbasic.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbbasic.model.Car;
import com.dbbasic.model.Company;
import com.dbbasic.model.Dealer;
import com.dbbasic.model.Photo;


public class JdbcPhotoDAO extends JdbcDAO
{
	@Override
	public List<Photo> read(String query) {
		List<Photo> list = new ArrayList<Photo>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			log.info("DA success");
			
			while (rs.next()) {
				list.add(new Photo(rs.getInt("id"), rs.getString("part_name"), rs.getString("file_name"), rs.getInt("usedcar_id")));
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