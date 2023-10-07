package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigasohqbom.api.model.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByRa(String ra);
}
