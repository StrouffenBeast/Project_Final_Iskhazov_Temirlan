package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Users;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = userRepository.findByMail(s);
        if(myUser != null)
        {
            User secUser = new User(myUser.getMail(), myUser.getPassword(),myUser.getTypesList());
            return secUser;
        }

        throw new UsernameNotFoundException("User Not Found");

    }
}
