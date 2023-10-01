package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "matricula")
@Data
public class Matricula {
    @EmbeddedId
    private MatriculaId id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cod_aluno", referencedColumnName = "cod", insertable = false, updatable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", referencedColumnName = "cod", insertable = false, updatable = false)
    private Disciplina disciplina;

}

