package com.seongmin.demo.model.forms.rest;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionResponse {

    private List<Error> errors;
    private boolean successful;

    public SuggestionResponse(Errors errors) {
        this.errors = errors.getAllErrors()
                .stream().map(x -> new Error(((FieldError)x).getField(), x.getDefaultMessage()))
                .collect(Collectors.toList());
        this.successful = this.errors.isEmpty();
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public boolean hasErrors(){
        return !errors.isEmpty();
    }

    private class Error {

        private String field;
        private String message;

        public Error(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}