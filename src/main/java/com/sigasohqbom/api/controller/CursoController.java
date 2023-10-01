package com.sigasohqbom.api.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sigasohqbom.api.dto.CursoDto;
import com.sigasohqbom.api.model.Curso;
import com.sigasohqbom.api.service.CursoService;

import java.util.List;

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
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping
    public ResponseEntity<Curso> insert(@RequestBody @Valid CursoDto CursoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.insert(CursoDto));
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Object> updateId(@PathVariable(value = "cod") Long cod,
                                              @RequestBody @Valid CursoDto CursoDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.updateId(cod, CursoDto));
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
            return ResponseEntity.status(HttpStatus.OK).body("{cod_deletado: \"" + cursoService.deleteId(cod) + "\"}");
        } catch (Exception e) {
            if (e.getMessage().contains("sem registro")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errors.NOT_FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Errors.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
