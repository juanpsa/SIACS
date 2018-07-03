<%-- 
    Document   : mensajeerror
    Created on : 25/06/2018, 11:43:08
    Author     : mdcarrion7
--%>

<%@page import="com.siacs.view.bloquesHTML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">            
            <%
                HttpSession objSesion = request.getSession(false);
                if (!((String) objSesion.getAttribute("usuario")).isEmpty()) {
                    out.println("<h3>Administrador</h3>");
                } else {
                    out.println("<h3>Usuario</h3>");
                }
                bloquesHTML bloc = new bloquesHTML();
                out.print(bloc.cabecerahtml());
            %>

            <nav>
                <ul>
                    <li><a class="" href="AdminInsumo?action=index" >Menú</a></li>
                    <li><a href="AdminInsumo?action=nuevo" >Nuevo</a></li>
                </ul>
            </nav>
            <article>
                
                <h2>ERROR NO SE PUDO REALIZAR LA OPERACIÓN REQUERIDA</h2>
            </article>
        </div>
        <%
            out.print(bloc.piepaginahtml());
        %>
    </body>
</html>
