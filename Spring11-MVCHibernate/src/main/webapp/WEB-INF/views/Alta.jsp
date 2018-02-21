<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<spring:url value="/resources/css/bootstrap.css" var="estilos1" />
		<link href="${estilos1}" rel="stylesheet" />
		
		<spring:url value="/resources/css/custom.css" var="estilos3" />
		<link href="${estilos3}" rel="stylesheet" />		
	
		<spring:url value="css/bootstrap.css" var="estilos2" />
		<link href="${estilos2}" rel="stylesheet" />	
		
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
<title>FORMULARIO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE USUARIOS (add/edit)</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="usuario">
				<form:hidden path="id" />
				<tr>
					<td>nombre:</td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td>apellido1:</td>
					<td><form:input path="apellido1" /></td>
				</tr>
				<tr>
					<td>apellido2:</td>
					<td><form:password path="apellido2" /></td>
				</tr>
				<tr>
					<td>dni:</td>
					<td><form:input path="dni" /></td>
				</tr>
				<tr>
					<td>fechaNacimiento:</td>
					<td><form:input path="fechaNacimiento" /></td>
				</tr>
				<tr>
					<td>direccion 1:</td>
					<td><form:password path="direccion1" /></td>
				</tr>
				<tr>
					<td>direccion 2:</td>
					<td><form:password path="direccion2" /></td>
				</tr>
				<tr>
					<td>direccion 3:</td>
					<td><form:password path="direccion3" /></td>
				</tr>
				<tr>
					<td>telefono 1:</td>
					<td><form:password path="telefono1" /></td>
				</tr>
				<tr>
					<td>telefono 2:</td>
					<td><form:password path="telefono2" /></td>
				</tr>
				<tr>
					<td>telefono 3:</td>
					<td><form:password path="telefono3" /></td>
				</tr>
				<tr>
					<td>fechaAlta intentar timestamp:</td>
					<td><form:input path="fechaAlta" /></td>
				</tr>
				<tr>
					<td>salario:</td>
					<td><form:password path="salario" /></td>
				</tr>
				<p>seleccionable con categorias</p>
				<p>seleccionable con departamentos</p>
				<tr>
					<td colspan="2" align="center">
				<input type="submit" value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>