package com.example.RestService.service;

import com.example.RestService.entity.Curso;

import java.util.List;

public interface ICursoService {

    public List<Curso> findAll();

    public void saveCurso(Curso curso);

    public List<Curso> getCursosProfesor(Long id);
}
