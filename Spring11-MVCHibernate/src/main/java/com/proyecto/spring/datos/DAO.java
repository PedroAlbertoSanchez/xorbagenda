package com.proyecto.spring.datos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransientObjectException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Empleado;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Telefono;


/**
 * 
 * @author Grupo 1 : Emmanuel, P.Alberto, Alberto y Daniel version 21/02/2018
 * 
 */
@Repository
public class DAO implements IDAO {

	@Autowired
	private SessionFactory sessions;

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(DAO.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona");

		}
	}

	public DAO() {

	}

	/**
	 * Constructor
	 * 
	 * @param sessionFactory:
	 *            implementamos una factoría de de sesiones para crear objetos
	 *            Session que proporciona métodos para recuperar y guardar la
	 *            información de los objetos en la Base de Datos.
	 * 
	 */
	public DAO(SessionFactory sessionFactory) {
		this.sessions = sessionFactory;
	}

	/**
	 * ArrayList
	 * 
	 * @return devuelve una lista de personas
	 * @param String de Persona
	 * @see com.proyecto.spring.datos.IDAO#busquedaPersona(java.lang.String)
	 */
	@Override
	@Transactional
	public List<Persona> busquedaPersona(String string) {

		Session session = sessions.openSession();

		// HQL
		Query query = session.createQuery(
				"from Persona p where nombre LIKE :busqueda OR apellido1 LIKE :busqueda OR apellido2 LIKE :busqueda");
		query.setString("busqueda", string);
		// devuelve el objeto. Si no hay devuelve null
		@SuppressWarnings("unchecked")
		List<Persona> personaList = (List<Persona>) query.list();

		/*
		 * CRITERIA Criteria criteria = session.createCriteria(Persona.class)
		 * .add(Restrictions.like("nombre", string));
		 * 
		 * @SuppressWarnings("unchecked") List<Persona> personaList =
		 * (List<Persona>) query.list();
		 * logger.info("Metodo DAO busquedaPersona"); /* CRITERIA Criteria
		 * criteria = session.createCriteria(Persona.class)
		 * .add(Restrictions.like("nombre", string));
		 * 
		 * @SuppressWarnings("unchecked") List<Persona> personaList =
		 * criteria.list();
		 * 
		 * Criteria criteria2 = session.createCriteria(Persona.class);
		 * criteria2.add(Restrictions.like("apellido1", string)); List<Persona>
		 * personaList2 = criteria2.list();
		 * 
		 * Criteria criteria3 = session.createCriteria(Persona.class)
		 * .add(Restrictions.like("apellido2", string)); List<Persona>
		 * personaList3 = criteria3.list(); personaList.addAll(personaList2);
		 * personaList.addAll(personaList3);
		 */

		/*
		 * NAMED queries Session session = sessions.openSession(); Query query =
		 * session.getNamedQuery("Persona.findbyNombre");
		 * query.setString("Nombre",string); List<Persona> personaList =
		 * query.list(); //(List<Persona>)
		 */
		session.close();
		return personaList;
	}

	/**
	 * Al hacer click sobre el campo nombre da una información detallada
	 * 
	 * @param int idpersonas
	 * @see com.proyecto.spring.datos.IDAO#mostrarDetalle(int)
	 * @return devuelve una persona
	 */
	public Persona mostrarDetalle(int idpersonas) {
		String hql = "from Persona where idpersonas = :busqueda";

		Query query = sessions.getCurrentSession().createQuery(hql);
		query.setInteger("busqueda", idpersonas);
		Persona persona = (Persona) query.uniqueResult();

		return persona;

	}

	/**
	 * @see com.proyecto.spring.datos.IDAO#listadoPersona()
	 * @return devuelve una lista de personas con valores no repetidos
	 */
	public Set<Persona> listadoPersona() {
		Session session = sessions.openSession();
		Criteria criteria = session.createCriteria(Persona.class);
		@SuppressWarnings("unchecked")
		List<Persona> personaList = criteria.list();
		Set<Persona> personaSet = new HashSet<>();
		for (Persona persona : personaList) {
			personaSet.add(persona);
		}

		session.close();
		return personaSet;
	}
	
	
	/**
	 * 
	 * @see com.proyecto.spring.datos.IDAO#listadoDepartamento()
	 * @return listado de departamentos 
	 */
	public Set<Departamento> listadoDepartamento() {
		Session session = sessions.openSession();
		Criteria criteria = session.createCriteria(Departamento.class);
		@SuppressWarnings("unchecked")
		List<Departamento> listadoDepartamentos = criteria.list();
		Set<Departamento> personaSet = new HashSet<>();
		for (Departamento persona : listadoDepartamentos) {
			personaSet.add(persona);
		}
		session.close();
		

		return personaSet;
	}

	/**
	 * busqueda de personas por departamento 
	 * @param int 
	 * @return devuelve una lista de personas con valores no repetidos
	 *@see com.proyecto.spring.datos.IDAO#busquedaPorDepartamento(int)
	 */
	@Override
	public Set<Persona> busquedaPorDepartamento(int i) {
		Session session = sessions.openSession();
		// HQL
		Query query = session.createQuery(
				"Select p from Persona p,Departamento dep, Empleado em where p.empleado=em.idempleados AND em.departamento= :busqueda");
		query.setInteger("busqueda", i);
		// devuelve el objeto. Si no hay devuelve null
		@SuppressWarnings("unchecked")
		List<Persona> personaList = (List<Persona>) query.list();
		Set<Persona> personaSet = new HashSet<>();
		for (Persona persona : personaList) {
			personaSet.add(persona);
		}
		session.close();
		return personaSet;
	}

	@Override
	public Set<Categoria> listadoCategoria() {
		Session session = sessions.openSession();
		Criteria criteria = session.createCriteria(Categoria.class);
		@SuppressWarnings("unchecked")
		List<Categoria> listadoCategoria =  criteria.list();
		session.close();
		Set<Categoria> personaSet = new HashSet<>();
		for (Categoria persona : listadoCategoria) {
			personaSet.add(persona);
		}
		return personaSet;
	}
	
	
	
	
	
	@Override
	@Transactional
	public void saveOrUpdate(Persona persona) {
		sessions.getCurrentSession().saveOrUpdate(persona);

	}

	@Override
	public Departamento buscarDepartamento(String nombre) {
		Session session = sessions.openSession();

		// HQL
		Query query = session.createQuery(
				"from Departamento dep where dep.nombre LIKE :busqueda ");
		query.setString("busqueda", nombre);
		// devuelve el objeto. Si no hay devuelve null
		@SuppressWarnings("unchecked")
		Departamento dep = (Departamento) query.uniqueResult();
		session.close();
		return dep;
	}

	@Override
	public Categoria buscarCategoria(String nombre) {
		Session session = sessions.openSession();

		// HQL
		Query query = session.createQuery(
				"from Categoria cat where cat.nombre LIKE :busqueda ");
		query.setString("busqueda", nombre);
		// devuelve el objeto. Si no hay devuelve null
		@SuppressWarnings("unchecked")
		Categoria dep = (Categoria) query.uniqueResult();
		session.close();
		return dep;
	}
	
	@Override
	@Transactional
	public void save(Persona p){
		sessions.getCurrentSession().save(p);
	}


	@Override
	@Transactional
	public void delete(int id){
		Persona persona = new Persona();
		persona.setIdpersonas(id);
		//sessions.getCurrentSession().delete(persona);
		logger.info("Entra metodo DAO borrar.");
		
	}

	/*@Override
	@Transactional
	public int getID(String nombre) {
		Session session = sessions.openSession();
		// HQL
		Query query = session.createQuery(
				"from Persona per where per.nombre LIKE :busqueda ");
		query.setString("busqueda", nombre);
		// devuelve el objeto. Si no hay devuelve null
		@SuppressWarnings("unchecked")
		Persona per = (Persona) query.uniqueResult();
		logger.info(per);
		session.close();
		
		return ;
		}*/
	
	
	



}
