<%-- 
    Document   : mostrar
    Created on : jun 15, 2018, 12:55:21 p.m.
    Author     : jpsigcho
--%>

<%@page import="com.siacs.view.bloquesHTML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/stylesmain.css">
        <script type="text/javascript">

            function changeFunc() {
                var selectBox = document.getElementById("selectBox");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                alert(selectedValue);
            }

        </script>
        <script language="JavaScript">
            function pregunta() {
                if (confirm('¿Estas seguro de enviar este formulario?')) {
                    document.tuformulario.submit()
                }
            }
        </script>
        <title>Administrar Artículos</title>
    </head>
    <body>
        <div class="container">            
            <%
                HttpSession objSesion = request.getSession();
                if (request.getAttribute("indexInsumo") != null && !request.getAttribute("indexInsumo").toString().isEmpty()) {
//                    out.println("<h3>Administrador</h3>");
//                    out.println("<h3>" +request.getAttribute("indexInsumo").toString()+objSesion.getAttribute("indexInsumo").toString()+"</h3>");                    
                } else {
//                    out.println("<h3>Usuario</h3>");
                }
                bloquesHTML bloc = new bloquesHTML();
                out.print(bloc.cabecerahtml());
            %>

            <nav>
                <ul>
                    <li><a class="buttonVmenu" href="AdminInsumo?action=index" >Menú Principal</a></li>                                        
                </ul>
            </nav>
            <article>
                <h3>Inventario</h3>
                <div  class="hmenu" style="align-content: center">
                    <ul >
                        <li><a class="buttonHmenu" onmouseover="Inventario de cosas" href="AdminInsumo?action=mostrar" value="INSUMOS">Insumos</a></li>
                        <li><a class="buttonHmenu"  href="AdminInsumo?action=mostrarMat" value="INSUMOS">Materiales</a></li>
                        <br><br><br><br><br><br><br><br><br><br>
                    </ul>
                </div >
            </article>

        </div>
        <%
            out.print(bloc.piepaginahtml());
        %>
    </body>
</html>