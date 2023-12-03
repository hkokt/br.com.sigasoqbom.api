package com.sigasohqbom.api.model;

import com.sigasohqbom.api.model.pk.ChamadaPk;
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
@IdClass(ChamadaPk.class)
public class Chamada {
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Aluno.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "raAluno")
	private Aluno aluno;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Turma.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codTurma")
	private Turma turma;
	
	@Id
	@Column(nullable = false)
	private int ano;
	
	@Id
	@Column(nullable = false)
	private int semestre;
}
