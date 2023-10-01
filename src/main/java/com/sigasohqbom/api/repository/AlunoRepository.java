package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigasohqbom.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
