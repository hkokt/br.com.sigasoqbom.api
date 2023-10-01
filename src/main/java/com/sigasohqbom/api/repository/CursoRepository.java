package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigasohqbom.api.model.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}