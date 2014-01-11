package com.dbbasic.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbbasic.dao.DAO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private ApplicationContext context = new ClassPathXmlApplicationContext("Dbbasic-Module.xml");
	
	@RequestMapping("/main")
	public String admin() {
		return "admin";	
	}
	
	@RequestMapping(value="/createSchema", method=RequestMethod.POST)
	public String createSchema(String type, String query) {
		String[] types = type.split(",");
		String[] querys = query.split(";,");
		
		for (int i=0; i<types.length; i++) {
			int currentType = Integer.parseInt(types[i]);
			String currentQuery = querys[i] + ";";
			// 1인 경우 read, 0인 경우 그 외
			if (currentType == 1) {
//				read(currentQuery);
			} else {
				create(currentQuery);
			}
		}
//		create(schema);
		return "redirect:/admin/main";
	}

	private void create(String sql) {
		DAO dao = (DAO) context.getBean("companyDao");
		dao.create(sql);
	}
}






