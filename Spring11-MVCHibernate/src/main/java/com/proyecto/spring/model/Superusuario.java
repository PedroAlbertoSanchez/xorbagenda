package com.proyecto.spring.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

public class Superusuario {
	
	private int idpersonas;
	
	private String nombre;

	private String apellido1;

	private String apellido2;

	private String dni;

	private Date fechaNacimiento;
	
	private String direccion1;
	
	private String direccion2;
	
	private String direccion3;
	
	private String telefono1;
	
	private String telefono2;
	
	private String telefono3;
	
	private String codEmpleado;

	private String salario;
	
	private String categoria;
	
	private String departamento;


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

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getIdpersonas() {
		return idpersonas;
	}

	public void setIdpersonas(int idpersonas) {
		this.idpersonas = idpersonas;
	}

	public Superusuario(){}
	public Superusuario(int idpersonas, String nombre, String apellido1, String apellido2, String dni,
			Date fechaNacimiento, String direccion1, String direccion2, String direccion3, String telefono1, String telefono2,
			String telefono3, String codEmpleado, String salario, String categoria,
			String departamento) {
		this.idpersonas = idpersonas;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.direccion3 = direccion3;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.telefono3 = telefono3;
		this.codEmpleado = codEmpleado;
		this.salario = salario;
		this.categoria = categoria;
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Superusuario [idpersonas=" + idpersonas + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion1="
				+ direccion1 + ", direccion2=" + direccion2 + ", direccion3=" + direccion3 + ", telefono1=" + telefono1
				+ ", telefono2=" + telefono2 + ", telefono3=" + telefono3 + ", codEmpleado=" + codEmpleado
				+ ", salario=" + salario + ", categoria=" + categoria + ", departamento=" + departamento + "]";
	}
	
	
	
}
