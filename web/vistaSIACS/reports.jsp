<%-- 
    Document   : reports
    Created on : jun 5, 2018, 11:26:08 a.m.
    Author     : jpsigcho
--%>
<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String) objSesion.getAttribute("usuario");
    out.println("Usuario en sesion: " + usuario);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="../prueba">lo que sea</a>
    </body>
</html>
