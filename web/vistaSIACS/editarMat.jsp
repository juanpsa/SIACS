<%-- 
    Document   : editar
    Created on : jun 15, 2018, 12:34:03 p.m.
    Author     : mdcarrion7
--%>
<%@page import="com.siacs.view.bloquesHTML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="css/stylesmain.css" type="text/css">
        <title>Actualizar Insumo</title>
    </head>
    <body>
        <div class="container">
            <%
                bloquesHTML bloc = new bloquesHTML();
                out.print(bloc.cabecerahtml());
            %>
            <nav>
                <ul>
                    <li><a class="" href="AdminInsumo?action=index" >Menú</a></li>
                    <li><a href="AdminInsumo?action=mostrar">Inventario</a></li>                            
                </ul>
            </nav>
            <article>
                <h3>Actualizar Insumo</h3>
                <form action="AdminInsumo?action=editar" method="post" >
                    <table >
                        <tr>
                            <td><label>Id</label></td>
                            <td><input type="text" name="id" readonly value="<c:out value="${insumo.id}"></c:out>" ></td>
                        </tr>  
                       <tr>
                            <td><label>Código</label></td>
                            <td><input type="text" name="codigo" readonly value='<c:out value="${insumo.codigo}"></c:out>' ></td>
                        </tr>
                        <tr>
                            <td><label>Nombre</label></td>
                            <td><input type="text" name="nombre" value='<c:out value="${insumo.nombre}"></c:out>' ></td>
                        </tr>
                        <tr>
                            <td><label>Descripción</label></td>
                            <td><input type="text" name="descripcion" value='<c:out value="${insumo.descripcion}"></c:out>' ></td>
                        </tr>
                        <tr>
                            <td><label>Cantidad</label></td>
                            <td><input type="number" min="1" name="cantidad"  value='<c:out value="${insumo.cantidad }"></c:out>' ></td>
                        </tr>
                        <tr>
                            <td><label>Ubicacion</label></td>
                            <td><input type="text" name="ubicacion" value='<c:out value="${insumo.ubicacion }"></c:out>' ></td>
                        </tr>
                        <tr>
                            <td><label>Observaciones</label></td>
                            <td><input type="text" name="observaciones" value='<c:out value="${insumo.observaciones }"></c:out>' ></td>
                        </tr>
                    </table>
                        <input type="submit" name="registrar" value="Actualizar" align="center"> 
                </form>
            </article>
        </div>
        <%
            out.print(bloc.piepaginahtml());
        %> 
    </body>
</html>