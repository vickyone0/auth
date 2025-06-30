package com.example.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth.entity.User;
import com.example.auth.entity.UserDTO;
import com.example.auth.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository _userRepository;


    @Autowired
    private PasswordEncoder _passwordEncoder;

    public User register(UserDTO userDTO) {
        
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(_passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        user.setRole("Admin");
        return _userRepository.save(user);
    }
    
}
