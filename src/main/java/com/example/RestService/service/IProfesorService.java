package com.example.RestService.service;

import com.example.RestService.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface IProfesorService {
    public List<Profesor> findAll();

    public Profesor findProfesor(Profesor profesor);

    public Profesor checkProfesorLogin(Profesor profesor);

    public void deleteProfesor(Profesor profesor);

    public Profesor updateProfesor(Profesor profesor);

    public Optional<Profesor> findProfesorById(Long id);

    public void deleteProfesor(Long id);

    public void deleteAllProfesor();

    public Profesor findById(Long id);

    public Profesor findByIdSQL(Long id);

    public void save(Profesor profesor);

}
