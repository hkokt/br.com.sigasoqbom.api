package com.sigasohqbom.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigasohqbom.api.model.Curso;
import com.sigasohqbom.api.model.dto.CursoDto;
import com.sigasohqbom.api.service.CursoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.selectAll());
	}

	@GetMapping("/{cod}")
	public ResponseEntity<Object> getId(@PathVariable(value = "cod") Long cod) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoService.selectId(cod));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<Curso> insert(@RequestBody @Valid CursoDto cursoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.insert(cursoDto));
	}

	@PutMapping("/{cod}")
	public ResponseEntity<Object> update(@PathVariable(value = "cod") Long cod,
			@RequestBody @Valid CursoDto cursoDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoService.update(cod, cursoDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{cod}")
	public ResponseEntity<Object> delete(@PathVariable(value = "cod") Long cod) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoService.delete(cod));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
