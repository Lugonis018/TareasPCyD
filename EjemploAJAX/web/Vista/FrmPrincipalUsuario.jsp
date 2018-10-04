
<%-- 
    Document   : FrmPrincipalUsuario
    Created on : 04-oct-2018, 10:20:48
    Author     : AUTONOMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ResgistroAJAX</title>
        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        <script>
            $(document).ready(function(){
               $('#submit').click(function(event){
                   var nombreVar= $('#nombre').val();
                   var apellidoVar=$('#apellido').val();
                   var edadVar=$('#edad').val();
                   $.post('personaservlet',{
                       nombre:nombreVar,
                       apellido:apellidoVar,
                       edad:edadVar
                   },function(responseText) {
                       $('#tabla').html(responseText);
                   });
               }); 
            });
        </script>
    </head>
    <body>
    <center>
        <h2>Formulario registro</h2>
        <form id="form1">
            Nombre: <input type="text" id="nombre"/><br><br>
            Apellido: <input type="text" id="apellido"/><br><br>
            Edad: <input type="text" id="edad"/><br><br>
            <input type="button" id="submit" value="Añadir"/>
        </form>
        <br>
        <div id="tabla"></div>
    </center>
    </body>
</html>
