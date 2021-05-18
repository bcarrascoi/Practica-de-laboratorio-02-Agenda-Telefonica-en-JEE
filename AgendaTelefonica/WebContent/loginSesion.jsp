<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link href="/AgendaTelefonica/css/estilo1.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<div class="container" id="container">
	<div class="form-container sign-up-container">
	</div>
	<div class="form-container sign-in-container">
		<form action="/AgendaTelefonica/ControladorLogin" method="POST">
			<h1>Agenda Telefónica</h1>
			<input type="email" name="correo" placeholder="Ingrese su correo" />
			<input type="password" name="contrasena" placeholder="Ingrese su contraseña" />
			<button name="action" value="Iniciar Sesion" href="/AgendaTelefonica/usuario_menu.html" >Iniciar Sesión</button>
		</form>
	</div>
	<form action="#" href="/AgendaTelefonica/HTMLs/crear_usuario.html">
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				
				<p>Si no tienes una cuenta<br>
				¡Registrate!</p>
				<a class="btn btn-primary btn-xl js-scroll-trigger"  type="submit" href="/AgendaTelefonica/HTMLs/crear_usuario.html"> REGISTRARSE </a>
				<!-- <img src="https://image.flaticon.com/icons/png/512/69/69968.png"> -->
			</div>
		</div>
	</div>
	</form>
</div>
</body>
</html>