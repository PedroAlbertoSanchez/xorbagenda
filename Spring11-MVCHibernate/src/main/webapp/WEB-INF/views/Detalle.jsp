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
</head>
<body>

 <div id="contenedor">
            <h2>Buscar Empleado</h2>

            <form:form action="busqueda" method="POST" modelAttribute="busqueda">
               
                <form:errors path="*" cssClass="destacado" element="div"/>
                <table>
                    <tr>
                        <td>Nombre Usuario: </td>
                        <td><form:input path="busqueda" /></td>
                    
                        <td><form:errors path="busqueda" cssClass="destacado" /></td>
                    </tr>
                    <tr>

                    <tr>
                        <td colspan="3">

                            <input type="submit" value="Buscar" name="" />
                          
                        </td>
                    </tr>

                </table>
            </form:form>
            <table border="1">
		<tr>
			<th>Nombre</th>
			<th>Apellido 1</th>
			<th>Apellido 2</th>
			<th>Telefono</th>
			<th>Telefono</th>
			<th>Telefono</th>
			<th>Telefono</th>
			<th>Telefono</th>
			<th>Acciones</th>
			</tr>


				<tr>
					<td><a href="/mostrarDetalle$idPersona={Persona.idPersonas}">${Persona.nombre}</td>
					<td>${Persona.apellido1}</td>
					<td>${Persona.apellido2}</td>
					<td>${Persona.telefonos}</td>
					<td><a href="edit?id=${user.id}">Modificar</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=${user.id}">Eliminar</a>
					</td>
				</tr>
		</table>
        </div>

</body>
</html>