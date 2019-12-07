package com.sda.switter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SwitterController {

    @GetMapping("/")
    @ResponseBody
    public String showHome() {
        return "home";
    }
}
