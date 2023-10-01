package com.sigasohqbom.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.dto.DisciplinaDto;
import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> selectAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina selectId(Long id) throws Exception {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if (disciplina.isEmpty()) {
            throw new Exception("sem registro");
        }

        return disciplina.get();
    }

    public Disciplina insert(DisciplinaDto disciplinaDto) {
        var disciplinaModel = new Disciplina();
        BeanUtils.copyProperties(disciplinaDto, disciplinaModel);
        return disciplinaRepository.save(disciplinaModel);
    }

    public Disciplina updateId(Long id, DisciplinaDto disciplinaDto) throws Exception {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if (disciplina.isEmpty()) {
            throw new Exception("sem registro");
        }

        var disciplinaModel = disciplina.get();

        BeanUtils.copyProperties(disciplinaDto, disciplinaModel);
        return disciplinaRepository.save(disciplinaModel);
    }

    public String deleteId(Long id) throws Exception {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        if (disciplina.isEmpty()) {
            throw new Exception("sem registro");
        }

        var disciplinaModel = disciplina.get();
        disciplinaRepository.delete(disciplinaModel);
        return id + "";
    }

}
