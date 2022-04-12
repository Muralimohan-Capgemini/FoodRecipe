package com.example.food;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.assertj.core.util.Arrays;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.food.model.Items;
import com.example.food.service.FoodService;

public class FoodControllerTest {
	
	@MockBean
	FoodService foodServices;
	
	@Autowired
	MockMvc MockMvc;
	
	public void testGetAllItems() throws Exception {
		Items items = new Items(1,"Chicken Fry Biryani","Non-Veg","07-04-2022 15:12",5,"Vegitables add","Add an oil ");
		List<Object> itemsObject= Arrays.asList(items);
		List<Items> itemList = new ArrayList<Items>();
		for(Object obj:itemsObject) {
			if(obj instanceof Items) {
				itemList.add((Items) obj);
			}
		}
		Mockito.when(foodServices.getAllItems()).thenReturn(itemList);
		
		MockMvc.perform(get("/getAllItems"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[2].firstName", Matchers.is("Non-Veg")));
		
	}
	public void testSaveItems() throws Exception {
		
		Items items = new Items(2,"Paneer Biryani","Veg","08-04-2022 15:12",5,"Vegitables added","Add an oils ");
		assertThat(foodServices.saveItems(items)).isGreaterThan("0");
		assertThat(items.getId()).isSameAs("1");
		
	}
	
	public void testDeleteItems() throws Exception {
		
		Items items = new Items(2,"Paneer Biryani","Veg","08-04-2022 15:12",5,"Vegitables added","Add an oils ");
		assertThat(foodServices.deleteItem(items.getId())).isEmpty();
		assertThat(items.getId()).isSameAs("0");
		
	}

}
