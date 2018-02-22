<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">


		<spring:url value="static/css/font-awesome.min.css" var="font"/> 
<link href="${font}" rel="stylesheet" />

<spring:url value="static/css/bootstrap.min.css" var="bootstrap"/> 
<link href="${bootstrap}" rel="stylesheet" />

<spring:url value="static/css/animate.css" var="animate"/> 
<link href="${animate}" rel="stylesheet" />

<spring:url value="static/css/style.css" var="style"/> 
<link href="${style}" rel="stylesheet" />


<title>FORMULARIO DE USUARIOS</title>
</head>
<body>
	<div align="center">
		<h1>FORMULARIO DE USUARIOS (add/edit)</h1>
		<table>
			<form:form action="save" method="post" modelAttribute="usuario">
				<form:hidden path="idpersonas" />
				<form:hidden path="idempleados" />
				<form:hidden path="idtelefonos1" />
				<form:hidden path="idtelefonos2" />
				<form:hidden path="idtelefonos3" />
				<form:hidden path="iddirecciones1" />
				<form:hidden path="iddirecciones2" />
				<form:hidden path="iddirecciones3" />
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
					<td><form:input path="apellido2" /></td>
				</tr>
				<tr>
					<td>dni:</td>
					<td><form:input path="dni" /></td>
				</tr>
				<tr>
					<td>fechaNacimiento:</td>
					<td><form:input path="fechaNacimiento"  id="date" type="date" max="1979-12-31" /></td>
				</tr>
				<tr>
					<td>direccion 1:</td>
					<td><form:input path="direccion1" /></td>
				</tr>
				<tr>
					<td>codPostal 1:</td>
					<td><form:input path="codPostal1" /></td>
				</tr>
				<tr>
					<td>localidad 1:</td>
					<td><form:input path="localidad1" /></td>
				</tr>
				<tr>
					<td>provincia 1:</td>
					<td><form:input path="provincia1" /></td>
				</tr>
				<tr>
					<td>direccion 2:</td>
					<td><form:input path="direccion2" /></td>
				</tr>
				<tr>
					<td>codPostal 2:</td>
					<td><form:input path="codPostal2" /></td>
				</tr>
				<tr>
					<td>localidad 1:</td>
					<td><form:input path="localidad2" /></td>
				</tr>
				<tr>
					<td>provincia 1:</td>
					<td><form:input path="provincia2" /></td>
				</tr>
				<tr>
					<td>direccion 3:</td>
					<td><form:input path="direccion3" /></td>
				</tr>
				<tr>
					<td>codPostal 3:</td>
					<td><form:input path="codPostal3" /></td>
				</tr>
				<tr>
					<td>localidad 3:</td>
					<td><form:input path="localidad3" /></td>
				</tr>
				<tr>
					<td>provincia 1:</td>
					<td><form:input path="provincia3" /></td>
				</tr>
				<tr>
					<td>telefono 1:</td>
					<td><form:input path="telefono1" /></td>
				</tr>
				<tr>
					<td>telefono 2:</td>
					<td><form:input path="telefono2" /></td>
				</tr>
				<tr>
					<td>telefono 3:</td>
					<td><form:input path="telefono3" /></td>
				</tr>
				<tr>
					<td>salario:</td>
					<td><form:input path="salario" /></td>
				</tr>
				<tr>
					<td>codEmpleado:</td>
					<td><form:input path="codEmpleado" /></td>
				</tr>
				<label class="col-md-3 control-label" for="departamento">Departamento (*)</label>
                        <div class="col-md-7">
                            <form:select path="departamento" id="departamento" class="form-control input-sm">
                                <form:option value="">Select Departamento</form:option>
                                <form:options items="${departamentos}" />
                            </form:select>
                            <div class="has-error">
                                <form:errors path="departamento" class="help-inline"/>
                            </div>
                        </div>
				<label class="col-md-3 control-label" for="categoria">Categoria (*)</label>
                        <div class="col-md-7">
                            <form:select path="categoria" id="categoria" class="form-control input-sm">
                                <form:option value="">Select Categoria</form:option>
                                <form:options items="${categorias}"/>
                            </form:select>
                            <div class="has-error">
                                <form:errors path="categoria" class="help-inline"/>
                            </div>
                        </div>
				<tr>
					<td colspan="2" align="center">
				<input type="submit" value="Guardar Registro"></td>
				</tr>
			</form:form>
		</table>
	</div>

</body>
</html>
