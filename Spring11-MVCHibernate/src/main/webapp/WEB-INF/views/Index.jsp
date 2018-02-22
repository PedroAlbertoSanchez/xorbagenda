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

<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<link
	href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600'
	rel='stylesheet' type='text/css'>


<!--  
  <link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/css/animate.css">
  <link rel="stylesheet" type="text/css" href="static/css/style.css">
-->


<spring:url value="static/css/font-awesome.min.css" var="font" />
<link href="${font}" rel="stylesheet" />

<spring:url value="static/css/bootstrap.min.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />

<spring:url value="static/css/animate.css" var="animate" />
<link href="${animate}" rel="stylesheet" />

<spring:url value="static/css/style.css" var="style" />
<link href="${style}" rel="stylesheet" />




</head>
<body>

	<div class="content">
		<div class="container wow fadeInUp delay-03s">
			<div class="row">
				<div class="logo text-center">
					<img src="static/img/agenda.png" alt="logo">
					<h2 class="subs-title text-center">Xorbagenda</h2>
					<h2>Cuenta atrás para el fin del mundo.</h2>
					<p class="sub-p">El suicidio colectivo está cerca...</p>
				</div>

				<div id="countdown" data-wow-delay=".3s"
					data-date="Dec 26, 2019 06:00:00"></div>
				<h2 class="subs-title text-center">Busca tu Xorba en Xorbagenda</h2>
				<div class="subcription-info text-center">
					<form:form class="subscribe_form" action="busqueda" method="post"
						modelAttribute="busqueda">
						<form:input value=""
							placeholder=" ¿Te acuerdas de Fulana? Buscala aquí"
							path="busqueda" class="email" id="email" name="email" />
						<input class="subscribe" name="email" value="¡A la yugular!"
							type="submit">
					</form:form>
					<p class="sub-p">También sirve para buscar otros seres humanos.</p>
          		<c:if test="${noResultadoBusqueda}">
			<div class="alert alert-warning"> NO SE HA ENCONTRADO BUSQUEDA!!! </div>
		</c:if>
          
          
				</div>
			</div>
		</div>


	<!-- Visualización de resultados  -->
		<section id="about" class="section-padding">
		<div class="container wow fadeInUp delay-03s">
			<h3 class="subs-title text-center">
			<a class="buttonAlta"href="alta" class="button">ALTA DE USUARIO</a>
				
			</h3>
			<div class="logo text-center">
				<center>
					<table class="noelia" border="0" WIDTH="700">
						<tr>
							<th><h4>Nombre</h4></th>
							<th><h4>Apellidos</h4></th>
							<th><h4>Telefono</h4></th>
							<th><h4>Acciones</h4></th>
						</tr>

						<c:forEach items="${listaPersonas}" var="Persona">
							<tr>
								<td><a
									href="mostrarDetalle?idPersona=${Persona.idpersonas}">${Persona.nombre}</a></td>
								<td>${Persona.apellido1}${Persona.apellido2}</td>
								<td>${Persona.telefonos}</td>
								<td><a href="update?id=${Persona.idpersonas}">Modificar</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${Persona.idpersonas}">Eliminar</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</center>
			</div>
		</div>
		</section>
<!-- cierra Visualización de resultados  -->












   


		<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 text-center">

					<div class="about-title">
						<h2>Sobre nosotros</h2>
						<p>
							Nuestra vocación es conectar humanos con otros humanos para
							repoblar el mundo. </br>Es broma, estamos en esto por dinero.
						</p>
					</div>



					<!--  CATEGORIAS DESDE LA BASE DE DATOS -->
					<c:forEach items="${departamentos}" var="departamento">
						<div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp delay-02s">
							<h3>
								<a
									href="bucarPorDepartamento?departamento=${departamento.iddepartamento}">${departamento.nombre}</a>
							</h3>
							<p>Click para visualizar las personas de este departamento.</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		</section>

	

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


</body>
</html>
