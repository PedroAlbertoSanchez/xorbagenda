<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
  <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,400italic,300italic,300|Raleway:300,400,600' rel='stylesheet' type='text/css'>

<spring:url value="static/css/font-awesome.min.css" var="font"/> 
<link href="${font}" rel="stylesheet" />

<spring:url value="static/css/bootstrap.min.css" var="bootstrap"/> 
<link href="${bootstrap}" rel="stylesheet" />

<spring:url value="static/css/animate.css" var="animate"/> 
<link href="${animate}" rel="stylesheet" />

<spring:url value="static/css/style.css" var="style"/> 
<link href="${style}" rel="stylesheet" />


<title>Agregar Persona</title>
</head>
<body>
<div class="content">
    <div class="container wow fadeInUp delay-03s">
      	<div class="row">
			<div class="logo text-center">
    			<img src="static/img/agenda.png" alt="logo"><h2 class="subs-title text-center">Xorbagenda</h2>
    		</div>
    		
    		<div class="logo text-center">
				<h1>Agrega un/a Human@ a tu Xorbagenda</h1>
			</div>
    		
    		<div align="center">
    			
					<form:form action="save" method="post" modelAttribute="usuario">
					<form:hidden path="idpersonas" />
					<form:hidden path="idempleados" />
					<form:hidden path="idtelefonos1" />
					<form:hidden path="idtelefonos2" />
					<form:hidden path="idtelefonos3" />
					<form:hidden path="iddirecciones1" />
					<form:hidden path="iddirecciones2" />
					<form:hidden path="iddirecciones3" />
					<br>
					
					<fieldset>
							<legend>Datos Personales.</legend>	
							<div align="center">
							<table width="900">
								<tr>
									<td>DNI: (*)</td>
									<td>Nombre: (*)</td>
									<td>Primer Apellido: (*)</td>
									<td>Segundo Apellido:</td>
									<td>Fecha de Nacimiento</td>
								</tr>
								<tr>
									<td><form:input path="dni" /></td>
									<td><form:input path="nombre" /></td>			
									<td><form:input path="apellido1" /></td>	
									<td><form:input path="apellido2" /></td>
									<td><form:input path="fechaNacimiento"  id="date" type="date" max="1979-12-31" /></td>
								</tr>
							</table>
							</div>
					</fieldset>
					<br>
					<fieldset>
					
						<legend>Datos de Empleado</legend>
						
						<div align="center">
							<table width="900">
							
                            
                            <div class="has-error">
                                <form:errors path="departamento" class="help-inline"/>
                            </div>
                            
                            <div class="has-error">
                                <form:errors path="categoria" class="help-inline"/>
                            </div>
					
								<tr>
									<td>Código de Empleado (*):</td>
									<td>Departamento (*):</td>
									<td>Categoria (*):</td>
								</tr>
								<tr>
									<td><form:input path="codEmpleado" /></td>
									<td><form:select path="departamento" id="departamento" class="form-control input-sm">
                                		<form:option value="">Select Departamento</form:option>
                               			<form:options items="${departamentos}" />
                          				  </form:select></td>
									<td><form:select path="categoria" id="categoria" class="form-control input-sm">
                                		<form:option value="">Select Categoria</form:option>
                                		<form:options items="${categorias}"/>
                            			</form:select></td>
								</tr>
							</table>
						</div>
					</fieldset>
					<br>
					<fieldset>
					
						<legend>Primera Dirección</legend>
						
						<div align="center">
							<table width="900">
					
								<tr>
									<td>Direccion:</td>
									<td>Código Postal:</td>
									<td>Localidad:</td>
									<td>Provincia:</td>
									<td>Telefono:</td>
								</tr>
								
								<tr>
									<td><form:input path="direccion1" /></td>
									<td><form:input path="codPostal1" /></td>
									<td><form:input path="localidad1" /></td>
									<td><form:input path="provincia1" /></td>
									<td><form:input path="telefono1" /></td>
								</tr>
								
							</table>
						</div>
						
					</fieldset>
					<br>
					<fieldset>
					
						<legend>Segunda Dirección</legend>
						
						<div align="center">
							<table width="900">
					
								<tr>
									<td>Direccion:</td>
									<td>Código Postal:</td>
									<td>Localidad:</td>
									<td>Provincia:</td>
									<td>Telefono:</td>
								</tr>
								
								<tr>
									<td><form:input path="direccion2" /></td>
									<td><form:input path="codPostal2" /></td>
									<td><form:input path="localidad2" /></td>
									<td><form:input path="provincia2" /></td>
									<td><form:input path="telefono2" /></td>
								</tr>
								
							</table>
						</div>
						
					</fieldset>
					<br>
					<fieldset>
					
						<legend>Tercera Dirección</legend>
						
						<div align="center">
							<table width="900">
					
								<tr>
									<td>Direccion:</td>
									<td>Código Postal:</td>
									<td>Localidad:</td>
									<td>Provincia:</td>
									<td>Telefono:</td>
								</tr>
								<tr>
									<td><form:input path="direccion3" /></td>
									<td><form:input path="codPostal3" /></td>
									<td><form:input path="localidad3" /></td>
									<td><form:input path="provincia3" /></td>
									<td><form:input path="telefono3" /></td>
								</tr>
							</table>
						</div>
						
					</fieldset>
					
				
						
	
				<input type="submit" value="Guardar Registro">
		
				
			</form:form>
    	
    	</div>
   	</div>
</div>
</div>

    	

</body>
</html>
