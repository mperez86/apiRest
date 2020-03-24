package com.example.RestService.controller;

import com.example.RestService.entity.Profesor;
import com.example.RestService.mapper.Mapper;
import com.example.RestService.model.MProfesor;
import com.example.RestService.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> getProfesores() {
        return profesorService.findAll();
    }

    @PostMapping("/find_profesor")
    public ResponseEntity<?> findProfesor(@RequestBody Profesor profesor) {

        Profesor profesorDb = profesorService.findProfesor(profesor);

        if(profesorDb != null) {
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/sign_up")
    public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
        if(profesorService.findProfesor(profesor)==null) {
            profesorService.save(profesor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor) {

        Profesor profesorDb = null;
        profesorDb = profesorService.checkProfesorLogin(profesor);

        if(profesorDb != null) {
            List<Profesor> profesores = new ArrayList<>();
            profesores.add(profesorDb);
            List<MProfesor> mProfesores = new ArrayList<>();
            mProfesores = Mapper.convertirLista(profesores);
            return new ResponseEntity<>(mProfesores, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateProfesor(@PathVariable(value = "id") Long id, @RequestBody Profesor profesor) {

        Profesor profesorDb = null;
        profesorDb = profesorService.findById(id);

        if(profesorDb != null) {
            profesorDb.setEmail(profesor.getEmail());
            profesorDb.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorDb);
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update_sql")
    public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor) {

        Profesor profesorDb = null;
        profesorDb = profesorService.findByIdSQL(profesor.getId());

        if(profesorDb != null) {
            profesorDb.setEmail(profesor.getEmail());
            profesorDb.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorDb);
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable(value = "id") Long id) {

        Profesor profesorDb = null;
        profesorDb = profesorService.findById(id);
        if(profesorDb != null) {
            profesorService.deleteProfesor(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteAllProfesor() {

        profesorService.deleteAllProfesor();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping(path = "/delete_post")
    public ResponseEntity<Void> deleteProfesorPost(@RequestBody Profesor profesor) {

        if(profesorService.findProfesor(profesor) != null) {
            profesorService.deleteProfesor(profesor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
