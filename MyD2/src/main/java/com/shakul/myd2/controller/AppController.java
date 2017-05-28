package com.shakul.myd2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shakul.myd2.model.Document;
import com.shakul.myd2.model.User;
import com.shakul.myd2.util.PropertiesCache;


@Controller
public class AppController {

	@RequestMapping(value = {  "/" , "/home" }, method = RequestMethod.GET)
    public String homePage(User user, BindingResult result, Model model) {
		model.addAttribute("message", "Hi Welcome to My D2!!");
		Document document = new Document("","");
		model.addAttribute("document", document);
        return "home";
    }
 
    @RequestMapping(value = { "/products"}, method = RequestMethod.GET)
    public String productsPage(Model model) {
        return "products";
    }
 
    @RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(Model model) {
        return "contactus";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "redirect:/login?logout";
    }
    
    
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
     
/*    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
    	

    	return "login";
    }*/
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
                @RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
                HttpServletRequest request) {
    	
    	System.out.println("INSIDE LOGIN CONTROLLER"  + "Error : "+error + " Logout : " +logout);

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error",
                           getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", PropertiesCache.getInstance().getProperty("exception_msg_logout"));
		}
		model.setViewName("login");

		return model;

	}

    private String getErrorMessage(HttpServletRequest request, String key){

		Exception exception =
                   (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = PropertiesCache.getInstance().getProperty("exception_msg_wrong_password");
		}else if(exception instanceof LockedException) {
			error = exception.getMessage();
		}else{
			error = PropertiesCache.getInstance().getProperty("exception_msg_login_failed");
		}

		System.out.println("Controller : login : getErrorMessage() : "+ error);
		return error;
	}
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
