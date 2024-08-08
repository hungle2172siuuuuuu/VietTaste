package com.vt.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vt.model.Users;
import com.vt.repository.account.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository usersRepository;

    @GetMapping("/block-user")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "blockUser";
    }

    @PostMapping("/block-user")
    public String blockUser(@RequestParam("userId") String userId, Model model) {
        Users user = usersRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setStatus("Blocked");
            usersRepository.save(user);
        }
        model.addAttribute("users", usersRepository.findAll());
        return "blockUser";
    }
}
