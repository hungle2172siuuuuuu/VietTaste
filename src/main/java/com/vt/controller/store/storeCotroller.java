package com.vt.controller.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class storeCotroller {
    @GetMapping("/store")
    public String store(){
        return "Store/Store";
    }
}


