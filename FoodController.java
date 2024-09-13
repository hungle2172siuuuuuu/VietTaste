
package com.vt.controller.store;

import com.vt.model.Food;
import com.vt.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private FoodService foodService;

    @GetMapping("/manage")
    public String manageFood(Model model) {
        List<Food> allFoodItems = foodService.getAllFood();
        model.addAttribute("allFoodItems", allFoodItems);
        return "add-food";
    }
    @PostMapping("/add")
    public String addFood(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                          @RequestParam double price, @RequestParam("imageFile") MultipartFile file) {
        String imagePath = saveFile(file);
        Food food = new Food(id, name, description, imagePath, price, null);
        foodService.addFood(food);
        return "redirect:/food/manage";
    }

    @PostMapping("/delete")
    public String deleteFood(@RequestParam String foodId) {
        foodService.deleteFoodById(foodId);
        return "redirect:/food/manage";
    }

    @GetMapping("/edit")
    public String editFoodForm(@RequestParam String foodId, Model model) {
        Food food = foodService.getFoodById(foodId);
        model.addAttribute("food", food);
        return "edit-food";
    }

    @PostMapping("/update")
    public String updateFood(@RequestParam String id, @RequestParam String name, @RequestParam String description,
                             @RequestParam double price, @RequestParam("imageFile") MultipartFile file) {
        String imagePath = saveFile(file);
        Food food = new Food(id, name, description, imagePath, price, null);
        foodService.updateFood(food);
        return "redirect:/food/manage";
    }

    private String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "";
        }
        try {
            // Đảm bảo thư mục uploads tồn tại
            File uploadsDir = new File("src/main/resources/static/uploads");
            if (!uploadsDir.exists()) {
                uploadsDir.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            }
            
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadsDir.getAbsolutePath(), fileName);
            file.transferTo(new File(path.toString()));

            return "/uploads/" + fileName; // Đường dẫn tĩnh đến ảnh
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    


}

