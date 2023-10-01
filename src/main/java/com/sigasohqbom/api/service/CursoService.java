package com.sigasohqbom.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigasohqbom.api.dto.CursoDto;
import com.sigasohqbom.api.model.Curso;
import com.sigasohqbom.api.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> selectAll() {
		return cursoRepository.findAll();
	}

	public Curso selectId(Long id) throws Exception {
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if (curso.isEmpty()) {
			throw new Exception("sem registro");
		}
		
		return curso.get();
	}

	public Curso insert(CursoDto CursoDto) {
		var cursoModel = new Curso();
		BeanUtils.copyProperties(CursoDto, cursoModel);
		return cursoRepository.save(cursoModel);
	}

	public Curso updateId(Long id, CursoDto cursoDto) throws Exception {
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if (curso.isEmpty()) {
			throw new Exception("sem registro");
		}
		
		var cursoModel = curso.get();
		
		BeanUtils.copyProperties(cursoDto, cursoModel);
		return cursoRepository.save(cursoModel);
	}

	public String deleteId(Long id) throws Exception {
		Optional<Curso> curso = cursoRepository.findById(id);
		
		if (curso.isEmpty()) {
			throw new Exception("sem registro");
		}
		
		var cursoModel = curso.get();
		cursoRepository.delete(cursoModel);
		return id + "";
	}

}
