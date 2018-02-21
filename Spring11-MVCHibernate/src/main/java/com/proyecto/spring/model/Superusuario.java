package com.proyecto.spring.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class Superusuario {
	
	private String nombre;

	private String apellido1;

	private String apellido2;

	private String dni;

	private Date fechaNacimiento;
	
	private String direccion1;
	
	private String direccion2;
	
	private String direccion3;
	
	private int telefono1;
	
	private int telefono2;
	
	private int telefono3;
	
	private String codEmpleado;

	private Timestamp fechaAlta;

	private String salario;
	
	private Categoria categoria;
	
	private Departamento departamento;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	
	public String getDireccion3() {
		return direccion3;
	}

	public void setDireccion3(String direccion3) {
		this.direccion3 = direccion3;
	}

	public int getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(int telefono3) {
		this.telefono3 = telefono3;
	}

	public int getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(int telefono1) {
		this.telefono1 = telefono1;
	}

	public int getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public Timestamp getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
