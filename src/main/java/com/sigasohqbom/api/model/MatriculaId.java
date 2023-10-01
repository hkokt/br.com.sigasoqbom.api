package com.sigasohqbom.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MatriculaId {
    @ManyToOne
    @JoinColumn(name = "cod_aluno", referencedColumnName = "cod")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", referencedColumnName = "cod")
    private Disciplina disciplina;
}
