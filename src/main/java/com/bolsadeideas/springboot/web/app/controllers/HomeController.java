package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homeRedirect() {
		//redirige a una ruta especificada gracias a el return "redirect:(ruta)"
		return "redirect:/app/index";
	}


}
