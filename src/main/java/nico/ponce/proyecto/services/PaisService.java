package nico.ponce.proyecto.services;

import java.util.List;
import java.util.Optional;

import nico.ponce.proyecto.entity.PaisEntity;

public interface PaisService {
    List<PaisEntity> getAllPaises();
    Optional<PaisEntity> getPaisById(int id);
    public int savePais(PaisEntity paisEntity);
    void deletePais(int id);
}
