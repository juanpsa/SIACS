<%-- 
    Document   : login
    Created on : 17/07/2018, 11:27:17
    Author     : jpsigcho
    SRC        : http://www.forosdelweb.com/f45/aporte-registro-login-usuarios-con-jsp-servlets-mysql-930805/
--%>

<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- En caso de que exista una sesion iniciada redirecciono a index.jsp. "NO tiene caso mostrar este formulario cuando hay una sesion iniciada --%>
<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("index.jsp");%>
</t:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion</title>
    </head>
    <body>
        <h1>Iniciar sesion</h1>
        <p><a href="register.jsp">Registrarse</a></p>
        <p style="color: #ff0000">${sessionScope['error']}</p>
        <form action="Login" method="post">
            <p> Email: <input type="text" name="email"></p>
            <p> Contraseña: <input type="password" name="password"></p>
            <p><input type="submit" value="Entrar"></p>
        </form>
    </body>
</html>