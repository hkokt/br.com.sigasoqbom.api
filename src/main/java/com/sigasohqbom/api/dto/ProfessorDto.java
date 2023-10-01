package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfessorDto(
        @NotBlank String cpf,
        @NotBlank String nome,
        @NotBlank String dataDeNascimento,
        @NotBlank String emailCorporativo
) {
}
