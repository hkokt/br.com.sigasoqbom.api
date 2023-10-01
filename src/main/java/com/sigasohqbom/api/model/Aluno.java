package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("aluno")
@Data
public class Aluno extends Usuario {
    private String ra;
    private String nomeSocial;
    private String emailPessoal;
    private String dataConclusao2grau;
    private String instituicaoConclusao2grau;
    private int pontuacaoVestibular;
    private int posicaoVestibular;
    private int anoDeIngresso;
    private int semestreDeIngresso;
    private int semestreLimite;
    private int anoLimite;
}
