package com.example.RestService.service;

import com.example.RestService.dao.ICursoDao;
import com.example.RestService.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) cursoDao.findAll();
    }

    @Override
    @Transactional
    public void saveCurso(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> getCursosProfesor(Long id) {
        return (List<Curso>) cursoDao.findByProfesorId(id);
    }
}
