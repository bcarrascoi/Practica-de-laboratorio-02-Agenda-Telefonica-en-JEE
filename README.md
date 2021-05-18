
1.	DESARROLLO DE UNA APLICACIÓN JEE BASADO EN SERVLETS, JSP Y JDBC PARA EL INTERCAMBIO DE DATOS EN UN MODELO DE TRES CAPAS APLICANDO LOS PATRONES DISEÑO DE SOFTWARE MVC Y DAO.

2.	REQUERIMIENTOS FUNCIONALES

•	Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.
•	Un usuario puede iniciar sesión usando su correo y contraseña.
•	Una vez iniciado sesión el usuario podrá:
-	Registrar, modificar, eliminar, buscar y listar sus teléfonos.
-	Listar los números de teléfono de un usuario usando su número de cédula o correo electrónico.
-	Podrá llamar o enviar un correo electrónico desde el sistema usando aplicaciones externas.
•	Los datos siempre deberán ser validados cuando se trabaje a través de formularios.

a)	Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.



•	Index.html
<br>

![image](https://user-images.githubusercontent.com/56461202/118661644-ef329d00-b7b4-11eb-964e-cdba094ab12c.png)


•	Login

<br>

![image](https://user-images.githubusercontent.com/56461202/118661874-2739e000-b7b5-11eb-9555-8680398bf45a.png)

•	Para la creación del Login, en Eclipse se creó un Servlet llamado  ControladorLogin.java y un filtro llamado Filtro IniciarSesion.java


-	ControladorLogin.java

<br>

![image](https://user-images.githubusercontent.com/56461202/118661916-31f47500-b7b5-11eb-9d9b-644c7f7c57a0.png)

-	FiltroIniciarSesión

<br>

![image](https://user-images.githubusercontent.com/56461202/118661941-39b41980-b7b5-11eb-97af-bbb0db000df0.png)

-	En caso de que no cuente con un correo y contraseña se procederá a llenar el formulario de registro.

•	Formulario Registro de Usuario 

<br>

![image](https://user-images.githubusercontent.com/56461202/118661983-420c5480-b7b5-11eb-9142-aab5be8fc27c.png)


-	Para la creación del usuario se implementó un Servlet llamado ControladorCrearUsuario.java


<br>

![image](https://user-images.githubusercontent.com/56461202/118662017-49336280-b7b5-11eb-980a-b337f836e652.png)



-	Una vez creado el usuario se procederá a iniciar Sesión.


<br>

![image](https://user-images.githubusercontent.com/56461202/118662057-52243400-b7b5-11eb-918f-9dd8a1535031.png)


-	Una vez iniciado sesión se mostrará la siguiente página que contendrá el menú de usuario.

•	Usuario_menu.html

<br>

![image](https://user-images.githubusercontent.com/56461202/118662076-56e8e800-b7b5-11eb-93cc-f4749d8d7efb.png)


•	En este menú de usuario podremos crear, actualizar, eliminar, buscar  y listar los teléfonos.

-	Crear Teléfono

<br>

![image](https://user-images.githubusercontent.com/56461202/118662127-623c1380-b7b5-11eb-9805-8b49457959ab.png)


-	En donde para la creación del teléfono se creo un Servlet llamado ControladorCrearTelefono.java

<br>

![image](https://user-images.githubusercontent.com/56461202/118662202-7122c600-b7b5-11eb-9aca-4337e914d255.png)


•	Actualizar Teléfono

<br>

![image](https://user-images.githubusercontent.com/56461202/118662224-76801080-b7b5-11eb-88d6-c19603f196e4.png)



-	En donde para la actualización de los datos del teléfono se creó un Servlet llamado ControladorActualizarTelefono.java

<br>

![image](https://user-images.githubusercontent.com/56461202/118662274-7ed84b80-b7b5-11eb-90df-23dad44b8028.png)


 

•	Buscar Teléfono
<br>

![image](https://user-images.githubusercontent.com/56461202/118662333-8861b380-b7b5-11eb-857f-4261b66db183.png)





•	Buscar_telefono.jsp

<br>

![image](https://user-images.githubusercontent.com/56461202/118662381-90b9ee80-b7b5-11eb-8f3b-5d955139d2e1.png)



-	En donde para la búsqueda de los datos del teléfono se creó un Servlet llamado ControladorBuscarTelefono.java

<br>

![image](https://user-images.githubusercontent.com/56461202/118662409-96afcf80-b7b5-11eb-9056-8439b71538bb.png)



•	Eliminar Telefono

<br>

![image](https://user-images.githubusercontent.com/56461202/118662445-9dd6dd80-b7b5-11eb-82d9-ae8a56cb165a.png)


-	En donde para la eliminación de los datos del teléfono se creó un Servlet llamado ControladorEliminarTelefono.java

<br>

![image](https://user-images.githubusercontent.com/56461202/118662487-a8917280-b7b5-11eb-8ce9-bc96c35e83a8.png)


•	Listar Telefono
<br>

![image](https://user-images.githubusercontent.com/56461202/118662543-b34c0780-b7b5-11eb-9ce2-df624019de9e.png)

 
-	En donde para la lista de los datos del teléfono se creó un Servlet llamado ControladorListarTelefono.java
<br>

![image](https://user-images.githubusercontent.com/56461202/118662562-b8a95200-b7b5-11eb-9da3-224abd96369e.png)


-	También podemos listar los números de teléfono de otro usuario ya sea por su correo o contraseña.


<br>

![image](https://user-images.githubusercontent.com/56461202/118662609-c232ba00-b7b5-11eb-8beb-2387ccae47c9.png)


-	Resultado búsqueda por número de cédula o correo electrónico.
<br>


![image](https://user-images.githubusercontent.com/56461202/118662643-c9f25e80-b7b5-11eb-953d-89b0bd8c73b9.png)

-	Podremos llamar o enviar un correo electrónico al momento que buscamos los datos de otro usuario

<br>

![image](https://user-images.githubusercontent.com/56461202/118662680-d1b20300-b7b5-11eb-9b30-aa6d1409a4e9.png)

-	Al momento que damos clic en el correo se abre una aplicación externa para poder enviar un correo electrónico.
<br>

![image](https://user-images.githubusercontent.com/56461202/118662716-d70f4d80-b7b5-11eb-9966-653cd83edf93.png)


-	Al momento que damos clic en el número de teléfono se abre una aplicación externa para realizar una llamada.

<br>

![image](https://user-images.githubusercontent.com/56461202/118662755-df678880-b7b5-11eb-987f-338e92f6c324.png)
