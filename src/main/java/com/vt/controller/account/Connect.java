package com.vt.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class Connect {

    @GetMapping("/")
    public String connect() {
        return "connect";
    }
}
