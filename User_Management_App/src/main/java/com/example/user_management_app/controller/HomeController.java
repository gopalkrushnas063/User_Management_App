package com.example.user_management_app.controller;

import com.example.user_management_app.model.UserDetails;
import com.example.user_management_app.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String signup(){
        return "register";
    }


    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetails userDetails, HttpSession session){
        //System.out.println(userDetails);

        boolean email = userService.checkEmail(userDetails.getEmail());

        if(email){
            session.setAttribute("msg","Email ID Already Exist");
        }else {
            UserDetails userDetails1 =  userService.createUser(userDetails);
            if(userDetails1 != null){
                session.setAttribute("msg","Register Successfully");
            }else {
                session.setAttribute("msg","Something went wrong in server");
            }
        }

        return "redirect:/register";
    }
}
