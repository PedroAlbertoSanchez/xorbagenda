package com.proyecto.spring.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQueries({
	@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
	@NamedQuery(name="Persona.findbyNombre", query="SELECT p FROM Persona p WHERE p.nombre = :Nombre OR p.apellido1= :Nombre OR p.apellido2= :Nombre")
	
})
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpersonas;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to Direccione
	@OneToMany(mappedBy="persona", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Direccione> direcciones;

	//bi-directional many-to-one association to Empleado
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Telefono
	
	@OneToMany(mappedBy="persona", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Telefono> telefonos;

	public Persona() {
	}

	public Persona(String apellido1, String apellido2, String dni, Date fechaNacimiento, String nombre,
			Set<Direccione> direcciones, Empleado empleado, Set<Telefono> telefonos) {
		super();
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.direcciones = direcciones;
		this.empleado = empleado;
		this.telefonos = telefonos;
	}

	public int getIdpersonas() {
		return this.idpersonas;
	}

	public void setIdpersonas(int idpersonas) {
		this.idpersonas = idpersonas;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Direccione> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(Set<Direccione> direcciones) {
		this.direcciones = direcciones;
	}

	public Direccione addDireccione(Direccione direccione) {
		getDirecciones().add(direccione);
		direccione.setPersona(this);

		return direccione;
	}

	public Direccione removeDireccione(Direccione direccione) {
		getDirecciones().remove(direccione);
		direccione.setPersona(null);

		return direccione;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setPersona(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setPersona(null);

		return telefono;
	}

}