package com.tap.DAO;

import java.util.List;

import com.tap.entity.User;

public interface UserDAO 
{
	void addUser(User user);
	User getUserById(int user_id);
	List<User> getAllUser();
	void updateUser(User user);
	void deleteUser(int user_id);
	User getUserByEmail(String email);
}
