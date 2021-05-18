<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> LISTA DE USUARIOS </title>
</head>
<body>
	<c:set var="lista" scope="request" value="${usuarios}" />
	<h1>Lista de usuarios </h1>

	<table>
		<tr>
		<td>
			<td><strong>Cedula</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>Apellido</strong></td>
			<td><strong>Correo</strong></td>
			<td><strong>Contrasena</strong></td>
		</tr>
		<c:forEach var="u" items="${lista}">
			<tr>
				<td>${u.cedula}</td>
				<td>${u.nombre}</td>
				<td>${u.apellido}</td>
				<td>${u.correo}</td>
				<td>${u.contrasena}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/AgendaTelefonica/admin_menu.html">Regresar al menú</a>

</body>
</html>

