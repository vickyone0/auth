package com.example.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.User;
import com.example.auth.entity.UserDTO;
import com.example.auth.service.AuthenticationService;

@RestController
public class UserController {

    @Autowired
    private AuthenticationService _authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {

        User registerUser = _authenticationService.register(userDTO);

        return registerUser;
  
    }
    
}
