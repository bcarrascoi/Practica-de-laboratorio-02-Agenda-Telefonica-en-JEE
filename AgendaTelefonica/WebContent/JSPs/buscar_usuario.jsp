<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> BUSCAR USUARIO </title>
</head>
<body>
	<c:set var="u" scope="request" value="${usuario}" />
	<h1>USUARIO ENCONTRADO</h1>
			
	<p>Cedula: ${u.cedula}</p>
	<p>Nombre: ${u.nombre}</p>
	<p>Apellido: ${u.apellido}</p>
	<p>Correo: ${u.correo}</p>
	<p>Contrasena: ${u.contrasena}</p>
	
	<a href="/AgendaTelefonica/admin_menu.html">Regresar al menu</a>
	
</body>
</html>

