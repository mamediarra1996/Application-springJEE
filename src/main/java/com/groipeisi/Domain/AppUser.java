package com.groipeisi.Domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private int id;
    @NotNull(message = "le prenom ne doit pas etre null")
     private String prenom;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
    @NotNull(message = "le email ne doit pas etre null")
    private String email;
    @NotNull(message = "le mot de passe ne doit pas etre null")
     private String psw;
    @NotNull
    private int etat;
}