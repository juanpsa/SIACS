<%-- 
    Document   : mostrar
    Created on : jun 15, 2018, 12:55:21 p.m.
    Author     : jpsigcho
--%>

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
        <title>Administrar Artículos</title>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>SIACS</h1>
                <%
                    HttpSession objSesion = request.getSession(false);
                    if (!((String) objSesion.getAttribute("usuario")).isEmpty()) {
                        out.println("<h3>Administrador</h3>");
                    } else {
                        out.println("<h3>Usuario</h3>");
                    }
                %>
            </header>
            <nav>
                <table>
                    <tr>
                        <td><a href="AdminInsumo?action=index" >Regresar al menú</a> </td>
                    </tr>
                    <tr>
                        <td><a href="AdminInsumo?action=nuevo" >Ingresar nuevo</a> </td>
                    </tr>
                </table>
            </nav>
            <article>
                <h3>Lista  Insumos</h3>
                <select id="selectBox" onchange="changeFunc();">
                    <option value="Insumo">Insumo</option>
                    <option value="Materiales">Materiales</option>
                </select>

                <table class=inventario border=1 width="100%">                    
                    <tr>
                        <td> ID</td>
                        <td> CODIGO</td>
                        <td> NOMBRE</td>
                        <td>DESCRPICION</td>
                        <td>CANTIDAD</td>
                        <td>UBICACION</td>
                        <td>OBSERVACIONES</td>
                        <td colspan=2>ACCIONES</td>
                    </tr>
                    <c:forEach var="insumo" items="${lista}">
                        <tr>
                            <td id='ident-box'><c:out value="${insumo.id}"/></td>
                            <td id='code-box'><c:out value="${insumo.codigo}"/></td>
                            <td id='namepr-box' ><c:out value="${insumo.nombre}"/></td>
                            <td id="descrp-box" ><c:out value="${insumo.descripcion}"/></td>
                            <td id="cntd-box"><c:out value="${insumo.cantidad}"/></td>
                            <td id="location-box"><c:out value="${insumo.ubicacion}"/></td>
                            <td id="observ-box"><c:out value="${insumo.observaciones}"/></td>
                            <td><a class='btn-styles' href="adminInsumo?action=showedit&id=<c:out value="${insumo.id}" />">Editar</a></td>
                            <td><a class='btn-styles' href="adminInsumo?action=eliminar&id=<c:out value="${insumo.id}"/>">Eliminar</a> </td>				
                        </tr>
                    </c:forEach>               
                </table>
            </article>
        </div>
        <div>
            <footer >Copyright &copy; W3Schools.com</footer>
        </div>
    </body>
</html>