package com.sigasohqbom.api.model.pk;

import java.io.Serializable;
import java.time.LocalDate;

import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.model.Professor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Embeddable
public class PlanejamentoPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private Disciplina disciplina;
	private LocalDate dataAula;
}
