package com.example.RestService.dao;

import com.example.RestService.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICursoDao extends CrudRepository<Curso, Long> {

    public List<Curso> findByProfesorId(Long id);
}
