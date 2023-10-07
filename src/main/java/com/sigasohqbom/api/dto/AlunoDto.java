package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoDto(
        @NotBlank @NotNull String ra,
        String nomeSocial,
        String emailPessoal,
        @NotBlank @NotNull String dataConclusao2grau,
        @NotBlank @NotNull String instituicaoConclusao2grau,
        @NotNull int pontuacaoVestibular,
        @NotNull int posicaoVestibular
) {
}
