package com.sigasohqbom.api.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sigasohqbom.api.dto.AlunoDto;
import com.sigasohqbom.api.model.Aluno;
import com.sigasohqbom.api.service.AlunoService;

import java.util.List;

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
	public ResponseEntity<Object> getRa(@PathVariable(value = "ra") String ra) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoService.selectRa(ra));
		} catch (Exception e) {
			if (e.getMessage().contains("sem registro")) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
			}
		}
	}

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody @Valid AlunoDto alunoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.insert(alunoDto));
    }

    @PutMapping("/{ra}")
    public ResponseEntity<Object> updateRa(@PathVariable(value = "ra") String ra,
                                           @RequestBody @Valid AlunoDto alunoDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.updateRa(ra, alunoDto));
        } catch (Exception e) {
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<Object> deleteId(@PathVariable(value = "ra") String ra) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(alunoService.deleteRa(ra));
        } catch (Exception e) {
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
