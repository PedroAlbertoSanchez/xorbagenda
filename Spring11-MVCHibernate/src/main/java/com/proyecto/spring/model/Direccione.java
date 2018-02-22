package com.proyecto.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direcciones database table.
 * 
 */
@Entity
@Table(name="direcciones")
@NamedQuery(name="Direccione.findAll", query="SELECT d FROM Direccione d")
public class Direccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iddirecciones;

	private String codPostal;

	private String direccion;

	private String localidad;

	private String provincia;

	//bi-directional many-to-one association to Persona
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idPersona")
	private Persona persona;

	public Direccione() {
	}

	public Direccione(String direccion1) {
		this.direccion = direccion1; 
		// TODO Auto-generated constructor stub
	}

	public Direccione(int iddirecciones,String codPostal, String direccion, String localidad, String provincia, Persona persona) {
		this.iddirecciones=iddirecciones;
		this.codPostal = codPostal;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.persona=persona;
	}

	public int getIddirecciones() {
		return this.iddirecciones;
	}

	public void setIddirecciones(int iddirecciones) {
		this.iddirecciones = iddirecciones;
	}

	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return " DIRECCION(codPostal: " + codPostal + ", direccion:" + direccion
				+ ", localidad: " + localidad+"(" + provincia+"))";
	}
	

}