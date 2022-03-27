package com.restaurent.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurent.dao.UserDao;
import com.restaurent.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUser() {
		System.out.println("Getting User data");
		return this.userDao.findAll();
	}

	@Override
	public User getUserById(int id) {
		System.out.println("Getting User data by Id "+id);
		User u=null;
		try {
			u=this.userDao.findById(id).get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User setUser(User user) {
		System.out.println("Setting User data");
		return this.userDao.save(user);
	}

	@Override
	public User updateUser(User user, int id) {
		System.out.println("Updating User data Id "+id);
		User u=this.getUserById(id);
		u.setUserName(user.getUserName());
		u.setUserEmail(user.getUserEmail());
		u.setUserMobile(user.getUserMobile());
		u.setUserPassword(user.getUserPassword());
		return this.userDao.save(u);
	}

	@Override
	public void deleteUser(int id) {
		System.out.println("Deleting User data Id "+id);
		this.userDao.deleteById(id);
	}

}
