package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Gender;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Users getUserByEmail(String mail);

    Optional<Users> getUserById(Long id);
    Users createUser(Users user);


    Users saveUser(Users users);

    Users getUser(Long id);

    Gender getGender(Long id);

    List<Gender> getAllGender();

}
