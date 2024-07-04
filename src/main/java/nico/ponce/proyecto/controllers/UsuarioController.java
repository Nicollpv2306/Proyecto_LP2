package nico.ponce.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/")
public class UsuarioController {
	@GetMapping("/login")
    @ResponseBody
    public String login() {
        return "login";
    }
}
