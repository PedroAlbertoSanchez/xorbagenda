package com.proyecto.spring.datos;

import java.util.List;
import java.util.Set;

import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Empleado;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Superusuario;
import com.proyecto.spring.model.Telefono;



public interface IDAO {

	public List<Persona> busquedaPersona(String string);
	public Set<Persona> listadoPersona();
	public Persona mostrarDetalle(int i);
	public Set<Departamento> listadoDepartamento();
	public Set<Persona> busquedaPorDepartamento(int i);
	public Set<Categoria> listadoCategoria();
	public void saveOrUpdate(Persona persona);
	public Departamento buscarDepartamento(String nombre);
	public Categoria buscarCategoria(String nombre);
	public void save(Persona p);
	public void delete(int id);
}
