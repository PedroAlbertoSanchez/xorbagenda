<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Xorbagenda</title>

  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
  <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600' rel='stylesheet' type='text/css'>


<!--  
  <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/css/animate.css">
  <link rel="stylesheet" type="text/css" href="static/css/style.css">
-->
 

<spring:url value="static/css/font-awesome.min.css" var="font"/> 
<link href="${font}" rel="stylesheet" />

<spring:url value="static/css/bootstrap.min.css" var="bootstrap"/> 
<link href="${bootstrap}" rel="stylesheet" />

<spring:url value="static/css/animate.css" var="animate"/> 
<link href="${animate}" rel="stylesheet" />

<spring:url value="static/css/style.css" var="style"/> 
<link href="${style}" rel="stylesheet" />




</head>
<body>
<!--  
	<div id="contenedor">
		<h2>Buscar Empleado</h2>
		<form:form action="busqueda" method="POST" modelAttribute="busqueda">
			<form:errors path="*" cssClass="destacado" element="div" />
			<table>
				<tr>
					<td>Nombre a Buscar:</td>

					<td><form:input path="busqueda" /></td>

					<td><form:errors path="busqueda" cssClass="destacado" /></td>
				</tr>
				<tr>
				<tr>
					<td colspan="3"><input type="submit" value="Buscar" name="" />
					</td>
				</tr>
			</table>
		</form:form>

	</div>
-->
<div class="content">
    <div class="container wow fadeInUp delay-03s">
      <div class="row">
        <div class="logo text-center">
          <img src="static/img/agenda.png" alt="logo"><h2 class="subs-title text-center">Xorbagenda</h2>
          <h2>Cuenta atrás para el fin del mundo.</h2>
          <p class="sub-p">El suicidio colectivo está cerca...</p>
        </div>

        <div id="countdown" data-wow-delay=".3s" data-date="Dec 26, 2019 06:00:00"></div>
        <h2 class="subs-title text-center">Busca tu Xorba en Xorbagenda</h2>
        <div class="subcription-info text-center">
          <form:form class="subscribe_form" action="busqueda" method="post" modelAttribute="busqueda">
            <form:input value="" placeholder=" ¿Te acuerdas de Fulana? Buscala aquí" path="busqueda" class="email" id="email" name="email"/>
            <input class="subscribe" name="email" value="¡A la yugular!" type="submit">
          </form:form>
          <p class="sub-p">También sirve para buscar otros seres humanos.</p>
        </div>
      </div>
    </div>
    
    <!--  Esta es el area de botones de redes sociales
    <section>
      <div class="container">
        <div class="row bort text-center">
          <div class="social">
            <ul>
              <li>
                <a href=""><i class="fa fa-facebook"></i></a>
              </li>
              <li>
                <a href=""><i class="fa fa-twitter"></i></a>
              </li>
              <li>
                <a href=""><i class="fa fa-linkedin"></i></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    -->
    
    
    <section id="about" class="section-padding">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-sm-12 text-center">
          
            <div class="about-title">
              <h2>Sobre nosotros</h2>
              <p>Nuestra vocación es conectar humanos con otros humanos para repoblar el mundo. </br>Es broma, estamos en esto por dinero.</p>
            </div>
            
          
             
			<!--  CATEGORIAS DESDE LA BASE DE DATOS -->
             <c:forEach items="${departamentos}" var="departamento">
             	<div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-02s">
					<h3><a href="bucarPorDepartamento?departamento=${departamento.iddepartamento}">${departamento.nombre}</a></h3>
					<p>Click para visualizar las personas de este departamento.</p>
				</div>	
			</c:forEach>					

			
			<!-- Cosas del template antiguo
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-02s">
              <div class="img">
                <i class="fa fa-refresh"></i>
              </div>
              <h3 class="abt-hd">Our process</h3>
              <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores</p>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-04s">
              <div class="img">
                <i class="fa fa-eye"></i>
              </div>
              <h3 class="abt-hd">Our Vision</h3>
              <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores</p>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-06s">
              <div class="img">
                <i class="fa fa-cogs"></i>
              </div>
              <h3 class="abt-hd">Our Approach</h3>
              <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores</p>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-08s">
              <div class="img">
                <i class="fa fa-dot-circle-o"></i>
              </div>
              <h3 class="abt-hd">Our Objective</h3>
              <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores</p>
            </div>
             -->
           
            
          </div>
        </div>
      </div>
    </section>
    
    <!-- Visualización de resultados  -->
    <section id="about" class="section-padding">		
    	<div class="container wow fadeInUp delay-03s">
    		<h3 class="subs-title text-center"><a href="alta"> DAR DE ALTA A UN USUARIO </a></h3>
    		<div class="logo text-center">
			<center><table border="0" WIDTH="700">
				<tr>
				<th><h4>Nombre</h4></th>
				<th><h4>Apellidos</h4></th>
				<th><h4>Telefono</h4></th>
				<th><h4>Acciones</h4></th>
				</tr>

				<c:forEach items="${listaPersonas}" var="Persona">
					<tr>
					<td><a href="mostrarDetalle?idPersona=${Persona.idpersonas}">${Persona.nombre}</a></td>
					<td>${Persona.apellido1} ${Persona.apellido2}</td>
					<td>${Persona.telefonos}</td>
					<td><a href="update?id=${Persona.idpersonas}">Modificar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${Persona.idpersonas}">Eliminar</a>
					</td>
					</tr>
				</c:forEach>
			</table></center>
			</div>
		</div>
	</section>
	
	
    <!--  Formulario de contacto
    <div id="contact-info">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="contact-title">
              <i class="fa fa-envelope"></i>
              <h2>Get in touch</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor <br>incididunt ut labore et dolore magna aliqua.</p>
            </div>
          </div>
          <div class="contact col-md-6 wow fadeIn delay-08s">
            <div class="col-md-10 col-md-offset-1">
              <div id="note"></div>
              <div id="sendmessage">Your message has been sent. Thank you!</div>
              <div id="errormessage"></div>
              <form action="" method="post" role="form" class="contactForm">
                <div class="form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
                  <div class="validation"></div>
                </div>

                <div class="text-center"><button type="submit" class="contact-submit">Send Message</button></div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    -->
    
  </div>
  <footer class="footer">
    <div class="container">
      <div class="row bort">

        <div class="copyright">
          © Copyright Grupo1 - Xorbagenda Company.
          <div class="credits">
            <!--
              All the links in the footer should remain intact. 
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Maundy
            -->
            Bootstrap theme designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>

      </div>
    </div>
  </footer>
  
  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/bootstrap.min.js"></script>
  <script src="static/js/jquery.countdown.min.js"></script>
  <script src="static/js/wow.js"></script>
  <script src="static/js/custom.js"></script>
  <script src="static/contactform/contactform.js"></script>


<!-- Visualización de resultados primario  -->

<!--  -
		<h4><a href="alta">DAR DE ALTA A UN USUARIO</a></h4>
		<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
-->			
			 <!-- Brand and toggle get grouped for better mobile display --> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
			   <!--  CATEGORIAS DESDE LA BASE DE DATOS -->
			   
<!--  
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<c:forEach items="${departamentos}" var="departamento">
							<li><a href="bucarPorDepartamento?departamento=${departamento.iddepartamento}"><b>${departamento.nombre}</b></a></li>
						</c:forEach>
					
					</ul>
				 </div>
-->
				 <!-- /.navbar-collapse -->
<!-- 			
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
			<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Apellido 1</th>
				<th>Apellido 2</th>
				<th>Telefono</th>
				<th>Acciones</th>
			</tr>

			<c:forEach items="${listaPersonas}" var="Persona">
				<tr>
					<td><a href="mostrarDetalle?idPersona=${Persona.idpersonas}">${Persona.nombre}</td>
					<td>${Persona.apellido1}</td>
					<td>${Persona.apellido2}</td>
					<td>${Persona.telefonos}</td>
					<td><a href="update?id=${Persona.idpersonas}">Modificar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${Persona.idpersonas}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
-->
</body>
</html>