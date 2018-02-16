package com.proyecto.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.datos.IDAO;
import com.proyecto.spring.model.Persona;
@Service
@Transactional
public class ServImpl implements UserService{

	@Autowired
	private IDAO datos;
	
	
	@Override
	public List<Persona> busquedaPersona(String string) {
		return datos.busquedaPersona(string);
	}

}
