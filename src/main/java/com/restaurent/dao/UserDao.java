package com.restaurent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restaurent.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
}
