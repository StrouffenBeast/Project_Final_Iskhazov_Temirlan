package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Team;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Users;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamRepository teamRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Team myTeam = teamRepository.findByMail(s);
        if(myTeam != null)
        {
            User secUser = new User(myTeam.getMail(), myTeam.getPassword(),myTeam.getTypesList());
            return secUser;

        }
        throw new UsernameNotFoundException("User Not Found");
    }

}
