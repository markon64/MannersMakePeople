package com.seongmin.demo.service;

import com.seongmin.demo.model.forms.SuggestionForm;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class EmailService {

    public void sendSuggestion(@NotNull SuggestionForm suggestionForm) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.seznam.cz");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("mannermakepeople@post.cz", "dltjdals1."));
        email.setSSLOnConnect(true);
        email.setFrom("mannermakepeople@post.cz");
        email.setSubject("User Feedback");
        email.setMsg(suggestionForm.getContent() + "\n\nEmail: " + suggestionForm.getSenderEmail());
        email.addTo("seinaru.lee@gmail.com");
        email.send();
    }


}
