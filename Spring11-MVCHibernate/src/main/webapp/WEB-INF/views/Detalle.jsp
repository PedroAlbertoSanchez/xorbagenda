<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página principal</title>

<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
<link
	href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600'
	rel='stylesheet' type='text/css'>


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



	
	
	<div class="banner">
		

		<!-- Codigo antiguo 
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
		</form:form> -->

		<!-- Boton busqueda ya maquetado -->
		<div class="content">
			<div class="container wow fadeInUp delay-03s">
				<div class="row">
					<div class="logo text-center">
						<img src="static/img/agenda.png" alt="logo">
						<h2 class="subs-title text-center">Xorbagenda</h2>

					</div>


					<h2 class="subs-title text-center">Busca tu Xorba en
						Xorbagenda</h2>
					<div class="subcription-info text-center">
						<form:form class="subscribe_form" action="busqueda" method="post"
							modelAttribute="busqueda">
							<form:input value=""
								placeholder=" ¿Te acuerdas de Fulana? Buscala aquí"
								path="busqueda" class="email" id="email" name="email" />
							<input class="subscribe" name="email" value="¡A la yugular!"
								type="submit">
						</form:form>
						<p class="sub-p">También sirve para buscar otros seres
							humanos.</p>


					</div>
				</div>
			</div>
			<!-- Aquie termina el boton busqueda maquetado  -->



			<!-- Resultados -->
			<section id="about" class="section-padding">
			<div class="container wow fadeInUp delay-03s">

				<h3 class="subs-title text-center">Detalle del contacto</h3>
				<!-- comendtado por mi <div class="w3l_banner_nav_right"> -->
				<table border="1">
					<tr>
						<th>Nombre</th>
						<th>Apellido 1</th>
						<th>Apellido 2</th>
						<th>Telefono</th>
						<th>dni</th>
						<th>fecha de nacimiento</th>
						<th>direccion</th>
						<th>codigo empleado</th>
						<th>fecha de alta</th>
						<th>salario</th>
						<th>departamento</th>
						<th>categoria</th>
					</tr>


					<tr>
						<td>${Persona.nombre}</td>
						<td>${Persona.apellido1}</td>
						<td>${Persona.apellido2}</td>
						<td>${Persona.telefonos}</td>
						<td>${Persona.dni}</td>
						<td>${Persona.fechaNacimiento}</td>
						<td>${Persona.direcciones}</td>
						<td>${Persona.empleado.codEmpleado}</td>
						<td>${Persona.empleado.fechaAlta}</td>
						<td>${Persona.empleado.salario}</td>
						<td>${Persona.empleado.departamento.nombre}</td>
						<td>${Persona.empleado.categoria.nombre}</td>
						<td><a href="edit?id=${user.id}">Modificar</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${user.id}">Eliminar</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</section>
	</div>



</body>
</html>