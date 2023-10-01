package com.sigasohqbom.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.dto.AlunoDto;
import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> selectAll() {
        return alunoRepository.findAll();
    }

    public Aluno selectId(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        return aluno.get();
    }

    public Aluno insert(AlunoDto alunoDto) {
        var alunoModel = new Aluno();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return alunoRepository.save(alunoModel);
    }

    public Aluno updateId(Long id, AlunoDto alunoDto) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        var alunoModel = aluno.get();

        BeanUtils.copyProperties(alunoDto, alunoModel);
        return alunoRepository.save(alunoModel);
    }

    public String deleteId(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            throw new Exception("sem registro");
        }

        var alunoModel = aluno.get();
        alunoRepository.delete(alunoModel);
        return id + "";
    }

}
