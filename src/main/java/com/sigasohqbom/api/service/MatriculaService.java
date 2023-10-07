package com.sigasohqbom.api.service;

import com.sigasohqbom.api.dto.MatriculaDto;
import com.sigasohqbom.api.model.*;
import com.sigasohqbom.api.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private DisciplinaService disciplinaService;

    public Matricula insertMatriculaId(MatriculaDto matriculaDto) {
        MatriculaId matriculaId = new MatriculaId(matriculaDto.aluno(), matriculaDto.disciplina());
        Matricula matricula = new Matricula(matriculaId, matriculaDto.aluno(), matriculaDto.disciplina(), matriculaDto.dataMatricula(), matriculaDto.nota(), matriculaDto.faltas());
        return matriculaRepository.save(matricula);
    }

    public Matricula updateMatriculaId(MatriculaId matriculaId, LocalDate novaDataMatricula, double novaNota, int novasFaltas) throws Exception {
        Optional<Matricula> matriculaOptional = matriculaRepository.findById(matriculaId);
        if (matriculaOptional.isPresent()) {
            Matricula matriculaExistente = matriculaOptional.get();
            matriculaExistente.setDataMatricula(novaDataMatricula);
            matriculaExistente.setNota(novaNota);
            matriculaExistente.setFaltas(novasFaltas);

            return matriculaRepository.save(matriculaExistente);
        } else {
            throw new Exception("Matrícula não encontrada");
        }
    }

    public Matricula selectMatriculaId() {
        return null;
    }

    public List<Matricula> selectAll() {
        return null;
    }
}