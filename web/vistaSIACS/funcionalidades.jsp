<%-- 
    Document   : funcionalidades
    Created on : jun 13, 2018, 8:32:05 a.m.
    Author     : jpsigcho
--%>
<%@page import="com.siacs.view.bloquesHTML"%>
<%@ page import="java.sql.*,com.siacs.model.conexionDB" %>
<%@ page import="java.io.*,com.siacs.controller.CRUDstorage,javax.swing.table.DefaultTableModel" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession objSesion = request.getSession(true);
    String user = "USUARIO_X"; //aqui tu identificador de usuario
    objSesion.setAttribute("usuario", user);
//    out.println("Poniendo usuario en sesion ..." + objSesion.getAttribute("usuario"));

%>
<html>
    <head>
        <title>Menú SIACS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/stylesmain.css">
    </head>
    <body>
        <div class="container">
            <%                bloquesHTML bloc = new bloquesHTML();
                out.print(bloc.cabecerahtml());
            %>
            <nav >
                <ul>
                    <li><a class="buttonVmenu" href="AdminInsumo?action=indexInv">Inventario</a></li>
                    <li><a class="buttonVmenu" href="AdminInsumo?action=indexInv">Usuarios</a></li>
                </ul>
            </nav>
            <article>
                <h3>Inventario</h3>
                <p>Inventario de los materiales e insumos disponibles en el Área de Ciencias de la Salud.</p>                
                <h3>Usuarios</h3>
                <p>Administración de los usuarios que podrán ingresar a los datos de los inventarios</p>                
                <h3>Informes</h3>
                <p>Inventario de los materiales e insumos disponibles en el Área de Ciencias de la Salud.</p>                
            </article>
        </div>
        <%
            out.print(bloc.piepaginahtml());
        %>   
    </body>
</html>
