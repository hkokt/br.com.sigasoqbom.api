package com.sigasohqbom.api.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class MatriculaId {
    @ManyToOne
    @JoinColumn(name = "ra_aluno", referencedColumnName = "ra")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", referencedColumnName = "cod")
    private Disciplina disciplina;

    public MatriculaId(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }
}
