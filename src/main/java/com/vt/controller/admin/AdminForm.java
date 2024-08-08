package com.vt.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminForm {
    @GetMapping("admin")
    public String adminForm() {
        return "admin/index";
    }
}
