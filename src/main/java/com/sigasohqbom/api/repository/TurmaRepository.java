package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigasohqbom.api.model.Turma;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

}
