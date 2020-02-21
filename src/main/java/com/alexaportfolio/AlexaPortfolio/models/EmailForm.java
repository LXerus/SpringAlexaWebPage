package com.alexaportfolio.AlexaPortfolio.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmailForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Email(message = "Debe ser un email valido")
    private String email;

    @NotNull
    @Size(min=10, max=100)
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
