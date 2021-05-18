<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<head>
    <title>FORMULARIO CREAR TELÉFONO</title>
      <link href="/AgendaTelefonica/css/estilo2.css" rel="stylesheet" />
</head>

<body>
    <main>
        <div class="contact-form">
            <div class="form-header">
                <h1>REGISTRO DE TELEFONO</h1>
            </div>

            <form class="form-group" action="/AgendaTelefonica/ControladorCrearTelefono" method="post">
                <div class="row">
                    <div class="label">
                        Número de Teléfono
                    </div>
                    <div class="inputs">
                        <input type="text" name="numeroTel" maxlength="20" class="input-txt" placeholder="Ingrese el número de teléfono" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="row">
                    <div class="label">
                       Tipo
                    </div>
                    <div class="inputs">
                     <select name="tipo" class="input-txt input-one">
  					<option value="movil">Móvil</option>
				  <option value="fijo">Fijo</option>
					</select> 
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="row">
                    <div class="label">
                       Operadora
                    </div>
                    <div class="inputs">
                     <select name="operadora" class="input-txt input-one">
  					<option value="claro">Claro</option>
				  <option value="movistar">Movistar</option>
				  <option value="tuenti">Tuenti</option>
				  <option value="CNT">CNT</option>
					</select> 
                    </div>
                    <div class="clear"></div>
                </div>
                <hr />
                <button class="submit-btn" type="submit" value="Crear">Registrar Telefono</button>
            </form>
        </div>
    </main>
</body>

</html>
