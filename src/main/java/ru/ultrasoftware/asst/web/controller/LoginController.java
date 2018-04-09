/*package ru.ultrasoftware.asst.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	 LoginService service = new LoginService();
	 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String loginPage() {
		 return "login";
	 }
	 
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 public String handleLoginRequest(@RequestParam String name, @RequestParam String password,
			 ModelMap model) {
		 if (service.validateUser(name, password)) {
	         model.put("name", name);
	         return "hello";
		 }
		 else {
			 return "login";		     
		 }
			 
	 }
	 
}
*/