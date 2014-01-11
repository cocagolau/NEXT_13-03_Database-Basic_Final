package com.dbbasic.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbbasic.dao.DAO;
import com.dbbasic.model.Accident;
import com.dbbasic.model.Car;
import com.dbbasic.model.Dealer;
import com.dbbasic.model.Photo;
import com.dbbasic.model.Usedcar;

@Controller
@RequestMapping("/list")
public class ListController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	private ApplicationContext context = new ClassPathXmlApplicationContext("Dbbasic-Module.xml");

	@RequestMapping("/view/{id}")
	public String viewArticle(@PathVariable Long id, Model model) {
		log.info ("id: " + id);
		String hitQuery = "UPDATE usedcar SET hits = hits + 1 WHERE id = " + id + ";";
		create ("usedcarDao", hitQuery);
		
		
		//usedcar
		String usedcarQuery = "SELECT * FROM usedcar WHERE id = " + id + ";";
		log.info("usedcar query: " + usedcarQuery);
		List usedcarList = read("usedcarDao", usedcarQuery);
		Usedcar usedcar = (Usedcar) usedcarList.get(0);
		
		
		//photo
		String photoQuery = "SELECT * FROM photo WHERE usedcar_id = " + id +";";
		log.info("photo query: " + photoQuery);
		List photoList = read("photoDao", photoQuery);
		Iterator<Photo> photoIr = photoList.iterator();
		
		
		// accident
		String accidentQuery = "SELECT * FROM accident WHERE usedcar_id = " + id + ";";
		log.info("accident query: " + accidentQuery);
		List accidentList = read("accidentDao", accidentQuery);
		Iterator<Accident> accidentIr = accidentList.iterator();
		
		
		// dealer
		String dealerEmail = usedcar.getDealerEmail();
		String dealerQuery = "SELECT * FROM dealer WHERE email = '" + dealerEmail + "';";
		log.info("dealer query: " + dealerQuery);
		List dealerList = read("dealerDao", dealerQuery);
		Dealer dealer = (Dealer) dealerList.get(0);
		
		
		// car
		int carId = usedcar.getCarId();
		String carQuery = "SELECT * FROM car WHERE id = " + carId + ";";
		log.info("car query: " + carQuery);
		List carList = read("carDao", carQuery);
		Car car = (Car) carList.get(0);
		
		
		// add in model
		model.addAttribute("usedcar", usedcar);
		model.addAttribute("dealer", dealer);
		model.addAttribute("car", car);
		model.addAttribute("photos", photoIr);
		model.addAttribute("accidents", accidentIr);		
		
		return "view";	
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
	