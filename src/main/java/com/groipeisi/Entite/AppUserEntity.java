package com.groipeisi.Entite;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 150)
    private String prenom;
    @Column(nullable = false, length = 150)
    private String nom;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String psw;
    private int etat;
    @ManyToMany
    private List<AppRoleEntity> appRoleEntity;
    @OneToMany(mappedBy = "appUserEntity")
    private List<IaEntity> ia;

}