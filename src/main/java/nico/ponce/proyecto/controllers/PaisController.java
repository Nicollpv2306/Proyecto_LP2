package nico.ponce.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import nico.ponce.proyecto.entity.PaisEntity;
import nico.ponce.proyecto.services.PaisService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    // Listar paises
    @GetMapping
    public String getAllPaises(Model model) {
        List<PaisEntity> paises = paisService.getAllPaises();
        model.addAttribute("paises", paises);
        return "paises";
    }

    // Ir a formulario de nuevo pais
    @GetMapping("/nuevo")
    public String crear(Model model) {
        model.addAttribute("pais", new PaisEntity());
        return "formpais";
    }

    // Regresar a lista tras crear o actualizar
    @PostMapping("save")
    public String save(PaisEntity p, Model model) {
        
    	paisService.savePais(p);
        return "redirect:/paises";
    }

    // Ir a formulario de editar pais
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<PaisEntity> paisEntity = paisService.getPaisById(id);
        
	    if (paisEntity.isPresent()) {
	        PaisEntity pais = paisEntity.get();
	        model.addAttribute("pais", pais);
	    } 

	    return "formpais";
    }

    // Eliminar pais
    @GetMapping("/eliminar/{id}")
    public String deletePais(@PathVariable int id) {
        paisService.deletePais(id);
        return "redirect:/paises";
    }
}