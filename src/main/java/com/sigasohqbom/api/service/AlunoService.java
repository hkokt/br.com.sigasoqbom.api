package com.sigasohqbom.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.model.Curso;
import com.sigasohqbom.api.model.dto.AlunoDto;
import com.sigasohqbom.api.repository.AlunoRepository;
import com.sigasohqbom.api.repository.CursoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	public List<Aluno> selectAll() {
		return alunoRepository.findAll();
	}

	public Aluno selectId(String ra) throws Exception {
		Optional<Aluno> aluno = alunoRepository.findById(ra);
		if (aluno.isEmpty()) {
			throw new Exception("Aluno não registrado");
		}

		return aluno.get();
	}

	public Aluno insert(AlunoDto alunoDto) throws Exception {
		Optional<Curso> curso = cursoRepository.findById(alunoDto.idCurso());
		Aluno aluno = new Aluno(alunoDto, curso.get());
		
		return alunoRepository.save(aluno);
	}

	public Aluno update(String ra, AlunoDto alunoDto) throws Exception {
		Optional<Aluno> aluno = alunoRepository.findById(ra);
		Optional<Curso> curso = cursoRepository.findById(alunoDto.idCurso());
		
		if (aluno.isEmpty()) {
			throw new Exception("Aluno não registrado");
		}
		
		var alunoModel = aluno.get();
		BeanUtils.copyProperties(new Aluno(alunoDto, curso.get()), alunoModel);
		
		return alunoRepository.save(alunoModel);
	}

	public Aluno delete(String ra) throws Exception {
		Optional<Aluno> aluno = alunoRepository.findById(ra);
		if (aluno.isEmpty()) {
			throw new Exception("Aluno não registrado");
		}

		var alunoModel = aluno.get();
		alunoRepository.delete(alunoModel);

		return alunoModel;
	}
}
