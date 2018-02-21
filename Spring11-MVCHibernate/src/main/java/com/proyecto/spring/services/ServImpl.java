package com.proyecto.spring.services;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.spring.datos.IDAO;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Persona;

@Service
@Transactional
public class ServImpl implements UserService {

	@Autowired
	private IDAO datos;

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(ServImpl.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona");

		}
	}

	@Override
	public List<Persona> busquedaPersona(String string) {
		logger.info("Clase ServImpl - Metodo busquedaPersona");
		return datos.busquedaPersona("%"+string+"%");

	}
	
	public Set<Persona> listadoPersona(){
		return datos.listadoPersona();
	}

	@Override
	public Persona mostrarDetalle(String string) {
		return datos.mostrarDetalle(Integer.parseInt(string));
	}
	public List<Departamento> listadoDepartamento(){
		
		List<Departamento> depList = datos.listadoDepartamento();
		
		return depList;
	}

	@Override
	public Set<Persona> busquedaPorDepartamento(String string) {
		return datos.busquedaPorDepartamento(Integer.parseInt(string));
	}
	
}
