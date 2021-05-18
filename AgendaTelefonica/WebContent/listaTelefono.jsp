<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="css/index_style.css"/>
    </head>
    <body>
        <div class="jumbotron jum">
            
            <div class=" navbar">
            <h3> AGENDA TELEFONO <i class="far fa-address-book"></i></h3>
            </div>
            <div class="row">
             
                <div class="col-lg-4 inp">
               <!--  
                <input onkeyup="searchFunction()" id="myInput" class="form-control mt-2" placeholder="search">
                <span class="icon text-primary"><i class="fas fa-search"></i></span>
 -->
               <c:set var="telefonos" scope="session" value="${usuario.telefonos}"/>
					<c:set var="mensaje" scope="request" value="${mensaje}"/>
					<c:set var="tipoMensaje" scope="request" value="${tipoMensaje}"/>
					<h1 class="text-center text-light my-3"># de teléfonos de ${usuario}</h1>
                    
                </div>
                
                
        <div class="col-lg-8">
                
                <table id="myTable" class="table text-justify table-striped">
            
                <thead class="tableh1">
              <tr>
								<th class="text-center" scope="col">Número de Teléfono</th>
								<th class="text-center" scope="col">Tipo</th>
								<th class="text-center" scope="col">Operadora</th>
								<th class="text-center" scope="col">  
								<a class="btn btn-light d-inline" style="width: 15%;"
										href="/AgendaTelefonica/JSPs/crear_telefono.jsp"> Agregar Teléfono</a>
										</th>
										</tr>
                </thead>
                
                <tbody id="tableBody">
                <c:forEach var="telefono" items="${telefonos}">
								<tr>
									<td class="text-light text-center">${telefono.numero}</td>
									<td class="text-light text-center">${telefono.tipo}</td>
									<td class="text-light text-center">${telefono.operadora}</td>
									<td class="text-center">
										<a class="btn btn-warning"
											href="/AgendaTelefonica/ControladorActualizarTelefono?id=${telefono.codigo}">Actualizar Telefono</a>
										<a class="btn btn-danger"
											href="/AgendaTelefonica/ControladorEliminarTelefono?id=${telefono.codigo}">Eliminar Teléfono</a>
									</td>
								</tr>
							</c:forEach>
 
                </tbody>            
                </table>
    
        </div>
            
            </div>    
        </div>
        
        
        
        <footer class="text-center">Todos los derechos reservados </footer>
        
           <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
    </body>
    
</html>