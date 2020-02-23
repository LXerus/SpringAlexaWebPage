package com.alexaportfolio.AlexaPortfolio.models;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
}
