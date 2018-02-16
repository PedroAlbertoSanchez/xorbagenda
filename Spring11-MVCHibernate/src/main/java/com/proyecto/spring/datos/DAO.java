package com.proyecto.spring.datos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.spring.model.Persona;


@Repository
public class DAO implements IDAO{

	@Autowired
	private SessionFactory sessions;
	
	public DAO() {
		
	}
	
	public DAO(SessionFactory sessionFactory) {
		this.sessions = sessionFactory;
	}
	
	
	@Override
	@Transactional
	public List<Persona> busquedaPersona(String string) {
		System.out.println("aahahgg ");
		List<Persona> personaList = (List<Persona>) sessions.getCurrentSession()
		.createCriteria(Persona.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		//Query miQuery = sessions.getCurrentSession().createQuery("");
		//@SuppressWarnings("unchecked")
		//List<Persona> personaList = miQuery.list();
		//sessions.openSession();
		//Query miQuery = sessions.getNamedQuery("Persona.FindAll");
		return personaList;
	}

}
