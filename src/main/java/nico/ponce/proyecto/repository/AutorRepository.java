package nico.ponce.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nico.ponce.proyecto.entity.AutorEntity;

@Repository
public interface AutorRepository extends CrudRepository<AutorEntity, Integer> {
	
}
