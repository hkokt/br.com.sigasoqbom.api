package com.sigasohqbom.api.model.pk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Embeddable
public class GradeCurricularPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ano;
	private int semestre;
}
