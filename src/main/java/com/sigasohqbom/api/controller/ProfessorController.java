package com.sigasohqbom.api.controller;

import com.sigasohqbom.api.service.ProfessorService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sigasohqbom.api.dto.ProfessorDto;
import com.sigasohqbom.api.model.Professor;

import java.util.List;

@RestController
@RequestMapping("/Professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.selectAll());
    }

    @GetMapping("/{cod}")
    public ResponseEntity<Object> getId(@PathVariable(value = "cod") Long cod) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(professorService.selectId(cod));
        } catch (Exception e) {
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping
    public ResponseEntity<Professor> insert(@RequestBody @Valid ProfessorDto ProfessorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.insert(ProfessorDto));
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Object> updateId(@PathVariable(value = "cod") Long cod,
                                           @RequestBody @Valid ProfessorDto ProfessorDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(professorService.updateId(cod, ProfessorDto));
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
            return ResponseEntity.status(HttpStatus.OK).body("{cod_deletado: \"" + professorService.deleteId(cod) + "\"}");
        } catch (Exception e) {
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
