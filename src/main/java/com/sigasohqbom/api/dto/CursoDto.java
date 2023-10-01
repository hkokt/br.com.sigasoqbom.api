package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDto(@NotBlank String nome, @NotNull int cargaHoraria, @NotBlank String sigla, @NotNull float enade) {
}
