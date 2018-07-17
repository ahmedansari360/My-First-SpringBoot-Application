package com.user.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.user.interfaces.UserRepository;
import com.user.model.User;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> addNewUser(@RequestBody User user) {
		User tempUser = new User();
		tempUser = userRepo.save(user);
		return ResponseEntity.ok(tempUser);
	}

	@RequestMapping(value = "/allPopulation", method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Integer id) {
		return userRepo.findById(id);
	}

	@RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return "user deleted";
	}

	@RequestMapping("*")
	public String fallBack() {
		return "Bad Request";
	}
}