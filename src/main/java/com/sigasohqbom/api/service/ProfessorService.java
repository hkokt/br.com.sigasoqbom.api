package com.sigasohqbom.api.service;

import com.sigasohqbom.api.dto.ProfessorDto;
import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.model.Professor;
import com.sigasohqbom.api.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> selectAll() {
        return professorRepository.findAll();
    }

    public Professor selectId(Long id) throws Exception {
        Optional<Professor> Professor = professorRepository.findById(id);

        if (Professor.isEmpty()) {
            throw new Exception("sem registro");
        }

        return Professor.get();
    }

    public Professor insert(ProfessorDto ProfessorDto) {
        var ProfessorModel = new Professor();
        BeanUtils.copyProperties(ProfessorDto, ProfessorModel);

        return professorRepository.save(ProfessorModel);
    }

    public Professor updateId(Long id, ProfessorDto ProfessorDto) throws Exception {
        Optional<Professor> Professor = professorRepository.findById(id);

        if (Professor.isEmpty()) {
            throw new Exception("sem registro");
        }

        var ProfessorModel = Professor.get();
        BeanUtils.copyProperties(ProfessorDto, ProfessorModel);

        return professorRepository.save(ProfessorModel);
    }

    public String deleteId(Long id) throws Exception {
        Optional<Professor> Professor = professorRepository.findById(id);

        if (Professor.isEmpty()) {
            throw new Exception("sem registro");
        }

        var ProfessorModel = Professor.get();
        professorRepository.delete(ProfessorModel);

        return id + "";
    }
}
