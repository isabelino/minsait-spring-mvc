package com.formacion.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacion.springweb.entity.Empleado;
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
	public String newEmpleado(Model modelo) {
		Empleado empleado = new Empleado();
		modelo.addAttribute("empleado", empleado);
		return "crear_empleado";
	}
	@PostMapping("empleado")
	public String addEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";
	}
	@GetMapping("empleado/editar/{id}")
	public String editEmpleado(@PathVariable long id, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleado(id) );
		return "editar_empleado";
	}
	
	@PostMapping("empleado/update/{id}")
	public String updateEmpleado(@PathVariable long id,@ModelAttribute("empleado") Empleado empleado) {
		
		
		empleado.setId(servicio.obtenerEmpleado(id).getId());
		
		
		/*Empleado empleadoExistente = servicio.obtenerEmpleado(id);
		empleadoExistente.setId(id);
		empleadoExistente.setNombre(empleado.getNombre());
		empleadoExistente.setApellido(empleado.getApellido());
		empleadoExistente.setEmail(empleado.getEmail());
		empleadoExistente.setTelefono(empleado.getTelefono());*/
		
		servicio.guardarEmpleado( empleado);
		
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleado/borrar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
		return "redirect:/empleados"; 
	}
	
	
	
	

}
