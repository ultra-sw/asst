package ru.ultrasoftware.asst.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.ultrasoftware.asst.dao.UserDao;
import ru.ultrasoftware.asst.domain.User;
import ru.ultrasoftware.asst.service.UserService;

public class LoginService {
	
	@Autowired
    private UserService userService;
	
	
	@Autowired
	private User useri;
	
	
	public boolean validateUser(String user, String password) {
	
		System.out.println("1");
	//	List<User> users = userService.getUsers();
		String userm = useri.getName();
		System.out.println(userm);
		System.out.println("3");
		return user.equalsIgnoreCase(userm) && password.equals("12345");
	}

}