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
import com.proyecto.spring.model.Direccione;
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
	public Superusuario montarPersona(int id) {
		Persona p=datos.mostrarDetalle(id);
		int cont1=0;
		int cont2=0;
		String direccion1="";
		String direccion2="";
		String direccion3="";
		int telefono1=0;
		int telefono2=0;
		int telefono3=0;
		for( Direccione direccion:p.getDirecciones() ){
			if (cont1==0){
				direccion1=direccion.getDireccion();
			}else if (cont1==1){
				direccion2=direccion.getDireccion();
			}else if (cont1==2){
				direccion3=direccion.getDireccion();
			}
			cont1++;
		}for(Telefono telefono:p.getTelefonos() ){
			if (cont2==0){
				telefono1=Integer.parseInt(telefono.getTelefono());
			}else if (cont2==1){
				telefono2=Integer.parseInt(telefono.getTelefono());
			}else if (cont2==2){
				telefono3=Integer.parseInt(telefono.getTelefono());
			}
			cont2++;
		}
		Superusuario sup=new Superusuario(p.getIdpersonas(),p.getNombre(),p.getApellido1(),p.getApellido2(),p.getDni(),
				p.getFechaNacimiento(),	direccion1,direccion2,direccion3,telefono1,
				telefono2,telefono3,p.getEmpleado().getCodEmpleado(),p.getEmpleado().getFechaAlta(),p.getEmpleado().getSalario(),
				p.getEmpleado().getCategoria().getNombre(),p.getEmpleado().getDepartamento().getNombre());
		
		return sup;
		
	}	
}
