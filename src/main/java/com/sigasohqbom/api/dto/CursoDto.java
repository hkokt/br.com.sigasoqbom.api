package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDto(
        @NotBlank @NotNull String nome,
        @NotNull int cargaHoraria,
        @NotBlank @NotNull String sigla,
        @NotNull float enade) {
}
