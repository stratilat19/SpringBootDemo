package com.learnSpring.controllers;

import com.learnSpring.db.Feedback;
import com.learnSpring.db.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping("/contacts")
    public String feedback(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam String message,
                           Model model){
        System.out.println("FEEDBACK name = " + name + " email = " + email + " phone = " + phone + " message = " + message);

        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setPhone(phone);
        feedback.setMessage(message);
        feedbackRepository.save(feedback);

        return "contacts";
    }

    @GetMapping("/feedback")
    public @ResponseBody
    Iterable<Feedback> getAllFeedback() {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findAll();
    }

    @GetMapping("/feedback/{id}")
    public @ResponseBody
    Optional<Feedback> getFeedback(@PathVariable String id) {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findById(Integer.valueOf(id));
    }

}
