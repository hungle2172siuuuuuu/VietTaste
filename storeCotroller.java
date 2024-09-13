package com.vt.controller.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vt.model.Food;
import com.vt.service.FoodService;
import org.springframework.ui.Model;

@Controller
public class storeCotroller {
	@Autowired
    private FoodService foodService;
	
	@GetMapping("/store")
    public String getStorePage(Model model) {
        List<Food> foodItems = foodService.getAllFoodItems();
        model.addAttribute("foodItems", foodItems);
        return "Store/Store"; 
    }
    @GetMapping("/delete")
    public String showDeleteFoodPage() {
        return "delete-food";
    }
    
}


