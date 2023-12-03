package com.sigasohqbom.api.model;

import java.time.LocalDate;

import com.sigasohqbom.api.model.pk.PlanejamentoPk;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(PlanejamentoPk.class)
public class Planejamento {
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Professor.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codProfessor")
	private Professor professor;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Disciplina.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codDisciplina")
	private Disciplina disciplina;
	
	@Column(nullable = false, length = 600)
	private String conteudo;
	
	@Id
	@Column(columnDefinition = "DATE")
	private LocalDate dataAula;
}
