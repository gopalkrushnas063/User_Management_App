package com.example.user_management_app.service;

import com.example.user_management_app.model.UserDetails;
import com.example.user_management_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails createUser(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
