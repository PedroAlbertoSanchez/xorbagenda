<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultados de busqueda</title>
</head>
<body>
<div id="contenedor">
	<h2>Resultados de busqueda</h2>

	<!--  Modificar esta pagina, esta recien copiada de otro fichero  -->
		<table border="1">
		<tr>
			<th>Nº</th>
			<th>Usuario</th>
			<th>Email</th>
			<th>Acciones</th>
			</tr>

			<c:forEach items="${listaPersonas}" var="Persona">
				<tr>
					<td>${Persona.nombre}</td>
					<td>${Persona.apellido1}</td>
					<td>${Persona.dni}</td>
					<td><a href="edit?id=${user.id}">Modificar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${user.id}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
</div>


</body>
</html>