<%-- 
    Document   : registrar
    Created on : jun 15, 2018, 12:54:35 p.m.
    Author     : mdcarrion7
--%>

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
            <header>
                <h1>SIACS</h1>
            </header>
            <nav>
                <ul>
                    <li><a href="AdminInsumo?action=mostrar">Inventario</a></li>                                     
                </ul>
            </nav>
            <article>
                <h3>Registrar Artículo</h3>
                <form action="adminArticulo?action=register" method="post">
                    <table border="1" align="left">                
                        <tr>
                            <td>Código:</td>		
                            <td><input type="text" name="codigo"/></td>	
                        </tr>
                        <tr>
                            <td>Nombre:</td>		
                            <td><input type="text" name="nombre"/></td>	
                        </tr>
                        <tr>
                            <td>Descripción:</td>		
                            <td><input type="text" name="descripcion"/></td>	
                        </tr>
                        <tr>
                            <td>Cantidad:</td>		
                            <td><input type="text" name="cantidad"/></td>	
                        </tr>
                        <tr>
                            <td>Ubicación:</td>		
                            <td><input type="text" name="precio"/></td>	
                        </tr>		
                        <tr>
                            <td>Observaciones:</td>		
                            <td><input type="text" name="precio"/></td>	
                        </tr>		
                    </table>
                    <br>
                    <table border="0" align="left">
                        <tr>
                            <td><input  type="submit" value="Agregar" name="agregar"></td>	
                        </tr>
                    </table>
                </form>
            </article>
        </div>
        <div>
            <footer>Copyright &copy; W3Schools.com</footer>
        </div>
    </body>
</html>