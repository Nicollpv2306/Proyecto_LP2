package nico.ponce.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nico.ponce.proyecto.entity.AutorEntity;
import nico.ponce.proyecto.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public List<AutorEntity> getAllAutores() {
		return (List<AutorEntity>) autorRepository.findAll();
	}

	@Override
	public Optional<AutorEntity> getAutorById(int id) {
		return autorRepository.findById(id);
	}

	@Override
	public int saveAutor(AutorEntity autorEntity) {
    	int res = 0;
    	AutorEntity autor = autorRepository.save(autorEntity);
    	
    	if(!autor.equals(null)) {
    		res = 1;
    	}
    	
    	return res;
	}

	@Override
	public void deleteAutor(int id) {
		autorRepository.deleteById(id);
	}
}
