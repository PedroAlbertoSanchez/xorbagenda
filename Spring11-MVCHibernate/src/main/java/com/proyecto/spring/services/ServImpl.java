package com.proyecto.spring.services;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public Set<Departamento> listadoDepartamento(){
		
		Set<Departamento> depList = datos.listadoDepartamento();
		
		return depList;
	}

	@Override
	public Set<Persona> busquedaPorDepartamento(String string) {
		return datos.busquedaPorDepartamento(Integer.parseInt(string));
	}

	@Override
	public Set<Categoria> listadoCategoria() {
		Set<Categoria> catList = datos.listadoCategoria();
		
		return catList;
	}


	@Override
	public void saveOrUpdate(Superusuario su) {
		 
		//tel 1 , tel 2, tel 3
		//crearte new HashSet
		Set <Telefono> set = new HashSet<Telefono>();

		//añadir tel 1,... al hashset
		
		//introducir el set en el contructor
		
		//Todo lo mismp con direccion 
		
		Set<Direccione> set2 = new HashSet <Direccione>(); 
		

		logger.info(su.getFechaNacimiento());
		logger.info("---------- askjdfkas j-----"+su.getDepartamento());
		Departamento dep=datos.buscarDepartamento(su.getDepartamento());
		Categoria categoria = datos.buscarCategoria(su.getCategoria()); 
		Empleado emp = new Empleado (su.getCodEmpleado(), su.getSalario(), categoria, dep); 
		emp.setIdempleados(su.getIdempleados());
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try{
			fecha = formatoDelTexto.parse(su.getFechaNacimiento());
		}
		catch (ParseException ex){
			ex.printStackTrace();
		}
		Persona p = new Persona (su.getApellido1(),su.getApellido2(),su.getDni(), fecha, su.getNombre(), set2,emp, set); 
		
		Telefono tel1 = new Telefono(su.getIdtelefonos1(),su.getTelefono1(),p);//parseo int a String con los tres telefonos o cambiar en superusuario el telefono de int a string  y añadir 
		Telefono tel2 = new Telefono(su.getIdtelefonos2(),su.getTelefono2(),p);
		Telefono tel3 = new Telefono(su.getIdtelefonos3(),su.getTelefono3(),p);
		if( tel1.getTelefono() !="" ){
			set.add(tel1);
		}
		
		if( tel2.getTelefono() != ""){
			set.add(tel2);
		}
		
		if( tel3.getTelefono() != ""){
			set.add(tel3);
		} 
		Direccione dir1 = new Direccione(su.getIddirecciones1(),su.getCodPostal1(),su.getDireccion1(),su.getLocalidad1(),su.getProvincia1(),p);  
		Direccione dir2 = new Direccione(su.getIddirecciones2(),su.getCodPostal2(),su.getDireccion2(),su.getLocalidad2(),su.getProvincia2(),p); 
		Direccione dir3 = new Direccione(su.getIddirecciones3(),su.getCodPostal3(),su.getDireccion3(),su.getLocalidad3(),su.getProvincia3(),p); 
		if ( dir1.getCodPostal() != "" ){
			set2.add(dir1);
		}
		
		if ( dir2.getCodPostal() != "" ){
			set2.add(dir2);
		}

		if ( dir3.getCodPostal() != "" ){
			set2.add(dir3);
		}		
		p.setIdpersonas(su.getIdpersonas());
		
		logger.info("intentando guardar persona");
		datos.saveOrUpdate(p);		
	}	

	@Override
	public Superusuario montarPersona(int id) {
		Persona p=datos.mostrarDetalle(id);
		int cont1=0;
		int cont2=0;
		String codPostal1="";
		String direccion1="";
		String localidad1="";
		String provincia1="";
		String codPostal2="";
		String direccion2="";
		String localidad2="";
		String provincia2="";
		String codPostal3="";
		String direccion3="";
		String localidad3="";
		String provincia3="";
		String telefono1="";
		String telefono2="";
		String telefono3="";
		int idtelefonos1=0;
		int idtelefonos2=0;
		int idtelefonos3=0;
		int iddirecciones1=0;
		int iddirecciones2=0;
		int iddirecciones3=0;
		for( Direccione direccion:p.getDirecciones() ){
			if (cont1==0){
				codPostal1=direccion.getCodPostal();
				direccion1=direccion.getDireccion();
				localidad1=direccion.getLocalidad();
				provincia1=direccion.getProvincia();
				iddirecciones1=direccion.getIddirecciones();
			}else if (cont1==1){
				codPostal2=direccion.getCodPostal();
				direccion2=direccion.getDireccion();
				localidad2=direccion.getLocalidad();
				provincia2=direccion.getProvincia();
				iddirecciones2=direccion.getIddirecciones();
			}else if (cont1==2){
				codPostal3=direccion.getCodPostal();
				direccion3=direccion.getDireccion();
				localidad3=direccion.getLocalidad();
				provincia3=direccion.getProvincia();
				iddirecciones3=direccion.getIddirecciones();
			}
			cont1++;
		}for(Telefono telefono:p.getTelefonos() ){
			if (cont2==0){
				telefono1=telefono.getTelefono();
				idtelefonos1=telefono.getIdtelefonos();
			}else if (cont2==1){
				telefono2=telefono.getTelefono();
				idtelefonos2=telefono.getIdtelefonos();
			}else if (cont2==2){
				telefono3=telefono.getTelefono();
				idtelefonos3=telefono.getIdtelefonos();
			}
			cont2++;
		}
		Superusuario sup=new Superusuario(p.getIdpersonas(),p.getEmpleado().getIdempleados(),p.getNombre(),p.getApellido1(),p.getApellido2(),p.getDni(),
				p.getFechaNacimiento().toString(),codPostal1,  localidad1, provincia1,	direccion1,iddirecciones1,codPostal2,  localidad2, provincia2,direccion2,iddirecciones2,codPostal3,  localidad3, provincia3,direccion3,iddirecciones3,idtelefonos1,telefono1,
				idtelefonos2,telefono2,idtelefonos3,telefono3,p.getEmpleado().getCodEmpleado(),p.getEmpleado().getSalario(),
				p.getEmpleado().getCategoria().getNombre(),p.getEmpleado().getDepartamento().getNombre());
		return sup;
	}
	
	public void delete(int id){
		datos.delete(id);
	}
	

}
