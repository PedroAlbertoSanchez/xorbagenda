package com.proyecto.spring.controller;





import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.spring.model.Busqueda;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.services.UserService;

/** 
 * @author Grupo 1: Emmanunel, P.Alberto, Alberto, y Daniel
 * @Version 00000001
 * 
 */
@Controller
public class Engendrator8000 {

	@Autowired
	private UserService userService;

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(Engendrator8000.class);
		} catch (Throwable e) {
			  System.out.println("Logger no funciona");

		}
	}
	/**
	 * 
	 * @param busqueda:Busca en el listado de personas, los guarda en el objeto model y lo envia a la página Index, mostrandolos en un listado
	 * @return model 
	 * @throws Exception
	 */
	@RequestMapping("/")
	public ModelAndView handleRequest(Busqueda busqueda) throws Exception {
		ModelAndView model = new ModelAndView("Index");
		Set<Persona> listaPersonas = userService.listadoPersona();
		List<String> listaDepartamentos=userService.listadoDepartamento();
		model.addObject("busqueda", busqueda);
		model.addObject("listaPersonas", listaPersonas);
		model.addObject("departamentos", listaDepartamentos);
		logger.info("Finaliza Metodo: RequestMapping </>");
		return model;	
	}
	
	
	
	/**
	 * 
	 * @param busqueda: Busca una persona mediante el formulario de busqueda guardandolo en un objeto model y mostrando el detalle.  
	 * 
	 * @return model:  devuelve una persona 
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.POST)
	public ModelAndView busqueda(@ModelAttribute Busqueda busqueda) {
		List<Persona> listaPersonas = userService.busquedaPersona(busqueda.getBusqueda());
		logger.info("Entrando en el metodo y buscando a: " + busqueda.getBusqueda());
		List<String> listaDepartamentos=userService.listadoDepartamento();
		ModelAndView model = new ModelAndView("Index");
		model.addObject("listaPersonas", listaPersonas);
		model.addObject("departamentos", listaDepartamentos);
		return model;
	}
	
	/**
	 * 
	 * @param request: Muestra los detalles de una persona al hacer click en su nombre
	 * 
	 * @return model: devuelve una persona 
	 */
	
	@RequestMapping(value = "/mostrarDetalle", method = RequestMethod.GET)
	public ModelAndView mostarDetalle(HttpServletRequest request, Busqueda busqueda ) {
		Persona persona=userService.mostrarDetalle(request.getParameter("idPersona"));
		List<String> listaDepartamentos=userService.listadoDepartamento();
		ModelAndView model = new ModelAndView("Detalle");
		model.addObject("Persona", persona);
		model.addObject("busqueda", busqueda);
		model.addObject("departamentos", listaDepartamentos);
		return model;
	}
	@RequestMapping(value = "/bucarPorDepartamento", method = RequestMethod.GET)
	public ModelAndView buscarPorDepartamento(HttpServletRequest request, Busqueda busqueda) {
		Set<Persona> listaPersonas = userService.busquedaPorDepartamento(request.getParameter("departamento"));
		logger.info("Entrando en el metodo y buscando a: " + request.getParameter("departamento"));
		List<String> listaDepartamentos=userService.listadoDepartamento();
		ModelAndView model = new ModelAndView("Index");
		model.addObject("listaPersonas", listaPersonas);
		model.addObject("busqueda", busqueda);
		model.addObject("departamentos", listaDepartamentos);
		return model;
	}

}
