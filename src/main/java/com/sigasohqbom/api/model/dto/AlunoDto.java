package com.sigasohqbom.api.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record AlunoDto(@NotBlank @Size(max = 15) String ra,

		@NotBlank @Size(max = 100) String nome,

		@Past LocalDate dataNasc,

		@NotBlank @Size(max = 100) String nomeSocial,

		@NotBlank @Size(max = 100) @Email String emailPessoal,

		@Past LocalDate dataConc2grau,

		@NotBlank @Size(min = 11, max = 11) String cpf,

		@NotBlank @Size(max = 100) String instConc2grau,

		@Min(0) int ptVestibular,

		@Min(0) int posVestibular,

		@NotBlank @Size(max = 100) @Email String emailCorporativo,

		@NotNull Long idCurso,
		
		@Past LocalDate dataMatricula,

		@FutureOrPresent LocalDate dataLimiteMatricula) {

}
