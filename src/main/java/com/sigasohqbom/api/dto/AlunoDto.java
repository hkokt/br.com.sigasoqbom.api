package com.sigasohqbom.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDto(@NotBlank String cpf, @NotBlank String nome, @NotBlank String dataNascimento,
                       @NotBlank String emailCorporativo, @NotBlank String ra, String nomeSocial,
                       @NotBlank String emailPessoal, @NotBlank String dataConclusao2grau,
                       @NotBlank String instituicaoConclusao2grau, @NotNull int pontuacaoVestibular,
                       @NotNull int posicaoVestibular, @NotNull int anoDeIngresso, @NotNull int semestreDeIngresso,
                       @NotNull int semestreLimite, @NotNull int anoLimite) {
}
