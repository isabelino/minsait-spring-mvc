package com.formacion.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formacion.springweb.service.EmpleadoService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping({"empleados","/"})
	public String index(Model modelo) {
		modelo.addAttribute("empleados", servicio.mostrarEmpleados() );
		return "empleado";
	}
	
	@GetMapping("empleados/crear")
	public String newEmpleado() {
		return "crear_empleado";
	}

}
