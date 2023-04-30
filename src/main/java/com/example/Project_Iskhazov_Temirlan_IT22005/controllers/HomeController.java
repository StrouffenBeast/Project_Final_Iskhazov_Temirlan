package com.example.Project_Iskhazov_Temirlan_IT22005.controllers;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.*;
import com.example.Project_Iskhazov_Temirlan_IT22005.services.TeamService;
import com.example.Project_Iskhazov_Temirlan_IT22005.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class HomeController {

    String error;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;



    @GetMapping("/navbar")
    public String Navbar(Model model){
        model.addAttribute("currentUser",getUserData());
        return "navbar";

    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    public String main(Model model) {
        model.addAttribute("currentUser", getUserData());
        return "main";
    }

    @GetMapping( value = "/403")
    public String accessDenied(Model model){
        //model.addAttribute("currentUser",getUserData());
        return "403";

    }


    @GetMapping(value = "/profile")
    public String Profile(Model model){
        model.addAttribute("currentUser",getUserData());
        return "profile";

    }

//    @GetMapping(value = "/profileTeam")
//    public String ProfileTeam(Model model){
//        model.addAttribute("currentUser",getUserData());
//        return "profileTeam";
//
//    }

    private Users getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof  AnonymousAuthenticationToken))
        {
            User secUser = (User)authentication.getPrincipal();
            Users myUser = userService.getUserByMail(secUser.getUsername());
            return myUser;

        }
        return null;
    }

    @GetMapping(value="register")
    public String register(Model model){
        List<Gender> gender_list = userService.getAllGender();
        model.addAttribute("gender_list", gender_list);
        model.addAttribute("error", error);
        error="";
        return "register";
    }

    @PostMapping(value = "/register")
    public String toRegister(@RequestParam(name = "mail_field") String email,
                             @RequestParam(name = "password_field") String password,
                             @RequestParam(name = "re_password_field") String rePassword,
                             @RequestParam(name = "name_field") String name,
                             @RequestParam(name = "surname_field") String surname,
                             @RequestParam(name = "age_field") int age,
                             @RequestParam(name = "about_field") String about,
                             @RequestParam(name = "gender_field") Long genderId){

        Gender gender = userService.getGender(genderId);

        if(email.equals("") || password.equals("") || name.equals("") || surname.equals("") || age < 10 ){
            error = "Missing or Incorrect data";
            return "redirect:/register";
        } else{
            if(password.equals(rePassword))
            {
                Users newUser = new Users();
                newUser.setPassword(password);
                newUser.setName(name);
                newUser.setSurname(surname);
                newUser.setMail(email);
                newUser.setGender(gender);
                newUser.setAge(age);
                newUser.setAbout(about);

                System.out.println(newUser);
                if (userService.createUser(newUser) != null) {
                    return "redirect:/login";
                } else {
                    error = "Username exists ";
                }
            }
            else {
                error = "password doesn't match ";
            }


            return "redirect:/register";
        }

    }

    @GetMapping(value="newMember")
    public String newMember(Model model){
        List<Gender> gender_list = userService.getAllGender();
        error="";
        return "register";
    }

    @GetMapping("/profileTeam")
    public String profileTeam(Model model) {
        List<Team> teams = teamService.getAllTeam();
        model.addAttribute("teams", teams);

        List<Games> games = teamService.getAllGames();
        model.addAttribute("games", games);

        List<Skill> skills = teamService.getAllSkill();
        model.addAttribute("skills", skills);

        List<Gender> gender = teamService.getAllGender();
        model.addAttribute("gender", gender);

        model.addAttribute("currentUser", getUserData());

        return "profileTeam";
    }


    @GetMapping(value="/edit_profile/{idshka}")
    public String profile_details(Model model, @PathVariable(name="idshka") Long user_id){

        List<Gender> gender_list = userService.getAllGender();
        model.addAttribute("gender_list", gender_list);

        Users user = userService.getUser(user_id);
        model.addAttribute("currentUser",user);
        
        return "edit_profile";
    }

    @PostMapping("save_profile")
    public String save_profile(@RequestParam(name = "id") Long id,
                               @RequestParam(name = "age_field") int age,
                               @RequestParam(name = "password_field") String password,
                               @RequestParam(name = "name_field") String name,
                               @RequestParam(name = "surname_field") String surname,
                               @RequestParam(name = "about_field") String about,
                               @RequestParam(name = "gender_field") Long gender_id) {




        Users user = userService.getUser(id);

        Gender gender = userService.getGender(gender_id);

        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setGender(gender);
        user.setAbout(about);
        userService.saveUser(user);
        return "redirect:/profile";
    }

}

