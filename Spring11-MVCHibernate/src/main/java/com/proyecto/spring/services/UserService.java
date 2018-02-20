package com.proyecto.spring.services;

import java.util.List;
import java.util.Set;

import com.proyecto.spring.model.Persona;

public interface UserService {
	
	public List<Persona> busquedaPersona(String string);
	public Set<Persona> listadoPersona();
	public Persona mostrarDetalle(String string);
}
