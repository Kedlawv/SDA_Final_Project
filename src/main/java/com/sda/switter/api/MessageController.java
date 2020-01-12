package com.sda.switter.api;

import com.sda.switter.dto.MessageDto;
import com.sda.switter.model.Message;
import com.sda.switter.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class MessageController {

    @ModelAttribute
    public Principal addUserToModel(Principal principal){
        return principal;
    }

    @Autowired
    MessagesService ms;

    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("message", new Message(LocalDateTime.now()));
        return "addMessage";

    }

    @PostMapping("/add")
    public String add(@Valid MessageDto message, Errors errors, Model model,
                      Principal principal){
        if(errors.hasErrors()){
            return "addMessage";
        }

        if(principal == null){
            errors.reject("User not logged in");
        }

        ms.addMessage(message, principal.getName());
        model.addAttribute("messages", ms.getAll());
        return "home";
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("messages", ms.getAll());
        return "home";
    }

    @PostMapping("/details")
    public String details(@RequestParam("messageId") Long id, Model model) {
        Message message = ms.findById(id);

        model.addAttribute("message", message);

        return "messageDetails";
    }

}
