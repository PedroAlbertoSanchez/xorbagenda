package com.proyecto.spring.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.proyecto.spring.controller.Engendrator8000;
import com.proyecto.spring.model.Persona;

public class AltaPersonaTest {
	
	private Persona persona = new Persona();
	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(AltaPersonaTest.class);
		} catch (Throwable e) {
			  System.out.println("Logger no funciona");

		}
	}
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info("@BeforeClass: Iniciando sesión de pruebas");
	}
	
	@Before
	public void executedBeforeEach(){
		logger.info("Testeando metodo...");
	}
	
	@AfterClass
	public static void onceExecutedAfterAll(){
		logger.info("Testing finalizado.");
	}
	
	@After
	public void executedAfterEach(){
		logger.info("Test finalizado comenzando con la siguiente prueba...");
	}
	
	/** 
	 * @see sizeNombreCorrect
	 * @return String
	 * Comprueba que el campo nombre sea de 45 caracteres o menos.
	 * */
	
	@Test
	public void sizeNombreCorrect()
	{
		logger.info("Test sizeNombreCorrect(): Comprobando que el tamaño del campo nombre no supere el tamaño maximo permitido.");
		persona.setNombre("Este es un nombre falso que supera los cuarenta y cinco caracteres");
		assertTrue(persona.getNombre().length()<=45);
	}
	
	
	/** 
	 * @see sizeDniCorrect
	 * @return String
	 * Comprueba que el campo nombre sea de 20 caracteres o menos.
	 * */
	
	@Test
	public void sizeDniCorrect()
	{
		logger.info("Test sizeDniCorrect(): Comprobando que el tamaño del campo DNI no supere el tamaño maximo permitido.");
		persona.setDni("Este es un DNI de mentira, mas largo de lo normal");
		assertTrue(persona.getDni().length()<=20);
	}

}
