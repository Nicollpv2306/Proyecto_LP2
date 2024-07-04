package nico.ponce.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nico.ponce.proyecto.entity.PaisEntity;
import nico.ponce.proyecto.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<PaisEntity> getAllPaises() {
        return (List<PaisEntity>) paisRepository.findAll();
    }

    @Override
    public Optional<PaisEntity> getPaisById(int id) {
        return paisRepository.findById(id);
    }

    @Override
    public int savePais(PaisEntity p) {
    	
    	int res = 0;
    	PaisEntity pais = paisRepository.save(p);
    	
    	if(!pais.equals(null)) {
    		res = 1;
    	}
    	
    	return res;
    }

    @Override
    public void deletePais(int id) {
        paisRepository.deleteById(id);
    }
}