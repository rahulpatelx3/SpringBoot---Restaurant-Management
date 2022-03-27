package com.restaurent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restaurent.model.Restaurent;

@Repository
public interface RestaurentDao extends JpaRepository<Restaurent, Integer> {

}
