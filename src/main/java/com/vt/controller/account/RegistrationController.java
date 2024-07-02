package com.vt.controller.account;

import com.vt.model.User;
import com.vt.service.account.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Tạo một đối tượng User mới và thêm vào model
        return "register"; // Trả về tên template "register.html"
    }

    // Xử lý form đăng ký khi người dùng submit
    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute("user") @Valid User user, // Lấy dữ liệu từ form và validate
            BindingResult bindingResult, // Kết quả validate
            Model model // Model để truyền dữ liệu về view
    ) {
        // Nếu có lỗi validate, trả về lại trang đăng ký
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Xác thực mật khẩu
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errorMessage", "Mật khẩu không khớp.");
            return "register";
        }

        // Gọi service để đăng ký người dùng
        boolean registrationSuccess = registrationService.registerUser(user);

        // Nếu đăng ký thành công, chuyển hướng đến trang đăng nhập
        if (registrationSuccess) {
            return "redirect:/login";
        } else { 
            // Nếu đăng ký thất bại (ví dụ: username hoặc email đã tồn tại),
            // thêm thông báo lỗi vào model và trả về trang đăng ký
            model.addAttribute("errorMessage", "Tên người dùng hoặc email đã tồn tại.");
            return "register";
        }
    }
}
