package com.example.testautomationexample.exceptions;

public class FailedAuthenticationException{

    private String message;
    private String documentation_url;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }

    public void setDocumentation_url(String documentation_url) {
        this.documentation_url = documentation_url;
    }
}
