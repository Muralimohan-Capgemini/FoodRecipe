package com.example.food.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.model.Items;

public interface FoodRepository extends JpaRepository<Items, Integer> {

	List<Items> findByCategory(String category);

	public Items findById(int id);

}
