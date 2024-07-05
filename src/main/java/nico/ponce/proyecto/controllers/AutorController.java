package nico.ponce.proyecto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import nico.ponce.proyecto.entity.AutorEntity;
import nico.ponce.proyecto.entity.PaisEntity;
import nico.ponce.proyecto.services.AutorService;
import nico.ponce.proyecto.services.PaisService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private PaisService paisService;
		
    // Listar autores
    @GetMapping
    public String getAllAutores(Model model) {
    	List<PaisEntity> paises = paisService.getAllPaises();
        List<AutorEntity> autores = autorService.getAllAutores();
        model.addAttribute("autores", autores);
        model.addAttribute("paises", paises);
        return "autores";
    }
    
    // Ir a formulario de nuevo autor
    @GetMapping("/nuevo")
    public String crear(Model model) {
    	List<PaisEntity> paises = paisService.getAllPaises();
        model.addAttribute("autor", new AutorEntity());
        model.addAttribute("paises", paises);
        return "formautor";
    }
    
    // Regresar a lista tras crear o actualizar
    @PostMapping("save")
    public String save(AutorEntity a, Model model) {
        
    	autorService.saveAutor(a);
        return "redirect:/autores";
    }
    
    // Ir a formulario de editar pais
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
    	List<PaisEntity> paises = paisService.getAllPaises();
        Optional<AutorEntity> autorEntity = autorService.getAutorById(id);
        
        
	    if (autorEntity.isPresent()) {
	        AutorEntity autor = autorEntity.get();
	        model.addAttribute("paises", paises);
	        model.addAttribute("autor", autor);
	    } 

	    return "formautor";
    }
    
    // Eliminar autor
    @GetMapping("/eliminar/{id}")
    public String deleteAutor(@PathVariable int id) {
        autorService.deleteAutor(id);
        return "redirect:/autores";
    }
}