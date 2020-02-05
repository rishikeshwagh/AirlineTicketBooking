package com.airline.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    
    @RequestMapping("/login")
    @ResponseBody
    public String index() {
        return "Will Be redirected to User HomePage!";
    }

}