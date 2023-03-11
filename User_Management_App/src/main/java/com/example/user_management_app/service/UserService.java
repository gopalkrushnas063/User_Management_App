package com.example.user_management_app.service;

import com.example.user_management_app.model.UserDetails;

public interface UserService {
    public UserDetails createUser(UserDetails userDetails);
    public boolean checkEmail(String email);
}
