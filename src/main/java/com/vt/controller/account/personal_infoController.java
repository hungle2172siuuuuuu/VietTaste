package com.vt.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class personal_infoController {
    
    @GetMapping("/your_info")
    public String your_info(){
        return "Account/personal_info";
    }
}
