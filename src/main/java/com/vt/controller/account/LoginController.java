package com.vt.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.vt.model.Users;
import com.vt.service.UserService;


@Controller
@SessionAttributes("currentUser")
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
    public String loginForm(){
        return "login";
    }

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		Users user = userService.login(username, password);
		if (user != null) {
			if (user.getRole().equals("ADMIN")) {
				model.addAttribute("currentUser", user);
				return "redirect:/admin";
			} else {
				model.addAttribute("currentUser", user);
				return "redirect:/store";
			}
		} else {
			model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete(); // Xóa session
		return "redirect:/"; // Chuyển hướng đến trang chủ
	}

}
