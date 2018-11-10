package com.learnSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name,
                        @RequestParam(name="lastName", required=false, defaultValue="") String lastName,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("lastName", lastName);
        return "hello";
    }

    @GetMapping("/contacts")
    public String contacts(@RequestParam(name="os", required=false, defaultValue="Linux") String os,
                        Model model) {
        model.addAttribute("os", os);
        return "contacts";
    }

    @PostMapping
    public String feedback(@RequestParam String name,
                           @RequestParam String email,
                           Model model){
        System.out.println("FEEDBACK name="+name+" email="+email);
        return "contacts";
    }

}
