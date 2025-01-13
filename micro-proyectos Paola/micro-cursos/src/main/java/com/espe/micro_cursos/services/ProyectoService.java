package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {
    List<Proyecto> findAll();
    Optional<Proyecto> findById(int id);
    Proyecto save(Proyecto proyecto);
    void deleteById(int id);
}