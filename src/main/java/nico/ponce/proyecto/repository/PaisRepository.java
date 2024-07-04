package nico.ponce.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nico.ponce.proyecto.entity.PaisEntity;

@Repository
public interface PaisRepository extends CrudRepository<PaisEntity, Integer> {
	
}
