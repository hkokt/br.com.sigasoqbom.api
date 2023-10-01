package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fatec")
@Data
public class Fatec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;
    private String nome;
}
