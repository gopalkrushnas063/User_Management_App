package com.example.user_management_app.repository;

import com.example.user_management_app.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
    public boolean existsByEmail(String email);
}
