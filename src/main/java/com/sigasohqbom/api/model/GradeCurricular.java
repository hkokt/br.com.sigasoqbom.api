package com.sigasohqbom.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(GradeCurricular.class)
public class GradeCurricular {
	@Id
	private Long cod;
	
	@Id
	@Column(nullable = false)
	private int ano;

	@Id
	@Column(nullable = false)
	private int semestre;
}
