package com.example.RestService.dao;

import com.example.RestService.entity.Lenguaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ILenguajeDao extends CrudRepository<Lenguaje, Long> {

    @Query("select l from Lenguaje l where l.id=?1")
    public Lenguaje findByIdSQL(Long id);
}
