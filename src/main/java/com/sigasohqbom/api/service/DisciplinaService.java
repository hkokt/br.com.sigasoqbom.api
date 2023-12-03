package com.sigasohqbom.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.model.Curso;
import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.model.dto.DisciplinaDto;
import com.sigasohqbom.api.repository.CursoRepository;
import com.sigasohqbom.api.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	
	public List<Disciplina> selectAll() {
		return disciplinaRepository.findAll();
	}

	public Disciplina selectId(Long id) throws Exception {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		
		if (disciplina.isEmpty()) {
			throw new Exception("Disciplina não registrada");
		}

		return disciplina.get();
	}

	public Disciplina insert(DisciplinaDto disciplinaDto) {
		Optional<Curso> curso = cursoRepository.findById(disciplinaDto.idCurso());
		Disciplina disciplinaModel = new Disciplina(disciplinaDto, curso.get());
		
		return disciplinaRepository.save(disciplinaModel);
	}

	public Disciplina update(Long id, DisciplinaDto disciplinaDto) throws Exception {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		Optional<Curso> curso = cursoRepository.findById(disciplinaDto.idCurso());

		if (disciplina.isEmpty()) {
			throw new Exception("Disciplina não registrada");
		}
		
		Disciplina disciplinaModel = new Disciplina(id,disciplinaDto, curso.get());

		return disciplinaRepository.save(disciplinaModel);
	}

	public Disciplina delete(Long id) throws Exception {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		if (disciplina.isEmpty()) {
			throw new Exception("Disciplina não registrada");
		}

		var disciplinaModel = disciplina.get();
		disciplinaRepository.delete(disciplinaModel);

		return disciplinaModel;
	}

}
