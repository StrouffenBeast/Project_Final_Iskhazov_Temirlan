package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Games;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Gender;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Skill;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Team;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TeamService{
    List<Team> getAllTeam();

    Team saveTeam(Team team);
    Team addTeam(Team team);

    Gender getGender(Long id);
    List<Gender> getAllGender();
    Games getGames(Long id);
    List<Games> getAllGames();
    Skill getSkill(Long id);
    List<Skill> getAllSkill();


}
