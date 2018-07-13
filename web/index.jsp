<%-- 
    Document   : index.jsp
    Created on : 03/07/2018, 15:58:45
    Author     : mdcarrion7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String redirectURL = request.getRequestURL().toString();
    String pagInicio = getServletContext().getInitParameter("paginaInicio");
    response.sendRedirect(redirectURL+pagInicio);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirigiendo</title>
    </head>
    <body>
        <h1>Redirigiendo............</h1>
    </body>
</html>
