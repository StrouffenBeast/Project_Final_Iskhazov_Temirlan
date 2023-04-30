package com.example.Project_Iskhazov_Temirlan_IT22005.services;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Gender;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Roles;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Users;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.GenderRepository;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.RolesRepository;
import com.example.Project_Iskhazov_Temirlan_IT22005.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = userRepository.findByMail(s);
        if(myUser != null)
        {
            User secUser = new User(myUser.getMail(), myUser.getPassword(),myUser.getRolesList());
            return secUser;
        }

        throw new UsernameNotFoundException("User Not Found");

    }

    @Override
    public Users getUserByEmail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users createUser(Users user) {
        Users checkUser = userRepository.findByMail(user.getMail());
        if(checkUser == null){
            Roles role = rolesRepository.findByRole("ROLE_USER");
            if(role!=null)
            {
                ArrayList<Roles> roles = new ArrayList<>();
                roles.add(role);
                user.setRolesList(roles);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public Users getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Gender getGender(Long id) {
        return genderRepository.getOne(id);
    }

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
    @Override
    public List<Gender> getAllGender() {
        return genderRepository.findAll();
    }
}
