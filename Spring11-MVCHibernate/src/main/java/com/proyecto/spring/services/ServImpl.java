package com.proyecto.spring.services;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
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
	public void saveOrUpdate(Superusuario su) {
		
		Telefono tel1 = new Telefono(su.getTelefono1());//parseo int a String con los tres telefonos o cambiar en superusuario el telefono de int a string  y añadir 
		Telefono tel2 = new Telefono(su.getTelefono2());
		Telefono tel3 = new Telefono(su.getTelefono3()); 
		//tel 1 , tel 2, tel 3
		//crearte new HashSet
		Set <Telefono> set = new HashSet<Telefono>();
		set.add(tel1);
		set.add(tel2);
		set.add(tel3); 
		//añadir tel 1,... al hashset
		
		//introducir el set en el contructor
		
		//Todo lo mismp con direccion 
		
		Direccione dir1 = new Direccione(su.getDireccion1());  
		Direccione dir2 = new Direccione(su.getDireccion2()); 
		Direccione dir3 = new Direccione(su.getDireccion3()); 
		
		Set<Direccione> set2 = new HashSet <Direccione>(); 
		set2.add(dir1);
		set2.add(dir2);
		set2.add(dir3); 
		
		
		Departamento dep=datos.buscarDepartamento(su.getDepartamento());
		Categoria categoria = datos.buscarCategoria(su.getCategoria()); 
		Empleado emp = new Empleado (su.getCodEmpleado(), su.getSalario(), categoria, dep); 

		Persona p = new Persona (su.getApellido1(),su.getApellido2(),su.getDni(), su.getFechaNacimiento(), su.getNombre(), set2,emp, set); 
		datos.saveOrUpdate(p);
    
	}	




	@Override
	public Superusuario montarPersona(int id) {
		Persona p=datos.mostrarDetalle(id);
		int cont1=0;
		int cont2=0;
		String direccion1="";
		String direccion2="";
		String direccion3="";
		String telefono1="";
		String telefono2="";
		String telefono3="";
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
				telefono1=telefono.getTelefono();
			}else if (cont2==1){
				telefono2=telefono.getTelefono();
			}else if (cont2==2){
				telefono3=telefono.getTelefono();
			}
			cont2++;
		}
		Superusuario sup=new Superusuario(p.getIdpersonas(),p.getNombre(),p.getApellido1(),p.getApellido2(),p.getDni(),
				p.getFechaNacimiento(),	direccion1,direccion2,direccion3,telefono1,
				telefono2,telefono3,p.getEmpleado().getCodEmpleado(),p.getEmpleado().getSalario(),
				p.getEmpleado().getCategoria().getNombre(),p.getEmpleado().getDepartamento().getNombre());
		
		return sup;
		

	}


	

}
