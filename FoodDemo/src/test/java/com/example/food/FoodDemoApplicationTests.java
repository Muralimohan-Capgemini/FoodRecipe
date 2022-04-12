package com.example.food;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.food.controller.FoodController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FoodDemoApplicationTests {
	
	@Autowired
	FoodController foodController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(foodController.getAllItems()).isNotNull();
	}

}
