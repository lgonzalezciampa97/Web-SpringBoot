package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping
	public String index() {
		return "params/index";
	}
	
	//parametros en la URL se envian: ?texto=parametro
	@GetMapping("/mapeoString")
	public String param(@RequestParam(name = "texto") String texto, Model modelo, String warning) {
		modelo.addAttribute("resultado", "El parametro enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mapeoMix")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model modelo) {
		modelo.addAttribute("texto", "El saludo es: " + saludo + " y el numero es: " + numero);
		return "params/ver";
	}
	
	@GetMapping("/mapeoMixRequest")
	public String param(HttpServletRequest request, Model modelo) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}
		catch(NumberFormatException e) {
			numero = 0;
		}
		
		modelo.addAttribute("texto", "El saludo es: " + saludo + " y el numero es: " + numero);
		return "params/ver";
	}

}
