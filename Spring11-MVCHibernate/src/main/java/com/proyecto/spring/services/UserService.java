package com.proyecto.spring.services;

import java.util.List;
import java.util.Set;

import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Superusuario;

public interface UserService {
	
	public List<Persona> busquedaPersona(String string);
	public Set<Persona> listadoPersona();
	public Persona mostrarDetalle(String string);
	public Set<Departamento> listadoDepartamento();
	public Set<Persona> busquedaPorDepartamento(String string);
	public Set<Categoria> listadoCategoria();
	public void saveOrUpdate(Superusuario superusu);
	public Superusuario montarPersona(int id);
}
