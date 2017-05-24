package io.pivotal.landing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/tracker")
	public String tracker() {
		return "tracker";
	}
	
	@RequestMapping("/account")
	public String acount() {
		return "account";
	}
	
	@RequestMapping("/pivotal/main")
	public String acount1() {
		return "pivotal/pivotal";
	}

	@Secured({"PIVOTAL"})
	@RequestMapping("/test")
	public String index() {
		return "index.html";
	}
	
	
	//@RequestMapping("/login")
	//public String login() {
	//	return "home.html";
	//}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
}
