package com.examples.spring.web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.exception.LoginException;
import com.examples.spring.web.mvc.model.Login;
import com.examples.spring.web.mvc.model.Registration;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("userName")
public class RegistrationController {
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)	
	public String registration(Model model) {
		model.addAttribute("registration", new Registration());
		//return new ModelAndView("registration",new Registration());
		
		return "registration";
	}
	
	@RequestMapping(value = "/regsauthenticate")
	@ExceptionHandler(LoginException.class)
	public String authenticate(@Valid @ModelAttribute ("registration")Registration registration, BindingResult bindingResult, Model model, HttpSession session) {
		
		// method = RequestMethod.POST
//			logger.info("Authentication success");
//			session.setAttribute("userName", registration.getUserName());
			model.addAttribute("userName", registration);
			ModelAndView modelnview= new  ModelAndView("redirect:/registration");
			ModelAndView modelnview1= new  ModelAndView("redirect:/login");
			//return new ModelAndView("redirect:/employee/list");
			if (bindingResult.hasErrors()) {
				//logger.info("Returning custSave.jsp page");
				System.out.println("Error");
				return "registration";
				//return new ModelAndView("redirect:/registration");
			}
			else
			{
				System.out.println("No error");
				model.addAttribute("login", new Login());
				return "login";
				
			//return new ModelAndView("redirect:/login");
			
//			logger.info("Authentication failed");
			//throw new LoginException("Invalid User or Password");
//			return new ModelAndView("redirect:/login");
			}
		
		
	}
	
	
	public List<Login> getUsers()
	{
		List<Login> users = new ArrayList<Login>();
		users.add(new Login("admin","admin@123"));
		users.add(new Login("manager", "manager@123"));
		users.add(new Login("user", "user@123"));
	
		return users;
	}
	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpSession session, SessionStatus sessionStatus)
//	{		
//		sessionStatus.setComplete();
////		session.removeAttribute("userName");		
////		session.invalidate();
//		return "redirect:/";
//	}
}