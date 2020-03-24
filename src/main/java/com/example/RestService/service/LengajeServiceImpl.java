package com.example.RestService.service;

import com.example.RestService.dao.ILenguajeDao;
import com.example.RestService.entity.Lenguaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LengajeServiceImpl implements ILenguajeService {

    @Autowired
    private ILenguajeDao lenguajeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Lenguaje> findAll() {
        return (List<Lenguaje>) lenguajeDao.findAll();
    }

    @Override
    @Transactional
    public void saveLengaje(Lenguaje lenguaje) {
        lenguajeDao.save(lenguaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Lenguaje findLenguajeById(Long id) {
        return lenguajeDao.findByIdSQL(id);
    }
}
