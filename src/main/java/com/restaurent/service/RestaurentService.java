package com.restaurent.service;
import java.util.*;
import com.restaurent.model.Restaurent;

public interface RestaurentService {
	public List<Restaurent> getRestaurent();
	public Restaurent getRestaurentById(int id);
	public Restaurent setRestaurent(Restaurent restaurent);
	public Restaurent updateRestaurent(Restaurent restaurent,int id);
	public void deleteRestaurent(int id);
}
