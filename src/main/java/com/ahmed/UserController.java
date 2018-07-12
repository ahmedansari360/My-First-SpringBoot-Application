package com.ahmed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	@RequestMapping("/addUser")
	public void addUser(){
		return userService.addUser();
	}
	
}
