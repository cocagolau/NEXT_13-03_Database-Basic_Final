package com.dbbasic.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbbasic.dao.DAO;
import com.dbbasic.model.Subview;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	private ApplicationContext context = new ClassPathXmlApplicationContext("Dbbasic-Module.xml");
	
	@RequestMapping("")
	public String home(Model model) {
		
		String frontQuery =
				"SELECT subview.id, file_name AS fileName, hits, price, car_name, company_name  FROM photo JOIN " +
				  "(SELECT id, hits, dealing_price AS price, car_name, company_name  FROM usedcar JOIN " +
				    "(SELECT car.id AS car_id, car.name AS car_name, company.name AS company_name FROM car JOIN company " +
				      "ON car.company_name = company.name AND company.location='";
		String rearQuery =
				"') AS model " +
				    "ON usedcar.car_id = model.car_id) AS subview " +
				  "ON photo.usedcar_id = subview.id GROUP BY photo.usedcar_id ORDER BY subview.id DESC LIMIT 5;";
		
		
		String globalQuery = frontQuery + "global" + rearQuery;
		String localQuery = frontQuery + "local" + rearQuery;
		log.info("query: " + globalQuery);
		log.info("query: " + localQuery);
				

		// local
		List localList = read("subviewDao", localQuery);
		Iterator<Subview> lcSubviewIr = localList.iterator();
		model.addAttribute("locals", lcSubviewIr);
		
		
		// global
		List globalList = read("subviewDao", globalQuery);
		Iterator<Subview> gbSubviewIr = globalList.iterator();
		model.addAttribute("globals", gbSubviewIr);	

		return "home";
	}
	
	
	private int create (String daoName, String query) {
		DAO dao = (DAO) context.getBean(daoName);
		return dao.create(query);
	}
	private List read(String daoName, String query) {
		DAO dao = (DAO) context.getBean(daoName);
		return dao.read(query);
	}

}
