package com.example.RestService.service;

import com.example.RestService.entity.Lenguaje;

import java.util.List;

public interface ILenguajeService {

    public List<Lenguaje> findAll();

    public void saveLengaje(Lenguaje lenguaje);

    public Lenguaje findLenguajeById(Long id);
}
