package com.example.Project_Iskhazov_Temirlan_IT22005.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "skill")
    private String skill;



}
