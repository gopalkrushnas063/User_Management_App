package com.example.user_management_app.service;

import com.example.user_management_app.model.UserDetls;

public interface UserService {
    public UserDetls createUser(UserDetls userDetails);
    public boolean checkEmail(String email);
}
