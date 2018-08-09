<%-- 
    Document   : registrar
    Created on : jun 15, 2018, 12:54:35 p.m.
    Author     : mdcarrion7
--%>

<%@page import="com.siacs.view.bloquesHTML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/stylesmain.css" >

        <title>Registrar Artículo</title>
    </head>
    <body>
        <div class="container">
            <%
                bloquesHTML bloc = new bloquesHTML();
                out.print(bloc.cabecerahtml());
                String codigoInsumos = bloc.codigoMat() + request.getAttribute("indexMaterial");
            %>
            <nav>
                <ul>
                    <li><a class="buttonVmenu" href="AdminInsumo?action=index" >Menú</a></li>
                    <li><a class="buttonVmenu" href="AdminInsumo?action=mostrar">Inventario</a></li>                            
                </ul>
            </nav>
            <article>
                <h3>Registrar Insumo</h3>
                <form action="AdminInsumo?action=registerMat" method="post">
                    <div class="">
                        <table border="1" align="left">                
                            <tr>
                                <td>Código:</td>		
                                <td><input type="text" name="codigo" readonly value="<% out.print(codigoInsumos); %>"/></td>	                                	
                            </tr>
                            <tr>
                                <td>Nombre:</td>		
                                <td><input type="text" name="nombre" maxlength="100"/></td>	
                            </tr>
                            <tr>
                                <td>Descripción:</td>		
                                <td><input type="text" name="descripcion" maxlength="150"/></td>	
                            </tr>
                            <tr>
                                <td>Cantidad:</td>		
                                <td><input type="number" min="1" name="cantidad"/></td>	
                            </tr>
                            <tr>
                                <td>Ubicación:</td>		
                                <td><input type="text" name="ubicacion"/></td>	
                            </tr>		
                            <tr>
                                <td>Número usos</td>		
                                <td><input type="number" name="numerousos"/></td>	
                            </tr>
                             <tr>
                                <td>Disponibilidad</td>		
                                <td><input type="number" name="disponibilidad"/></td>	
                            </tr>
                            <tr>
                                <td>Funcionalidad</td>		
                                <td><input type="text" name="funcionalidad"/></td>	
                            </tr>		
                            <tr>
                                <td>Observaciones:</td>		
                                <td><input type="text" name="observaciones"/></td>	
                            </tr>		
                        </table>
                        <br><br><br><br><br><br><br><br><br><br><br><br><br>
                        <table border="0" align="left">
                            <tr>
                                <td><input  type="submit" value="Agregar" name="agregar"></td>	
                            </tr>
                        </table>
                    </div>
                </form>
            </article>
        </div>
        <%
            out.print(bloc.piepaginahtml());
        %>     
    </body>
</html>