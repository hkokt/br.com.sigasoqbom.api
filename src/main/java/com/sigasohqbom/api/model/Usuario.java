package com.sigasohqbom.api.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "usuario", discriminatorType = DiscriminatorType.STRING)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    private String cpf;
    private String nome;
    private String dataNascimento;
    private String emailCorporativo;
}
