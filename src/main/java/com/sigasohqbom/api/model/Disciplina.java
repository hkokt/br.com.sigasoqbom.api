package com.sigasohqbom.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="disciplina")
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String nome;
	private int qtdHorasSemanais;
	private int semestre;
}
