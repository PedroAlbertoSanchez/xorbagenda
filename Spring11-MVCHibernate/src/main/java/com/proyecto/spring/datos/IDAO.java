package com.proyecto.spring.datos;

import java.util.List;

import com.proyecto.spring.model.Usuario;


public interface IDAO {

	public List<Usuario> busquedaUsuario(String string);
}
