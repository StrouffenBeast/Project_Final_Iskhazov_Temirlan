package com.example.Project_Iskhazov_Temirlan_IT22005.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "lengthOfService")
    private int lengthOfService;

    @Column(name = "about")
    private String about;

    @ManyToOne(fetch = FetchType.EAGER)
    private IsMember isMember;

    @ManyToOne(fetch = FetchType.EAGER)
    private Games games;

    @ManyToOne(fetch = FetchType.EAGER)
    private Skill skill;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Types> typesList;
}
