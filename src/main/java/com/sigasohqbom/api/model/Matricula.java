package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "matricula")
@Data
public class Matricula {
    @EmbeddedId
    private MatriculaId matriculaId;

    @ManyToOne
    @JoinColumn(name = "ra_aluno", referencedColumnName = "ra", insertable = false, updatable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", referencedColumnName = "cod", insertable = false, updatable = false)
    private Disciplina disciplina;

    private LocalDate dataMatricula;
    private double nota;
    private int faltas;

    public Matricula(MatriculaId matriculaId, Aluno aluno, Disciplina disciplina, LocalDate dataMatricula, double nota, int faltas) {
        this.matriculaId = matriculaId;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
        this.nota = nota;
        this.faltas = faltas;
    }
}
