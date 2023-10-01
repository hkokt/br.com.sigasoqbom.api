package com.sigasohqbom.api.repository;

import com.sigasohqbom.api.model.Matricula;
import com.sigasohqbom.api.model.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId> {
}