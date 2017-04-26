package com.polytech.account.service;


import com.polytech.account.models.User;



public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
