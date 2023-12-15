package com.ynr.springboot.service;

import java.util.List;

import com.ynr.springboot.entities.User;

public interface UserService {

	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User findById(int id);
	public List<User> findAllUsers();
	
	public User findUserByUsername(String username);
//	public User updateUserPasswordByUsername(String username,String password);
}
