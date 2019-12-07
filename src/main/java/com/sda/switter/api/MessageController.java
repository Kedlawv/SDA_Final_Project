package com.sda.switter.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @GetMapping
    public String hello(Model model){
        model.addAttribute("message", "Hello as attribute");
        return "hello";
    }
}
