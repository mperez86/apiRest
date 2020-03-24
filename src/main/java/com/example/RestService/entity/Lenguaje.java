package com.example.RestService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lenguajes")
public class Lenguaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToMany
    @JoinTable(name = "profesores_lenguajes",
            joinColumns = @JoinColumn(name = "lenguaje_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id")) // tabla pivot
    private Set<Profesor>profesores = new HashSet<Profesor>();

    @PrePersist
    public void prePersist() {
        date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    private static final long serialVersionUID = 1L;

}
