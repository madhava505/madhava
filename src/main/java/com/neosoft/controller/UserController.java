package com.neosoft.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.User;
import com.neosoft.service.UserService;

@RestController
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	public UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		logger.info("get all user ");
		return userService.getAllUser();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		logger.info("save  user ");
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId, @Valid @RequestBody User user) {
		logger.info("update the user ");
		userService.updateUser(userId, user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		logger.info("delete the user ");
		userService.deleteUser(userId);
	}

	@RequestMapping("/usersByColumns")
	public List<User> getAllUsersByColumns(@RequestParam String field1, @RequestParam String field2) {
		logger.info("get All users by columns");
		return userService.getAllUsersByColumns(field1, field2);
	}

	@RequestMapping("/usersByDirections")
	public List<User> getAllUsersByDirections(@RequestParam String field1, @RequestParam String field2) {
		logger.info("get all useBy Directions ");
		return userService.getAllUsersByDirections(field1, field2);
	}

	@RequestMapping("/usersByFirstName")
	public List<User> getAllUsersByFirstName(@RequestParam String firstName) {
		logger.info("get users By First Name ");
		return userService.getAllUsersByFirstName(firstName);
	}

	@RequestMapping("/usersByLastName")
	public List<User> getAllUsersByLastName(@RequestParam String lastName) {
		logger.info("get user sBy LastName ");
		return userService.getAllUsersByLastName(lastName);
	}

	@RequestMapping("/usersByPincode")
	public List<User> getAllUsersByPincode(@RequestParam int pincode) {
		logger.info("get users By Pincode ");
		return userService.getAllUsersByPincode(pincode);
	}
}
