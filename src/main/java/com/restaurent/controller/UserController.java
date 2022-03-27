package com.restaurent.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.restaurent.model.User;
import com.restaurent.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/")
	public String defaultMethod() {
		return "<h1>API is working</h1>";
	}
	
	@RequestMapping("/*")
	public RedirectView randomUrlHandler() {
		RedirectView rv=new RedirectView();
		rv.setUrl("/");
	    return rv;
	}
	
	@GetMapping("/signup")
	public ResponseEntity<List<User>> getSignup() {
		List<User> list=this.userService.getUser();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/signup/{id}")
	public ResponseEntity<User> getSignupById(@PathVariable("id") int id) {
		User u=this.userService.getUserById(id);
		if(u==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(u));
	}
	
	@PostMapping("signup")
	public ResponseEntity<User> postSignup(@RequestBody User user) {
		User u=null;
		try {
			u=this.userService.setUser(user);
			return ResponseEntity.of(Optional.of(u));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/signup/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") int id){
		try {
			this.userService.updateUser(user, id);
			return ResponseEntity.ok().body(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/signup/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
		try {
			this.userService.deleteUser(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
