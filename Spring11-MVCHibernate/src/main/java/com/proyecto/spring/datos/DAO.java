package com.proyecto.spring.datos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.model.Usuario;


@Repository
public class DAO implements IDAO{

	@Autowired
	private SessionFactory session;
	
	
	@Override
	public List<Usuario> busquedaUsuario(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
