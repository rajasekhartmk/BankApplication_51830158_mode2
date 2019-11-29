package com.bankapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//	@GetMapping(path="clerk")
//	public String helloClerk(){
//		return "hello";
//	}
//	
//	@GetMapping(path="admin")
//	public String helloAdmin(){
//		return "hello";
//	}
//	
//	@GetMapping(path="mgr")
//	public String helloMgr(){
//		return "hello";
//	}
	
	@GetMapping(path="/")
	public String defaultUrl(){
		return "redirect:home";
	}
	
	@GetMapping(path="login")
	public String login(){
		return "login";
	}
	
	@GetMapping(path="home")
	public ModelAndView hello(ModelAndView mv){
		mv.setViewName("home");
		return mv;
	}
}
