package com.proyecto.spring.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Superusuario implements Serializable{
	
	private int idpersonas;
	
	private int idempleados;
	
	@Size(min=3, max=30)
	@NotNull
	private String nombre;

	@Size(min=3, max=30) 
	@NotNull
	private String apellido1;
	@Size(min=3, max=30)
	private String apellido2;
	@Size(min=7, max=10)
	@NotNull
	private String dni;
	
	@DateTimeFormat(pattern="yyyy/dd/MM") 
	@Past @NotNull
	private String fechaNacimiento;
	
	private int iddirecciones1;
	@Size(min=5, max=5)
	private String codPostal1;
	@Size(min=3, max=15)
	private String localidad1;
	@Size(min=3, max=15)
	private String provincia1;
	@Size(min=5, max=100)
	private String direccion1;
	
	private int iddirecciones2;
	@Size(min=5, max=5)
	private String codPostal2;
	@Size(min=3, max=15)
	private String localidad2;
	@Size(min=3, max=15)
	private String provincia2;
	@Size(min=5, max=100)
	private String direccion2;
	
	private int iddirecciones3;
	@Size(min=5, max=5)
	private String codPostal3;
	@Size(min=3, max=15)
	private String localidad3;
	@Size(min=3, max=15)
	private String provincia3;
	@Size(min=5, max=100)
	private String direccion3;
	
	private int idtelefonos1;
	@Size(min=9, max=15)
	private String telefono1;
	
	private int idtelefonos2;
	@Size(min=9, max=15)
	private String telefono2;
	
	private int idtelefonos3;
	@Size(min=9, max=15)
	private String telefono3;
	@Size(min=3, max=5)
	private String codEmpleado;
	@Size(min=3, max=10)
	private String salario;
	
	@NotEmpty
	private String categoria;
	
	@NotEmpty
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
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
	
	public int getIddirecciones1() {
		return iddirecciones1;
	}

	public void setIddirecciones1(int iddirecciones1) {
		this.iddirecciones1 = iddirecciones1;
	}

	public int getIddirecciones2() {
		return iddirecciones2;
	}

	public void setIddirecciones2(int iddirecciones2) {
		this.iddirecciones2 = iddirecciones2;
	}

	public int getIddirecciones3() {
		return iddirecciones3;
	}

	public void setIddirecciones3(int iddirecciones3) {
		this.iddirecciones3 = iddirecciones3;
	}

	public int getIdtelefonos1() {
		return idtelefonos1;
	}

	public void setIdtelefonos1(int idtelefonos1) {
		this.idtelefonos1 = idtelefonos1;
	}

	public int getIdtelefonos2() {
		return idtelefonos2;
	}

	public void setIdtelefonos2(int idtelefonos2) {
		this.idtelefonos2 = idtelefonos2;
	}

	public int getIdtelefonos3() {
		return idtelefonos3;
	}

	public void setIdtelefonos3(int idtelefonos3) {
		this.idtelefonos3 = idtelefonos3;
	}

	public String getCodPostal1() {
		return codPostal1;
	}

	public void setCodPostal1(String codPostal1) {
		this.codPostal1 = codPostal1;
	}

	public String getLocalidad1() {
		return localidad1;
	}

	public void setLocalidad1(String localidad1) {
		this.localidad1 = localidad1;
	}

	public String getProvincia1() {
		return provincia1;
	}

	public void setProvincia1(String provincia1) {
		this.provincia1 = provincia1;
	}

	public String getCodPostal2() {
		return codPostal2;
	}

	public void setCodPostal2(String codPostal2) {
		this.codPostal2 = codPostal2;
	}

	public String getLocalidad2() {
		return localidad2;
	}

	public void setLocalidad2(String localidad2) {
		this.localidad2 = localidad2;
	}

	public String getProvincia2() {
		return provincia2;
	}

	public void setProvincia2(String provincia2) {
		this.provincia2 = provincia2;
	}

	public String getCodPostal3() {
		return codPostal3;
	}

	public void setCodPostal3(String codPostal3) {
		this.codPostal3 = codPostal3;
	}

	public String getLocalidad3() {
		return localidad3;
	}

	public void setLocalidad3(String localidad3) {
		this.localidad3 = localidad3;
	}

	public String getProvincia3() {
		return provincia3;
	}

	public void setProvincia3(String provincia3) {
		this.provincia3 = provincia3;
	}

	public int getIdempleados() {
		return idempleados;
	}

	public void setIdempleados(int idempleados) {
		this.idempleados = idempleados;
	}

	public Superusuario(){
		this.idpersonas = 0;
		this.idempleados = 0;
		this.idtelefonos1=0;
		this.idtelefonos2=0;
		this.idtelefonos3=0;
		this.iddirecciones1=0;
		this.iddirecciones2=0;
		this.iddirecciones3=0;
		
	}
	public Superusuario(int idpersonas,int idempleados, String nombre, String apellido1, String apellido2, String dni,
			String fechaNacimiento,String codPostal1, String localidad1,String provincia1, String direccion1,int iddirecciones1,String codPostal2, String localidad2,String provincia2,
			String direccion2,int iddirecciones2,String codPostal3, String localidad3,String provincia3, String direccion3,int iddirecciones3,int idtelefonos1,String telefono1,int idtelefonos2, String telefono2,int idtelefonos3,
			String telefono3, String codEmpleado, String salario, String categoria,
			String departamento) {
		this.idpersonas = idpersonas;
		this.idempleados = idempleados;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.iddirecciones1=iddirecciones1;
		this.iddirecciones2=iddirecciones2;
		this.iddirecciones3=iddirecciones3;
		this.codPostal1=codPostal1;
		this.localidad1=localidad1;
		this.provincia1=provincia1;
		this.direccion1 = direccion1;
		this.codPostal2=codPostal2;
		this.localidad2=localidad2;
		this.provincia2=provincia2;
		this.direccion2 = direccion2;
		this.codPostal3=codPostal3;
		this.localidad3=localidad3;
		this.provincia3=provincia3;
		this.direccion3 = direccion3;
		this.idtelefonos1=idtelefonos1;
		this.telefono1 = telefono1;
		this.idtelefonos2=idtelefonos2;
		this.telefono2 = telefono2;
		this.idtelefonos3=idtelefonos3;
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
