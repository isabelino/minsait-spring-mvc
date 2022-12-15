package com.formacion.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hola")
	public String hello(Model modelo) {
		String dato ="Hola desde controlador";
		modelo.addAttribute("key",dato);
		return "index";//hace referencia a la vista
	}
	
}
