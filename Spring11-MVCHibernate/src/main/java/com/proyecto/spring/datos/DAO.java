package com.proyecto.spring.datos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.proyecto.spring.model.Persona;


/**
 * 
 * @author Grupo 1 : Emmanuel, P.Alberto, Alberto y Daniel
 * version 000000001
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
 * 
 * @param sessionFactory
 */
	public DAO(SessionFactory sessionFactory) {
		this.sessions = sessionFactory;
	}

	@Override
	@Transactional
	public List<Persona> busquedaPersona(String string) {

		
		 Session session = sessions.openSession();
		
		
		 // HQL
		 Query query = session.createQuery("from Persona p where nombre LIKE :busqueda OR apellido1 LIKE :busqueda OR apellido2 LIKE :busqueda");
	        query.setString("busqueda", string);
	        //devuelve el objeto. Si no hay devuelve null
	        @SuppressWarnings("unchecked")
			List<Persona> personaList =  (List<Persona>) query.list();
	       
		 /* CRITERIA
		Criteria criteria = session.createCriteria(Persona.class)
                .add(Restrictions.like("nombre", string));
		@SuppressWarnings("unchecked")
		List<Persona> personaList = (List<Persona>) query.list();
		logger.info("Metodo DAO busquedaPersona");
		/*
		 * CRITERIA Criteria criteria = session.createCriteria(Persona.class)
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

		return personaList;
	}

	public Persona mostrarDetalle(int idpersonas) {
		String hql = "from Persona where idpersonas = :busqueda" ; 
	
		Query query = sessions.getCurrentSession().createQuery(hql); 	
		query.setInteger("busqueda", idpersonas); 
		Persona persona  = (Persona) query.uniqueResult(); 
		
		return persona; 
		
		
	}
	
	
	public Set<Persona> listadoPersona(){
		Session session = sessions.openSession();
		Criteria criteria = session.createCriteria(Persona.class);
		@SuppressWarnings("unchecked")
		List<Persona> personaList =  criteria.list();
		Set<Persona> personaSet=new HashSet<>();
		for (Persona persona:personaList){
			personaSet.add(persona);
		}
		return personaSet;
	}


}
