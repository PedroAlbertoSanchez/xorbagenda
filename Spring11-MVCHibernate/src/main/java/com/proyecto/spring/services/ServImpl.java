package com.proyecto.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.datos.IDAO;
import com.proyecto.spring.model.Usuario;
@Service
public class ServImpl implements UserService{

	@Autowired
	private IDAO datos;
	
	
	@Override
	public List<Usuario> busquedaUsuario(String string) {
		return datos.busquedaUsuario(string);
	}

}
