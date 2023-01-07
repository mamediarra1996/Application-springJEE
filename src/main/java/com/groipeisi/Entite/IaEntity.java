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
public class IaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false ,  length = 150)
    private String nom;
    @ManyToOne
    private AppUserEntity appUserEntity;
    @OneToMany(mappedBy = "ief")
    private List<IefEntity> ief;



}
