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
@RequestMapping("/")
public class MessageController {

    @Autowired
    MessagesService ms;

    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("message", new Message(LocalDateTime.now()));
        return "addMessage";

    }

    @PostMapping("/add")
    public String add(@Valid Message message, Errors errors, Model model){
        if(errors.hasErrors()){
            return "addMessage";
        }

        ms.addMessage(message);
        model.addAttribute("messages", ms.getAll());
        return "home";
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("messages", ms.getAll());
        return "home";
    }

}
