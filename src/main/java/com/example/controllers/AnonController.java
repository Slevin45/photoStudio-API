package com.example.controllers;

import com.example.models.request.ContactUsRequest;
import com.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/anon")
public class AnonController {

    private final UserService userService;

    public AnonController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/contact")
    public ResponseEntity<String> contactUs(@Valid @RequestBody ContactUsRequest bean) {
        userService.contactUs(bean);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
