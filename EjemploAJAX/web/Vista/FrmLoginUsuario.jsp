<%-- 
    Document   : newjspFrmLoginUsuario
    Created on : 04-oct-2018, 10:20:29
    Author     : AUTONOMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <script>
                function entrar()
                {
                    document.form.action='<%=request.getContextPath()%>/usuarioservlet';
                    document.form.method='POST';
                    document.form.op.value="1";
                    document.form.submit();
                }
        </script>
    </head>
    <body>
    <center>
        <h2>LOGIN USUARIO</h2>
        <form name="form">
            <input type="hidden" name="op">
            <table border="1">
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="txtusu" id="txtusu"></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="password" name="txtclave" id="txtclave"></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><input type="button" value="Entrar" onclick="entrar()"></td>                    
                </tr>
            </table>
            <font color="red">
            <%
                if(request.getAttribute("mensaje")!=null){
                    String msj=(String)request.getAttribute("mensaje");
                    out.print(msj);
                }
            %>
            </font>
        </form>
    </center>
    </body>
</html>
