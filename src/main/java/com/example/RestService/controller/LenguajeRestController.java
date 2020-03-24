package com.example.RestService.controller;

import com.example.RestService.entity.Lenguaje;
import com.example.RestService.service.ILenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LenguajeRestController {

    @Autowired
    private ILenguajeService lenguajeService;

    @GetMapping("/lenguajes")
    public ResponseEntity<?> listaLenguajes() {
        List<Lenguaje> listaLenguajes = lenguajeService.findAll();
        if(listaLenguajes != null && listaLenguajes.size() != 0) {
            return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
        } else  {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create_lenguaje")
    public ResponseEntity<?> addLengaje(@RequestBody Lenguaje lenguaje) {
        lenguajeService.saveLengaje(lenguaje);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
