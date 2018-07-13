package com.ahmed;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.model.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> addNewUser(@RequestParam String name, @RequestParam String username,
			@RequestParam String password) {
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		userRepo.save(user);
		return ResponseEntity.ok(user);
	}

	@RequestMapping("/allPopulation")
	public List<User> getAll() {
		List<User> userList = new ArrayList<>();
		userRepo.findAll().forEach(userList::add);
		return userList;
	}

	@RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUser(@PathVariable Integer id) {
		return userRepo.findById(id);
	}

	@RequestMapping("/removeUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return "user deleted";
	}

}
