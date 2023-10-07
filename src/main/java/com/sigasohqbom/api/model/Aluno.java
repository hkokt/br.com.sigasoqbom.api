package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("aluno")
@Data
public class Aluno extends Usuario {

    @Column(name = "ra", unique = true)
    private String ra;
    private String nomeSocial;
    private String emailPessoal;
    private String dataConclusao2grau;
    private String instituicaoConclusao2grau;
    private int pontuacaoVestibular;
    private int posicaoVestibular;
    private LocalDate dataIngresso;

}
