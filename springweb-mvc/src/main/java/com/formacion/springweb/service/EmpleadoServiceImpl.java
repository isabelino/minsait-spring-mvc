package com.formacion.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.springweb.entity.Empleado;
import com.formacion.springweb.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository repositorio;

	@Override
	public List<Empleado> mostrarEmpleados() {
		return repositorio.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public Empleado obtenerEmpleado(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarEmpleado(Long id) {
		repositorio.deleteById(id);
	}

}
