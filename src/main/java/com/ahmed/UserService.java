package com.ahmed;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAll() {
		List<User> userList = new ArrayList<>();
		userRepo.findAll().forEach(userList::add);
		return userList;
	}

	public void addUser(User user) {
		userRepo.save(user);
	}

	public void updateUser(User user) {
		userRepo.save(user);
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	public Optional<User> getUser(Long id) {
		return userRepo.findById(id);
	}

}
