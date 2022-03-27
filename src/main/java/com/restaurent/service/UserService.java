package com.restaurent.service;
import java.util.*;
import com.restaurent.model.User;

public interface UserService {
	public List<User> getUser();
	public User getUserById(int id);
	public User setUser(User user);
	public User updateUser(User user, int id);
	public void deleteUser(int id);
}
