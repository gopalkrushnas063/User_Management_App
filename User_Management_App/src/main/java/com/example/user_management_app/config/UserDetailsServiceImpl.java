package com.example.user_management_app.config;

import com.example.user_management_app.model.UserDetls;
import com.example.user_management_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetls user = userRepository.findByEmail(email);

        if(user != null){
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
