package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisciplinaDto(@NotBlank String nome, @NotNull int qtdHorasSemanais, @NotNull int semestre) {
}
