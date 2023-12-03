package com.sigasohqbom.api.model;

import com.sigasohqbom.api.model.dto.DisciplinaDto;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private int qtdAulas;
	
	@Column(nullable = false)
	private int semestre;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Curso.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codCurso")
	private Curso curso;

	public Disciplina(DisciplinaDto disciplinaDto, Curso curso) {
		this.nome = disciplinaDto.nome();
		this.qtdAulas = disciplinaDto.qtdAulas();
		this.semestre = disciplinaDto.semestre();
		this.curso = curso;
	}
	
	public Disciplina(Long cod, DisciplinaDto disciplinaDto, Curso curso) {
		this.cod = cod;
		this.nome = disciplinaDto.nome();
		this.qtdAulas = disciplinaDto.qtdAulas();
		this.semestre = disciplinaDto.semestre();
		this.curso = curso;
	}
	
}
