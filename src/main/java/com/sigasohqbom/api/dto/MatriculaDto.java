package com.sigasohqbom.api.dto;

import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.model.Matricula;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MatriculaDto(
        Aluno aluno,
        Disciplina disciplina,
        LocalDate dataMatricula,
        double nota,
        int faltas
) {
}
