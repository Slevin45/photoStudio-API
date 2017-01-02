package com.example.models.request;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@Data
public class ContactUsRequest {

    private String name;
    private String phone;
    private String message;
    @NotBlank
    private String email;
}
