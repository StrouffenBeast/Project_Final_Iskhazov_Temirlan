package com.example.Project_Iskhazov_Temirlan_IT22005.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genre")

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private String genre;

}
