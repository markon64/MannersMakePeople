package com.seongmin.demo.controller;

import com.seongmin.demo.model.forms.SuggestionForm;
import com.seongmin.demo.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute(new SuggestionForm());
        return "index";
    }

//    @PostMapping("/")
//    public String sendSuggestion(@Valid SuggestionForm suggestionForm, BindingResult bindingResult){
//        System.out.println(suggestionForm.toString());
//        if (bindingResult.hasErrors()){
//            return "index";
//        }
////        try {
////            emailService.sendSuggestion(suggestionForm);
////        } catch (EmailException e) {
////            e.printStackTrace();
////        }
//        return "redirect:/";
//    }



}
