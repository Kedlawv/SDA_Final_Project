package com.sda.switter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class SwitterController {

    @GetMapping(value = "/", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showHome(Principal principal) {
        return "Cześć " + principal.getName() + "!";
    }

    @GetMapping("/xyz")
    @ResponseBody
    public String showSomething() {
        return "Something for everyone";
    }

}