package com.sigasohqbom.api.model;

import java.time.LocalDate;

import com.sigasohqbom.api.model.dto.AlunoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Aluno {

	@Id
	@Column(nullable = false, length = 15)
	private String ra;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(columnDefinition = "DATE")
	private LocalDate dataNasc;

	@Column(nullable = false, length = 100)
	private String nomeSocial;

	@Column(nullable = false, length = 100)
	private String emailPessoal;

	@Column(columnDefinition = "DATE")
	private LocalDate dataConc2grau;

	@Column(nullable = false, length = 11)
	private String cpf;

	@Column(nullable = false, length = 100)
	private String instConc2grau;

	@Column(nullable = false)
	private int ptVestibular;

	@Column(nullable = false)
	private int posVestibular;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Curso.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codCurso")
	private Curso curso;

	@Column(nullable = false, length = 100)
	private String emailCorporativo;

	@Column(columnDefinition = "DATE")
	private LocalDate dataMatricula;

	@Column(columnDefinition = "DATE")
	private LocalDate dataLimiteMatricula;
	
	public Aluno() {
		
	}
	
	public Aluno(AlunoDto alunoDto, Curso curso) {
		this.ra = alunoDto.ra();
		this.nome = alunoDto.nome();
		this.dataNasc = alunoDto.dataNasc();
		this.nomeSocial = alunoDto.nomeSocial();
		this.emailPessoal = alunoDto.emailPessoal();
		this.dataConc2grau = alunoDto.dataConc2grau();
		this.cpf = alunoDto.cpf();
		this.instConc2grau = alunoDto.instConc2grau();
		this.ptVestibular = alunoDto.ptVestibular();
		this.posVestibular = alunoDto.posVestibular();
		this.emailCorporativo = alunoDto.emailCorporativo();
		this.dataMatricula = alunoDto.dataMatricula();
		this.dataLimiteMatricula = alunoDto.dataLimiteMatricula();
		this.curso = curso;

	}

}
