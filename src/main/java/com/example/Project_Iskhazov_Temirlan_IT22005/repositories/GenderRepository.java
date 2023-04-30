package com.example.Project_Iskhazov_Temirlan_IT22005.repositories;

import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Gender;
import com.example.Project_Iskhazov_Temirlan_IT22005.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
