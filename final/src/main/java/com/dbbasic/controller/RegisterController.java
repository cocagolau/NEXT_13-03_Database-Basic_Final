package com.dbbasic.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dbbasic.dao.DAO;
import com.dbbasic.model.Car;
import com.dbbasic.model.Company;
import com.dbbasic.support.FileUploader;
import com.dbbasic.support.MultiPartFileUploadBean;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
	private ApplicationContext context = new ClassPathXmlApplicationContext("Dbbasic-Module.xml");
	
	@RequestMapping("/usedcar")
	public String registerUsedCar(Model model) {
		
		// company
		String query = "SELECT * FROM company;";
		List companyList = read("companyDao", query);
		Iterator<Company> companyIr = companyList.iterator();
		
		
		model.addAttribute("companies", companyIr);
		
		return "registerUsedCar";
	}
	
	@RequestMapping("/ajax/{companyName}")
	public @ResponseBody String registerUsedCar(@PathVariable String companyName) {
		
		log.info("company: " + companyName); 
		// company
		String query = "SELECT * FROM car WHERE company_name = '" + companyName + "';";
		List carList = read("carDao", query);
		Iterator<Car> carIr = carList.iterator();
		
		String tag = "";
		String startTag = "<option value=\"";
		String middleTag = "\">";
		String endTag = "</option>";
		
		Car car = null;
		while (carIr.hasNext()) {
			car = carIr.next();
			tag = tag + startTag + car.getId() + middleTag + car.getName() + endTag;
		}
		log.info("tag: " + tag);
		
		return tag;
	}
	
	@RequestMapping("/usedcar/submit")
	public String registerUsedCarSubmit(String mileage, String color, String dealingCondition, String dealingPrice, String detail,
			String dealerEmail, String carId, String registrationDate, String[] accidentDate, String[] accidentDetail,
			String[] photoPart, MultiPartFileUploadBean file, BindingResult bindingResult) throws IOException {
		
		String convertedRegistrationDate = convertDate(registrationDate);
		int convertedCarId = Integer.parseInt(carId);
		int storedId = 0;
		
		// log
		List<String> accidentDates = Arrays.asList(accidentDate);
		List<String> accidentDetails = Arrays.asList(accidentDetail);
		for (int i=0; i<accidentDates.size(); i++) {
			log.info("accident- date: " + accidentDates.get(i) + ",  detail: " + accidentDetails.get(i));
		}
		
		List<MultipartFile> files = file.getFiles();
	    List<String> photoFileNames = new ArrayList<String>();
	    List<String> photoParts = Arrays.asList(photoPart);
	    for (int i=0; i<files.size(); i++) {
	    	String fileName = FileUploader.upload(files.get(i));
	    	log.info ("photo(" + i + ")- photoPart: " + photoParts.get(i) + ",  photoName: " + fileName);
	    	photoFileNames.add(fileName);
	    }
	    
		
	    // usedcar
		String usedcarQuery = "INSERT INTO usedcar (mileage, color, number_of_photo, number_of_accident, dealing_condition, dealing_price, detail, registration_date, car_id, dealer_email) VALUES ("
				+ "'" + mileage + "', "
				+ "'" + color + "', "
				+ "'" + photoFileNames.size() + "', "
				+ "'" + accidentDates.size() + "', "
				+ "'" + dealingCondition + "', "
					  + dealingPrice + ", "
				+ "'" + detail + "', "
				+ "'" + convertedRegistrationDate + "', "
					  + convertedCarId + ", "
				+ "'" + dealerEmail + "');";
		
		log.info("query: " + usedcarQuery);
		
		try {
			storedId = create("usedcarDao", usedcarQuery);
			
			if (storedId > 0) {
				log.info("car- id: " + storedId);
			}
			
			// accident
						
			String accidentQuery = "INSERT INTO accident (date, detail, usedcar_id) VALUES ";
			String query1 = "";
			for (int i=0; i<accidentDates.size(); i++) {
				query1 = query1 + "('" + accidentDates.get(i) + "', '" + accidentDetails.get(i) +"', " + storedId + ")";
				if (i+1 != accidentDates.size()) {
					query1 = query1 + ", ";
				}
			}
			accidentQuery = accidentQuery + query1 + ";";
			log.info("car - accidentQuery: " + accidentQuery);
			
			create("accidentDao", accidentQuery);
			
			
			
			// photopart
		    String photoQuery = "INSERT INTO photo (part_name, file_name, usedcar_id) VALUES ";
			String query2 = "";
			log.info("photoFile size: " + photoFileNames.size());
			for (int i=0; i<photoFileNames.size(); i++) {
				query2 = query2 + "('" + photoParts.get(i) + "', '" + photoFileNames.get(i) +"', " + storedId + ")";
				if (i+1 != photoFileNames.size()) {
					query2 = query2 + ", ";
				}
			}
			photoQuery = photoQuery + query2 + ";";
			log.info("car - photoQuery: " + photoQuery);
			
			create("photoDao", photoQuery);
			
		}
					
		catch (Exception e) {
			log.error("usedcarSubmit error: " + e);

			return "redirect:/usedcar";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/car")
	public String registerCar(Model model) {
		
		String query = "SELECT * FROM company;";
		List companyList = read("companyDao", query);
		Iterator<Company> companyIr = companyList.iterator();
		
		model.addAttribute("companies", companyIr);
		
		return "registerCar";
	}
	
	@RequestMapping(value="/car/submit", method=RequestMethod.POST)
	public String registerCarSubmit(String companyName, String name, String type, String engineType, String engineDisplacement, String engineGasType, String engineGasEfficiency, String engineOutput, String driveType, String gearbox, String passenger, String modelYear) {
		log.info("car - "
				+ "companyName: " + companyName + ",  "
				+ "name: " + name + ",  "
				+ "type: " + type + ",  "
				+ "engineType: " + engineType + ",  "
				+ "engineDisplacement: " + engineDisplacement + ",  "
				+ "engineGasType: " + engineGasType + ",  "
				+ "engineGasEfficiency: " + engineGasEfficiency + ",  " 
				+ "engineOutput: " + engineOutput + ",  "
				+ "dirveType: " + driveType + ",  "
				+ "gearbox: " + gearbox + ",  "
				+ "passenger: " + passenger + ",  "
				+ "modelYear: " + modelYear);
		
		String query = "INSERT INTO car (company_name, name, type, engine_type, engine_displacement, engine_gas_type, engine_gas_efficiency, engine_output, drive_type, gearbox, passenger, model_year) "
				+ "VALUES ('" + companyName + "', '" + name + "', '" + type + "', '"
				+ engineType + "', " + engineDisplacement + ", '" + engineGasType + "', " + engineGasEfficiency + ", " + engineOutput + ", '"
				+ driveType + "', '" + gearbox + "', " + passenger + ", " + modelYear + ");"; 

		
		create ("carDao", query);
				
		return "redirect:/admin/main";
	}
	
	
	
	@RequestMapping("/company")
	public String registerCompany() {		
		return "registerCompany";
	}
	@RequestMapping(value="/company/submit", method=RequestMethod.POST)
	public String registerCompanySubmit(String company, String location) {
		log.info("company name: " + company + ",  loaction: " + location);
		
		String query = "INSERT INTO company (name, location) "
				+ "VALUES ('" + company + "', '" + location + "');"; 
 
		log.info("query: " + query);
		
		create ("companyDao", query);		
		
		return "redirect:/admin/main";
	}
	
	@RequestMapping("/dealer")
	public String registerDealer() {
		return "registerDealer";
	}
	
	
	// submit
	@RequestMapping(value="/dealer/submit", method=RequestMethod.POST)
	public String registerDealer(String email, String password, String name, String phone, String date) {
		log.info("email: " + email + ",  password: " + password + ",  name: " + name + ", phone: " + phone);
	
		String admissionDate = convertDate(date);
		log.info("admissionDate: " + admissionDate);
				
		String query = "INSERT INTO dealer (email, password, name, phone, admission_date) VALUES ('" + email + "', '" + password + "', '"+ name + "', '" + phone + "', '" + admissionDate + "');";
		log.info("query: " + query);
		
		create ("dealerDao", query);		
		return "redirect:/";
	}
	
	
	
	private String convertDate (String date) {
		long millis = Long.parseLong(date);
		
		DateFormat dateFormat = new SimpleDateFormat("YY-MM-dd HH:mm:ss");
		String convertedDate = dateFormat.format(new Date(millis));
		
		return convertedDate;
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
