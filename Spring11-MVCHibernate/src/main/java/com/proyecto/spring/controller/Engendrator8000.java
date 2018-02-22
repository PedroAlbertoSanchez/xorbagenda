package com.proyecto.spring.controller;





import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.spring.model.Busqueda;
import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Superusuario;
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
		Set<Departamento> listaDepartamentos=userService.listadoDepartamento();
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
		Set<Departamento> listaDepartamentos=userService.listadoDepartamento();
		ModelAndView model = new ModelAndView("Index");
		model.addObject("listaPersonas", listaPersonas);
		model.addObject("departamentos", listaDepartamentos);
		if (listaPersonas.isEmpty()){
		model.addObject("noResultadoBusqueda", "true");
		}
		return model;
	}
	
	/**
	 * 
	 * @param request: Muestra los detalles de una persona al hacer click en su nombre
	 * 
	 * @return model: devuelve una persona 
	 */
	
	@RequestMapping(value = "/mostrarDetalle", method = RequestMethod.GET)
	public ModelAndView mostrarDetalle(HttpServletRequest request, Busqueda busqueda ) {
		Persona persona=userService.mostrarDetalle(request.getParameter("idPersona"));
		Set<Departamento> listaDepartamentos=userService.listadoDepartamento();
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
		Set<Departamento> listaDepartamentos=userService.listadoDepartamento();
		ModelAndView model = new ModelAndView("Index");
		model.addObject("listaPersonas", listaPersonas);
		model.addObject("busqueda", busqueda);
		model.addObject("departamentos", listaDepartamentos);
		return model;
	}
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
	public ModelAndView Alta() {
		Superusuario superusu=new Superusuario();
		Set<Departamento> listaDep=userService.listadoDepartamento();
		Set<Categoria> listaCat=userService.listadoCategoria();
		ModelAndView model = new ModelAndView("Alta");
		List<String> listaCategoria=new ArrayList<>();
		List<String> listaDepartamentos=new ArrayList<>();
		for (Departamento dep:listaDep){
			listaDepartamentos.add(dep.getNombre());
		}
		for (Categoria dep:listaCat){
			listaCategoria.add(dep.getNombre());
		}
		model.addObject("categorias", listaCategoria);
		model.addObject("departamentos", listaDepartamentos);
		model.addObject("usuario", superusu);
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Superusuario usuario,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			Set<Departamento> listaDep=userService.listadoDepartamento();
			Set<Categoria> listaCat=userService.listadoCategoria();
			List<String> listaCategoria=new ArrayList<>();
			List<String> listaDepartamentos=new ArrayList<>();
			for (Departamento dep:listaDep){
				listaDepartamentos.add(dep.getNombre());
			}
			for (Categoria dep:listaCat){
				listaCategoria.add(dep.getNombre());
			}
			model.addAttribute("categorias", listaCategoria);
			model.addAttribute("departamentos", listaDepartamentos);
			System.out.println("--- Hay algunos errores");
			return "Alta";
		}
		logger.info("entro en save y intento inserta este superusuario"+ usuario);
		userService.saveOrUpdate(usuario); 
		return "redirect:/"; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView Update(Superusuario superusu,HttpServletRequest request) {
		Set<Departamento> listaDep=userService.listadoDepartamento();
		Set<Categoria> listaCat=userService.listadoCategoria();
		superusu=userService.montarPersona(Integer.parseInt(request.getParameter("id")));
		logger.info("este es superusuario(update)"+superusu);
		ModelAndView model = new ModelAndView("Alta");
		List<String> listaCategoria=new ArrayList<>();
		List<String> listaDepartamentos=new ArrayList<>();
		for (Departamento dep:listaDep){
			listaDepartamentos.add(dep.getNombre());
		}
		for (Categoria dep:listaCat){
			listaCategoria.add(dep.getNombre());
		}
		model.addObject("categorias", listaCategoria);
		model.addObject("departamentos", listaDepartamentos);
		model.addObject("usuario", superusu);
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView Delete(HttpServletRequest request){
		
		int id = Integer.parseInt(request.getParameter("id"));
		userService.delete(id);
		logger.info("ID:" + id);
		return new ModelAndView("redirect:/");
	}
	
	/*
	@RequestMapping("/**")
	public ModelAndView error404 () throws Exception {
		ModelAndView model = new ModelAndView("Error404");
		return model;	
	}
*/
	
}
