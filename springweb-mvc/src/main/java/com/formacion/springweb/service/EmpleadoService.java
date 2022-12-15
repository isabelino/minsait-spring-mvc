package com.formacion.springweb.service;

import java.util.List;

import com.formacion.springweb.entity.Empleado;

public interface EmpleadoService {
	
	//mostrar todos los empleados
	public List<Empleado> mostrarEmpleados();
	//guardar empleado
	public Empleado guardarEmpleado(Empleado empleado);
	//obtener empleado por id
	public Empleado obtenerEmpleado(Long id);
	//eliminar empleado
	public void eliminarEmpleado(Long id);
	
}
