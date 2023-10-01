package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotNull;

public record TurmaDto(@NotNull int semestre, @NotNull int ano, @NotNull int turma) {
}
