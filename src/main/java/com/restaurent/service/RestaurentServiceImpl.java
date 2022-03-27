package com.restaurent.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurent.dao.RestaurentDao;
import com.restaurent.model.Restaurent;

@Service
public class RestaurentServiceImpl implements RestaurentService {
	
	@Autowired
	private RestaurentDao restaurentDao;
	
	@Override
	public List<Restaurent> getRestaurent() {
		System.out.println("Getting all Restaurent data");
		return this.restaurentDao.findAll();
	}

	@Override
	public Restaurent getRestaurentById(int id) {
		System.out.println("Getting Restaurent data by Id :"+id);
		Restaurent res=null;
		try {
			res=this.restaurentDao.findById(id).get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Restaurent setRestaurent(Restaurent restaurent) {
		System.out.println("Setting Restaurent data");
		return this.restaurentDao.save(restaurent);
	}

	@Override
	public Restaurent updateRestaurent(Restaurent restaurent, int id) {
		System.out.println("Updating Restaurent data Id :"+id);
		Restaurent res=this.getRestaurentById(id);
		res.setRestaurentName(restaurent.getRestaurentName());			
		res.setRestaurentEmail(restaurent.getRestaurentEmail());
		res.setRestaurentMobile(restaurent.getRestaurentMobile());
		res.setRestaurentAddress(restaurent.getRestaurentAddress());
		res.setRestaurentServices(restaurent.getRestaurentServices());
		return this.restaurentDao.save(res);
	}

	@Override
	public void deleteRestaurent(int id) {
		System.out.println("Deleting Restaurent data Id :"+id);
		this.restaurentDao.deleteById(id);
	}

}
