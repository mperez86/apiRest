package com.example.RestService.controller;

import com.example.RestService.entity.Curso;
import com.example.RestService.entity.Profesor;
import com.example.RestService.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
    private ICursoService iCursoService;

    @GetMapping("/cursos")
    public ResponseEntity<?> listaCursos() {
        List<Curso> listaCursos = iCursoService.findAll();

        if(listaCursos != null && listaCursos.size() != 0) {
            return new ResponseEntity<>(listaCursos, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create_curso")
    public ResponseEntity<?> addCurso(@RequestBody Curso curso) {
        iCursoService.saveCurso(curso);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/cursos_profesor")
    public ResponseEntity<?> verCrusosProfesor(@RequestBody Profesor profesor) {
        List<Curso> listaCursos = iCursoService.getCursosProfesor(profesor.getId());

        if(listaCursos != null && listaCursos.size() != 0) {
            return new ResponseEntity<>(listaCursos, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
