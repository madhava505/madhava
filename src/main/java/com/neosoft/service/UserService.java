package com.neosoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.neosoft.entity.User;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(int userId, User user) {
		userRepository.save(user);
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);

	}

	public List<User> getAllUsersByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	public List<User> getAllUsersByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	public List<User> getAllUsersByPincode(int pincode) {
		return userRepository.findBypincode(pincode);
	}

	public List<User> getAllUsersByColumns(String field1, String field2) {
		return userRepository.findAll(Sort.by(Direction.DESC, field1, field2));
	}

	public List<User> getAllUsersByDirections(String dateOfBirth, String joiningDate) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Direction.ASC, dateOfBirth));
		orders.add(new Order(Direction.DESC, joiningDate));
		return userRepository.findAll(Sort.by(orders));
	}

	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

}
