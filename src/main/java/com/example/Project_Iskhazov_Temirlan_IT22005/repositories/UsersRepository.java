package com.example.Project_Iskhazov_Temirlan_IT22005.repositories;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Types;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByMail(String mail);


}
