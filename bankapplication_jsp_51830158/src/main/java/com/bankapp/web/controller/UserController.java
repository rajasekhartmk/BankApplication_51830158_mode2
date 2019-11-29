package com.bankapp.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;
import com.bankapp.web.controller.bean.UserBean;
import com.bankapp.web.controller.bean.UserUpdateBean;

@Controller
@RequestMapping(path="usermgt/")
public class UserController {

	
	@Autowired
	private UserService service;
	
	@GetMapping(path="/")
	public ModelAndView allUsers(ModelAndView mv){
		mv.addObject("users", service.findAll());
		mv.setViewName("allUsers");
		return mv;
	}
	
	@GetMapping(path="addUser")
	public String addUser(ModelMap map){
		map.addAttribute("user",new UserBean());
		return "addUser";
	}

	@PostMapping(path="addUser")
	public String addUserPost(@ModelAttribute(name="user")UserBean userBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "addUser";
		User user=new User(userBean.getName(), userBean.getPassword(), userBean.getEmail(), userBean.getPhone(), userBean.getAddress(), new String[]{userBean.getRoles()}, userBean.isActive());
		
		service.addUser(user);
		return "redirect:/";
	}
	
	@GetMapping(path="updateUser")
	public String updateUser(ModelMap map,@RequestParam Long id,HttpServletRequest req){
		User user=service.findById(id);
		UserUpdateBean userUpdateBean=new UserUpdateBean();
		userUpdateBean.setId(id);
		
		userUpdateBean.setPhone(user.getPhone());
		userUpdateBean.setAddress(user.getAddress());
//		//userUpdateBean.setRoles(user.getRoles());
		userUpdateBean.setActive(user.isActive());
		
		map.addAttribute("user",userUpdateBean);
		return "updateUser";
	}

	@PostMapping(path="updateUser")
	public String updateUserPost(HttpServletRequest req,@ModelAttribute(name="user")UserUpdateBean userUpdateBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "updateUser";
		//int id=Integer.parseInt(req.getParameter("id"));
		//Long id=(long) idi;
		//long id=6L;
		long id=userUpdateBean.getId();
		User user=service.findById(id);
		
		user.setPhone(userUpdateBean.getPhone());
		user.setAddress(userUpdateBean.getAddress());
		user.setRoles(new String[]{userUpdateBean.getRoles()});
		user.setActive(userUpdateBean.isActive());
		
		service.update(id, user);
		return "redirect:";
	}
	
	@GetMapping(path="delete")
	public String deleteUser(HttpServletRequest req){
		int id=Integer.parseInt(req.getParameter("id"));
		service.deleteUserById(id);
		return "redirect:";
	}
	
	@ModelAttribute(value="active")
	public List<String> getactive(){
		return Arrays.asList("true","false");
	}
	
	@ModelAttribute(value="roles")
	public List<String> getRoles(){
		return Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK");
	}
	
	
	
}
