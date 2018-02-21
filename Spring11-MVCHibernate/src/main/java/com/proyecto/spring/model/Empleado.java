package com.proyecto.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idempleados;

	private String codEmpleado;

	private Timestamp fechaAlta;

	private String salario;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="idCategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="idDepartamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Persona
	@OneToOne (mappedBy="empleado",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Persona persona;

	public Empleado() {
	}
	
	
	
	public Empleado(String codEmpleado, Timestamp fechaAlta, String salario, Categoria categoria,
			Departamento departamento) {
		super();
		this.codEmpleado = codEmpleado;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.categoria = categoria;
		this.departamento = departamento;
	}



	public int getIdempleados() {
		return this.idempleados;
	}

	public void setIdempleados(int idempleados) {
		this.idempleados = idempleados;
	}

	public String getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public Timestamp getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}