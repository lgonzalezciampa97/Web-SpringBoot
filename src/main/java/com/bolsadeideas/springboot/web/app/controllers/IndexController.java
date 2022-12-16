package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${titulo.indexController}")
	private String textoIndex;
	
	@Value("${titulo.perfilController}")
	private String textoPerfil;
	
	@Value("${titulo.listadoController}")
	private String textoListar;
	
	@GetMapping(value = {"/index", "/", ""})
	public String index(Map<String,Object> modelo) {
		modelo.put("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping(value = "/perfil")
	public String perfil(Map<String,Object> modelo) {
		Usuario user = new Usuario();
		user.setNombre("Leonardo");
		user.setApellido("Gonzalez");
		user.setEmail("lgonzalez@gmail.com");
		
		modelo.put("usuario", user);
		modelo.put("titulo", textoPerfil.concat(user.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping(value = "/listar")
	public String listar(Model modelo) {
		modelo.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List <Usuario> pasarVistaUsuarios(){
		List <Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Leo","Gonzalez","lg@gmail.com"));
		usuarios.add(new Usuario("Andres","Benitez","ab@gmail.com"));
		usuarios.add(new Usuario("Mario","Casas","mc@gmail.com"));
		usuarios.add(new Usuario("Ramon","Rojas","rr@gmail.com"));
		
		return usuarios;
	}
	
	
}
