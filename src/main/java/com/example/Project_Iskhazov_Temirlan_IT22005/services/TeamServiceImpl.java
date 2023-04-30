package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Games;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Gender;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Skill;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Team;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.GamesRepository;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.GenderRepository;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.SkillRepository;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    GenderRepository genderRepository;

    @Override
    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveTeam(Team team) {
        return null;
    }

    @Override
    public Team addTeam(Team team) {
        return null;
    }

    @Override
    public Gender getGender(Long id) {
        return genderRepository.getOne(id);
    }

    @Override
    public List<Gender> getAllGender() {
        return genderRepository.findAll();
    }

    @Override
    public Games getGames(Long id) {
        return gamesRepository.getOne(id);
    }

    @Override
    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }

    @Override
    public Skill getSkill(Long id) {
        return skillRepository.getOne(id);
    }

    @Override
    public List<Skill> getAllSkill() {
        return skillRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Team myTeam = teamRepository.findByMail(s);
//        if(myTeam != null)
//        {
//            User secUser = new User(myTeam.getMail(), myTeam.getPassword(),myTeam.getRolesList());
//            return secUser;
//
//        }
//        throw new UsernameNotFoundException("User Not Found");
//    }

}
