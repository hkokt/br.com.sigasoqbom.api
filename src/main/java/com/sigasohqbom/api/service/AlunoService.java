package com.sigasohqbom.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.dto.AlunoDto;
import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.repository.AlunoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> selectAll() {
        return alunoRepository.findAll();
    }

    public Aluno selectRa(String ra) throws Exception {
        Optional<Aluno> aluno = Optional.ofNullable(alunoRepository.findByRa(ra));

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        return aluno.get();
    }

    public Aluno insert(AlunoDto alunoDto) {
        var alunoModel = new Aluno();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        alunoModel.setDataIngresso(LocalDate.now());
        return alunoRepository.save(alunoModel);
    }

    public Aluno updateRa(String ra, AlunoDto alunoDto) throws Exception {
        Optional<Aluno> aluno = Optional.ofNullable(alunoRepository.findByRa(ra));

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        var alunoModel = aluno.get();

        BeanUtils.copyProperties(alunoDto, alunoModel);
        return alunoRepository.save(alunoModel);
    }

    public Aluno deleteRa(String ra) throws Exception {
        Optional<Aluno> aluno = Optional.ofNullable(alunoRepository.findByRa(ra));

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        var alunoModel = aluno.get();
        alunoRepository.delete(alunoModel);
        return alunoModel;
    }

}
