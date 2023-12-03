package com.sigasohqbom.api.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisciplinaDto(
		@NotBlank String nome,

		@Min(0) int qtdAulas,

		@Min(1) int semestre,

		@NotNull Long idCurso) {

}
