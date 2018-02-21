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
import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Empleado;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Superusuario;
import com.proyecto.spring.model.Telefono;

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

	@Override
	public List<Categoria> listadoCategoria() {
		List<Categoria> catList = datos.listadoCategoria();
		
		return catList;
	}

	@Override
	public void saveOrUpdate(Superusuario su) {
		
		//Telefono tel=new Telefono(su.getTelefono1());//pareso int a String con los tres telefonos o cambiar en superusuario el telefono de int a string  y añadir 
		//tel 1 , tel 2, tel 3
		//crearte new HashSet
		//añadir tel 1,... al hashset
		//introducir el set en el contructor
		//Todo lo mismp con direccion 
		Departamento dep=datos.buscarDepartamento(su.getDepartamento());
		 Categoria categoria = datos.buscarCategoria(su.getCategoria()); 
		Empleado emp = new Empleado (su.getCodEmpleado(), su.getFechaAlta(), su.getSalario(), categoria, dep); 
		//Persona p = new Persona (su.getApellido1(),su.getApellido2(),su.getDni(), su.getFechaNacimiento(), su.getNombre(), su.getTelefono1()); 
	}	
}
