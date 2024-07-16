package com.vt.controller.account;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vt.model.Users;
import com.vt.repository.account.UserRepository;

@Controller
public class RegisterController {
    
    @Autowired
    private UserRepository userRepository;

    private static final SecureRandom secureRandom = new SecureRandom();

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Users user, BindingResult result, Model model,
            @RequestParam("confirmPassword") String confirmPassword) {
        // if (result.hasErrors()) {
        //     return "register";
        // }

        if (!String.valueOf(user.getPassword()).equals(confirmPassword)) {
            model.addAttribute("passwordError", "Mật khẩu và xác nhận mật khẩu không khớp");
            return "register";
        }

        String userId;
        do {
            userId = "#" + generateRandomNumericString(6);
        } while (userRepository.existsById(userId));

        user.setUserId(userId);

        user.setRole("USER");

        userRepository.save(user);
        model.addAttribute("successMessage", "Đăng ký thành công!");

        return "redirect:/login";
    }

    // Hàm tạo chuỗi ngẫu nhiên gồm các chữ số
    private String generateRandomNumericString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomDigit = secureRandom.nextInt(10);
            sb.append(randomDigit);
        }
        return sb.toString();
    }
}
