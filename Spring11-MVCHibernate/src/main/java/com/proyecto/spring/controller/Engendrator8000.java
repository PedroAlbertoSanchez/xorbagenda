package com.proyecto.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.spring.model.Busqueda;
import com.proyecto.spring.services.UserService;

@Controller
public class Engendrator8000 {
	

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView handleRequest(Busqueda busqueda) throws Exception {
		ModelAndView model = new ModelAndView("Index");
		model.addObject("busqueda", busqueda);
		return model;
	}

	@RequestMapping(value = "/busqueda", method = RequestMethod.POST)
	public ModelAndView busqueda(@ModelAttribute Busqueda busqueda) {
		// List<Object> listaUsuarios =
		// userService.busquedaUsuario(busqueda.getBusqueda());
		System.out.println("Entrando en el metodo");
		ModelAndView model = new ModelAndView("Resultados");
		//model.addObject("listaUsuarios", listaUsuarios);
		return model;
	}

}
