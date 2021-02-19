package com.seongmin.demo.model.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SuggestionForm {

    @Email
    @NotNull
    @Size(min=1)
    private String senderEmail;
    @NotNull
    @Size(min=1)
    private String content;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SuggestionForm{" +
                "senderEmail='" + senderEmail + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
