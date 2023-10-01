package com.sigasohqbom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigasohqbom.api.model.Disciplina;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
