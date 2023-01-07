package com.groipeisi.Domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ief {
    private int id;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;


}
