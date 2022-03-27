package com.restaurent.controller;

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
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.restaurent.model.Restaurent;
import com.restaurent.service.RestaurentServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurentController {
	
	@Autowired
	public RestaurentServiceImpl restaurentService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<Restaurent>> getRestaurent(){
		List<Restaurent> list = this.restaurentService.getRestaurent();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Restaurent> getRestaurentById(@PathVariable("id") int id){
		Restaurent res=this.restaurentService.getRestaurentById(id);
		if(res==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(res));
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Restaurent> setRestaurent(@RequestBody Restaurent restaurent) {
		Restaurent res=null;
		try {
			res=this.restaurentService.setRestaurent(restaurent);
			return ResponseEntity.of(Optional.of(res));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Restaurent> updateRestaurent(@RequestBody Restaurent restaurent,@PathVariable("id") int id) {
		try {
			this.restaurentService.updateRestaurent(restaurent, id);
			return ResponseEntity.ok().body(restaurent);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Void> deleteRestaurent(@PathVariable("id") int id) {
		try
		{
			this.restaurentService.deleteRestaurent(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
