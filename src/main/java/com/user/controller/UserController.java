package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.user.interfaces.UserRepository;
import com.user.model.User;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        User tempUser = userRepo.save(user);

        System.out.println("\n**********User Added********");
        System.out.println("ID: " + tempUser.getId());
        System.out.println("Name: " + tempUser.getName());
        System.out.println("Username: " + tempUser.getUsername());
        System.out.println("Password: " + tempUser.getPassword());
        System.out.println("****************************");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/allPopulation", method = RequestMethod.GET)
    public List<User> getAll() {
        List<User> listUser = userRepo.findAll();

        System.out.println("\n***All Population Returned***");
        System.out.println("Returned Users: " + listUser.size());
        System.out.println("****************************");

        return listUser;
    }

    @RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Integer id) {

        if (!userRepo.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Optional<User> tempUser = userRepo.findById(id);

            System.out.println("\n********User Showed*********");
            System.out.println("ID: " + tempUser.get().getId());
            System.out.println("Name: " + tempUser.get().getName());
            System.out.println("Username: " + tempUser.get().getUsername());
            System.out.println("Password: " + tempUser.get().getPassword());
            System.out.println("****************************");

            return ResponseEntity.ok(tempUser);
        }
    }

    @RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        if (!userRepo.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            System.out.println("\n********User Deleted********");
            System.out.println("ID: " + userRepo.getOne(id).getId());
            System.out.println("Name: " + userRepo.getOne(id).getName());
            System.out.println("Username: " + userRepo.getOne(id).getUsername());
            System.out.println("Password: " + userRepo.getOne(id).getPassword());
            System.out.println("****************************");

            userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping("*")
    public String fallBack() {
        System.out.println("\n****************************");
        System.out.println("Fall Back Called");
        System.out.println("******************************");

        return "Bad Request";
    }
}