package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigasohqbom.api.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>  {

}
