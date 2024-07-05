package nico.ponce.proyecto.services;

import java.util.List;
import java.util.Optional;

import nico.ponce.proyecto.entity.AutorEntity;

public interface AutorService {
    List<AutorEntity> getAllAutores();
    Optional<AutorEntity> getAutorById(int id);
    public int saveAutor(AutorEntity autorEntity);
    void deleteAutor(int id);
}
