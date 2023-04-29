package com.example.Project_Iskhazov_Temirlan_IT22005.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Types implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Override
    public String getAuthority() {
        return this.type;
    }
}
