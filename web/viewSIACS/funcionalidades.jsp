<%-- 
    Document   : funcionalidades
    Created on : jun 13, 2018, 8:32:05 a.m.
    Author     : mdcarrion7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession objSesion = request.getSession(true);
    String user = "USUARIO_X"; //aqui tu identificador de usuario
    objSesion.setAttribute("usuario", user);
    out.println("Poniendo usuario en sesion ..." + objSesion.getAttribute("usuario"));
%>
<html>
    <head>
        <title>Menú SIACS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/stylesmain.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h1>SIACS</h1>
            </header>
            <nav>
                <ul>
                    <li><a href="../viewSIACS/connection.jsp">Inventario</a></li>
                    <li><a href="../viewSIACS/funcionalidades.html">Usuarios</a></li>
                    <li><a href="#">Informes</a></li>
                </ul>
            </nav>

            <article>
                <h1>Inventario</h1>
                <p>Inventario de los materiales e insumos disponibles en el Área de Ciencias de la Salud.</p>                
            </article>
        </div>
        <footer >Copyright &copy; W3Schools.com</footer>
    </body>
</html>
