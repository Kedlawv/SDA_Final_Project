package com.sda.switter.api;

import com.sda.switter.model.Message;
import com.sda.switter.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessagesService ms;

    @GetMapping
    public String hello(Model model){
        model.addAttribute("message", "Hello as attribute");
        return "hello";
    }


    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("message", new Message());
        return "addMessage";

    }

    @PostMapping("/add")
    public String add(@ModelAttribute Message message, Model model){
        model.addAttribute("message", message);
        ms.addMessage(message);
        return "confirmation";
    }

}
