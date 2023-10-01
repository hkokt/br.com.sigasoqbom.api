package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "turma")
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cod;

    @OneToMany
    @JoinColumn(name = "cod_matricula")
    private List<Matricula> matricula;

    private int semestre;
    private int ano;
}
