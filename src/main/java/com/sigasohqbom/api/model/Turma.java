package com.sigasohqbom.api.model;

import java.sql.Time;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long cod;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Time horarioInicio;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Time horarioFim;
	
	@Column(nullable = false, length = 15)
	private String diaDaSemana;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Disciplina.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codDisciplina")
	private Disciplina disciplina;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Professor.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codProfessor")
	private Professor professor;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = GradeCurricular.class, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "semestreGrade", nullable = true),
		@JoinColumn(name = "codGrade", nullable = true),
		@JoinColumn(name = "anoGrade", nullable = true)
	})
	private GradeCurricular grade;
}
