package com.example.RestService.controller;

import com.example.RestService.entity.Lenguaje;
import com.example.RestService.entity.Profesor;
import com.example.RestService.model.ProfesorLenguaje;
import com.example.RestService.service.ILenguajeService;
import com.example.RestService.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ProfesorLenguajeRestController {

    @Autowired
    private ILenguajeService lenguajeService;

    @Autowired
    private IProfesorService profesorService;

    @PostMapping("/lenguajes_profesor")
    public ResponseEntity<?> listaLengajesProfesor(@RequestBody Profesor profesor) {
        Profesor profesorDb = profesorService.findById(profesor.getId());
        if(profesorDb != null) {
            Collection<Lenguaje> listaLengajes = profesorDb.getLenguajes();
            if(listaLengajes != null) {
                return new ResponseEntity<>(listaLengajes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save_lenguaje_profesor")
    public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorLenguaje) {
        Profesor profesorDB = profesorService.findById(profesorLenguaje.getProfesor().getId());
        if(profesorDB != null) {
            Lenguaje lenguajeDb = lenguajeService.findLenguajeById(profesorLenguaje.getLenguaje().getId());
            if (lenguajeDb != null) {
                profesorDB.addLenguaje(lenguajeDb);
                profesorService.save(profesorDB);
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
