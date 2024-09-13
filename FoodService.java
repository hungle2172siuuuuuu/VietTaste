package com.vt.service;

import com.vt.model.Food;
import com.vt.repository.FoodDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDAO foodRepository;

    public void addFood(Food food) {
        foodRepository.save(food);
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public void deleteFoodById(String foodId) {
        foodRepository.deleteById(foodId);
    }

    public Food getFoodById(String foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    public void updateFood(Food food) {
        foodRepository.save(food);
    }
    public List<Food> getAllFoodItems() {
        return foodRepository.findAll();
    }
}
