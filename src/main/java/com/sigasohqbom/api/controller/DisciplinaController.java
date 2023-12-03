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

import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.model.dto.DisciplinaDto;
import com.sigasohqbom.api.service.DisciplinaService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping
	public ResponseEntity<List<Disciplina>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.selectAll());
	}

	@GetMapping("/{cod}")
	public ResponseEntity<Object> getId(@PathVariable(value = "cod") Long cod) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.selectId(cod));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<Disciplina> insert(@RequestBody @Valid DisciplinaDto disciplinaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.insert(disciplinaDto));
	}

	@PutMapping("/{cod}")
	public ResponseEntity<Object> update(@PathVariable(value = "cod") Long cod,
			@RequestBody @Valid DisciplinaDto disciplinaDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.update(cod, disciplinaDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{cod}")
	public ResponseEntity<Object> delete(@PathVariable(value = "cod") Long cod) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.delete(cod));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}	
