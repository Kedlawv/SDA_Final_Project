package com.sda.switter.api;

import com.sda.switter.model.Message;
import com.sda.switter.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

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

        model.addAttribute("message", new Message(LocalDateTime.now()));
        return "addMessage";

    }

    @PostMapping("/add")
    public String add(@Valid Message message, Errors errors){
        if(errors.hasErrors()){
            return "addMessage";
        }

        ms.addMessage(message);
        return "confirmation";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("messages", ms.getAll());
        return "home";
    }

}
