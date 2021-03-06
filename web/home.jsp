<%-- 
    Document   : home
    Created on : jun 14, 2018, 3:38:24 p.m.
    Author     : jpsigcho
--%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- En caso de que exista una sesion iniciada redirecciono a index.jsp. "NO tiene caso mostrar este formulario cuando hay una sesion iniciada --%>
<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("index.jsp");%>
</t:if>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>SIACS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>        
        <link rel="stylesheet" href="css/stylesmain.css">
    </head>
    <body style="vertical-align: middle">
        <div id="content"  ><br>
            <img id="logo"  alt="logo" src="resources/logoDCS.jpg">
            <h2>SIACS</h2>
            <h3>Sistema de Inventario para el Área de Ciencias de la salud </h3>
            <form action="AdminInsumo?action=index" method="post" >
                Usuario: <input class="btn-styles" autocomplete="off"><br>
                Password: <input class="btn-styles" autocomplete="off"><br>
                <input type="submit" value="Ingresar" title="Ingresar">
            </form>            
        </div><br>
        <div id="body-section">
            <div id="video-content"></div>
            <div id="view-content"></div>
        </div>
    </body>
</html>