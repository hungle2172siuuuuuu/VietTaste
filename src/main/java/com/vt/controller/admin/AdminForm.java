package com.vt.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminForm {
    @GetMapping("admin")
    public String adminForm(@RequestParam String param) {
        return new String();
    }
    
}
