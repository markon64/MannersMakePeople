package com.seongmin.demo.controller.rest;

import com.seongmin.demo.model.forms.SuggestionForm;
import com.seongmin.demo.model.forms.rest.SuggestionResponse;
import com.seongmin.demo.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HomeRestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/")
    ResponseEntity<?> sendSuggestion(@RequestBody @Valid SuggestionForm suggestionForm, Errors errors) {
        System.out.println(suggestionForm.toString());

        SuggestionResponse result = new SuggestionResponse(errors);
        if (result.isSuccessful()) {
            try {
                emailService.sendSuggestion(suggestionForm);
            } catch (EmailException e) {
                e.printStackTrace();
                result.setSuccessful(false);
            }
        }
        return ResponseEntity.ok(result);
    }
}
