package com.example.user_management_app.repository;

import com.example.user_management_app.model.UserDetls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetls,Integer> {
    public boolean existsByEmail(String email);

    public UserDetls findByEmail(String email);
}
