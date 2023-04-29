package com.example.Project_Iskhazov_Temirlan_IT22005.controllers;

import com.example.Project_Iskhazov_Temirlan_IT22005.services.TeamService;
import com.example.Project_Iskhazov_Temirlan_IT22005.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    public String main(Model model) {
        //model.addAttribute("currentUser", getUserData());
        return "main";
    }

    @GetMapping( value = "/403")
    public String accessDenied(Model model){
        return "403";

    }








//    @GetMapping(value="/register")
//    public String register(Model model){
//        model.addAttribute("currentUser", getUserData());
//
//
//        return "register";
//    }

//    @PostMapping(value = "/register")
//    public String toRegister(@RequestParam(name = "username_field") String username,
//                             @RequestParam(name = "email_field") String email,
//                             @RequestParam(name = "password_field") String password,
//                             @RequestParam(name = "re_password_field") String rePassword,
//                             @RequestParam(name = "name_field") String name,
//                             @RequestParam(name = "surname_field") String surname,
//                             @RequestParam(name = "about_field") String about,
//                             @RequestParam(name = "gender_field") String gender){
//        if(password.equals(rePassword))
//        {
//            Users newUser = new Users();
//            newUser.setUsername(username);
//            newUser.setPassword(password);
//            newUser.setName(name);
//            newUser.setSurname(surname);
//            newUser.setEmail(email);
//            newUser.setGender(gender);
//            newUser.setAbout_me(about);
//            newUser.setTicket(false);
//
//            if(userService.createUser(newUser) != null){
//                return "redirect:/register?success";
//            }
//        }
//
//        return "redirect:/register?error";
//    }



}

