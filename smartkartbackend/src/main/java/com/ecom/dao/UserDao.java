package com.ecom.dao;

import java.util.List;

import com.ecom.model.User;

public interface UserDao
{
	public boolean add(User user);
	public boolean delete(User user);
	public boolean update(User user);
	public List<User> listUser();
	public User getUser(int userId);
	
}