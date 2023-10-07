package com.sigasohqbom.api.controller;

import com.sigasohqbom.api.dto.MatriculaDto;
import com.sigasohqbom.api.model.Matricula;
import com.sigasohqbom.api.repository.MatriculaRepository;
import com.sigasohqbom.api.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> getAll() {
        return matriculaService.selectAll();
    }

    @PostMapping
    public Matricula post(@RequestBody MatriculaDto matriculaDto) throws Exception {
        return matriculaService.insertMatriculaId(matriculaDto);
    }

    @GetMapping("/{alunoId}/{disciplinaId}")
    public ResponseEntity<Object> getById(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return null;
    }

    @PutMapping("/{alunoId}/{disciplinaId}")
    public ResponseEntity<Object> updateById(@PathVariable Long alunoId, @PathVariable Long disciplinaId, @RequestBody Matricula updatedMatricula) {
        return null;
    }

    @DeleteMapping("/{alunoId}/{disciplinaId}")
    public ResponseEntity<Object> deleteById(@PathVariable Long alunoId, @PathVariable Long disciplinaId) {
        return null;
    }

}
