package com.proyecto.spring.datos;

import java.util.List;

import com.proyecto.spring.model.Persona;



public interface IDAO {

	public List<Persona> busquedaPersona(String string);
	public List<Persona> listadoPersona();
	public Persona mostarDetalle(int i);
}
