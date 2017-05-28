package com.shakul.myd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shakul.myd2.model.User;
import com.shakul.myd2.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user(ModelMap model){
		User objUser = new User();

		model.addAttribute("user", objUser);
		
		return "user";
	}
	
	@RequestMapping(value="/newuser", method=RequestMethod.GET)
	public String newUser(ModelMap model){
		User objUser = new User();

		model.addAttribute("user", objUser);
		return "newuser";
	}
	
	@RequestMapping(value="/newuser", method=RequestMethod.POST)
	public String saveUser(User user, BindingResult result, ModelMap model){
		
		if(result.hasErrors()){
			return "newuser";
		}
		userService.setDefaultValue(user);
		userService.saveUser(user);
		
		model.addAttribute("success", "<div class='alert alert-success' style='width: 50%;'><strong>Success!</strong>User Created in System </div>");
		User objUser = new User();
		model.addAttribute("user", objUser);
		return "newuser";
	}
	
	@RequestMapping(value="/searchcond", method=RequestMethod.GET)
	public String seacrhCond(ModelMap model){
		User objUser = new User();

		model.addAttribute("searchUser", objUser);
		return "searchcond";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String searchCond(User user, BindingResult result, ModelMap model){
		
		System.out.println("USER CONTROLLER : searchCond() : POST");
		
		if(result.hasErrors()){
			return "user";
		}
		
		User objUser = userService.getUserNameList(user);
		System.out.println("USER CONTROLLER : searchCond() : POST : after ferching : "+ objUser);
		model.addAttribute("searchUser", user);
		if(objUser!=null){
			
			model.addAttribute("result", objUser);
		
		}
		else{
			User u = new User();
			u.setStrUserState("");
			model.addAttribute("result", u);
		}
		return "user";
	}
	
	
}
