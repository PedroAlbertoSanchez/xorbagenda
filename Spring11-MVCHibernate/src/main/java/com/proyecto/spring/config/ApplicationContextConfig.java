package com.proyecto.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.proyecto.spring.model.Categoria;
import com.proyecto.spring.model.Departamento;
import com.proyecto.spring.model.Direccione;
import com.proyecto.spring.model.Empleado;
import com.proyecto.spring.model.Persona;
import com.proyecto.spring.model.Telefono;





@Configuration
@ComponentScan("com.proyecto.spring")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	   @Bean(name = "viewResolver")
	    public InternalResourceViewResolver getViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
	    

		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
			///registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");	    
		}
	     
	    
	    @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    	dataSource.setUrl("jdbc:mysql://localhost:3306/agenda");
	    	dataSource.setUsername("root");
	    	dataSource.setPassword("1111");
	    	
	    	return dataSource;
	    }
	    
	    
	    private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    	return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(Persona.class);   // replicar linea por cada clase adicional
	    	sessionBuilder.addAnnotatedClasses(Telefono.class);
	    	sessionBuilder.addAnnotatedClasses(Empleado.class);
	    	sessionBuilder.addAnnotatedClasses(Direccione.class);
	    	sessionBuilder.addAnnotatedClasses(Departamento.class);
	    	sessionBuilder.addAnnotatedClasses(Categoria.class);
	    	// sessionBuilder.addAnnotatedClasses(Busqueda.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);
			return transactionManager;
		}
	
}

