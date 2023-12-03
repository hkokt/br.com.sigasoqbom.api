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

import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.model.dto.AlunoDto;
import com.sigasohqbom.api.service.AlunoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.selectAll());
	}

	@GetMapping("/{ra}")
	public ResponseEntity<Object> getId(@PathVariable(value = "ra") String ra) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.selectId(ra));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid AlunoDto alunoDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.insert(alunoDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
		}
	}

	@PutMapping("/{ra}")
	public ResponseEntity<Object> update(@PathVariable(value = "ra") String ra,
			@RequestBody @Valid AlunoDto alunoDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.update(ra, alunoDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{ra}")
	public ResponseEntity<Object> delete(@PathVariable(value = "ra") String ra) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.delete(ra));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}