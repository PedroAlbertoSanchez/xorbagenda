package com.proyecto.spring.datos;

import java.util.List;
import java.util.Set;

import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Persona;



public interface IDAO {

	public List<Persona> busquedaPersona(String string);
	public Set<Persona> listadoPersona();
	public Persona mostrarDetalle(int i);
	public List<Departamento> listadoDepartamento();
	public Set<Persona> busquedaPorDepartamento(int i);
	public List<Categoria> listadoCategoria();
}
