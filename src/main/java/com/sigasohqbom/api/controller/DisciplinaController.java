package com.sigasohqbom.api.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sigasohqbom.api.dto.DisciplinaDto;
import com.sigasohqbom.api.model.Disciplina;
import com.sigasohqbom.api.service.DisciplinaService;

import java.util.List;

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
			if (e.getMessage().contains("sem registro")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@PostMapping
	public ResponseEntity<Disciplina> insert(@RequestBody @Valid DisciplinaDto DisciplinaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.insert(DisciplinaDto));
	}

	@PutMapping("/{cod}")
	public ResponseEntity<Object> updateId(@PathVariable(value = "cod") Long cod,
			@RequestBody @Valid DisciplinaDto DisciplinaDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.updateId(cod, DisciplinaDto));
		} catch (Exception e) {
			if (e.getMessage().contains("sem registro")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/{cod}")
	public ResponseEntity<Object> deleteId(@PathVariable(value = "cod") Long cod) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body("{cod_deletado: \"" + disciplinaService.deleteId(cod) + "\"}");
		} catch (Exception e) {
			if (e.getMessage().contains("sem registro")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
			}
		}
	}
}
