package com.dbbasic.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbbasic.dao.DAO;
import com.dbbasic.model.Dealer;

@Controller
@RequestMapping("/sign")
public class SignController {
	
	private static final Logger log = LoggerFactory.getLogger(SignController.class);
	private ApplicationContext context = new ClassPathXmlApplicationContext("Dbbasic-Module.xml");
	
	@RequestMapping(value="/in", method=RequestMethod.POST)
	public String signIn(String email, String password, HttpSession session) {

		String query = "SELECT * FROM dealer WHERE email = '" + email + "';";
		log.info("query: " + query);
		
		List<Dealer> dealerList = read(query);
		
		Iterator<Dealer> ir = dealerList.iterator();
		Dealer dealer = null;
		
		while (ir.hasNext()) {
			dealer = ir.next();
			if (email.equals(dealer.getEmail())) {
				if (password.equals(dealer.getPassword())) {
					session.setAttribute("userEmail", dealer.getEmail());
					session.setAttribute("userName", dealer.getName());
					return "redirect:/";
				}
				return "redirect:/";
			}
		}

		return "redirect:/";
	}
	
	@RequestMapping("/out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userEmail");
		return "redirect:/";
	}
	
	
	private List<Dealer> read(String query) {
		DAO dao = (DAO) context.getBean("dealerDao");
		return (List<Dealer>) dao.read(query);
	}
	
	
}
