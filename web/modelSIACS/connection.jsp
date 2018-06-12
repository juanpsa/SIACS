<%@ page import="java.sql.*,controllerJava.conexionDB" %>
<%@ page import="java.io.*,controllerJava.CRUDstorage,javax.swing.table.DefaultTableModel" %>


<%
    HttpSession objSesion = request.getSession(true);
    String user = "USUARIO_X"; //aqui tu identificador de usuario
    objSesion.setAttribute("usuario", user);
    out.println("Poniendo usuario en sesion ...");
%>
<html>
    <head>
        <!--<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">-->
        <link rel="stylesheet" type="text/css" href="../css/stylesmain.css">
        <title>Inventario</title>
    </head>
    <body>
        <h1>Inventario</h1>
        <form action="modelSIACS/connection.jsp">
            <div id="navbar">
                <span>Nuevo</span>            
                <input id="marca" type="text" placeholder="Id" maxlength="30">
                <input id="modelo" type="text" placeholder="Nombre" maxlength="30">
                <input id="conect" type="text" placeholder="Apellido" maxlength="30">
                <input id="tipo" type="text" placeholder="ROL" maxlength="30">            
                <button class="add-btn btn-styles" onclick="viewSIACS / reports.jsp">AÑADIR</button>                
            </div>
        </form>
        <div id="body">
            <select>
                <option value="Insumo">Insumo</option>
                <option value="Materiales">Materiales</option>
            </select>
            <table border="0" >                                
                <%
                    CRUDstorage neo = new CRUDstorage();                    
                    try {
                        DefaultTableModel tablaStorage = new DefaultTableModel();
                        tablaStorage = neo.conecctiondata();
                        out.println("<table class=inventario border=1 align= left>");
                        out.println("<tr><th>Id</th><th>Nombre</th><th>Cantidad</th><th>Descripcion</th></tr>");
                        for (int i = 0; i < tablaStorage.getRowCount(); i++) {
                            out.println("<tr><td id='id-box'>" + tablaStorage.getValueAt(i, 0) + "</td>");
                            out.println("<td id='marca  -box'>" + tablaStorage.getValueAt(i, 1) + "</td>");
                            out.println("<td id='cntd-box' align='center'>" + tablaStorage.getValueAt(i, 2) + "</td>");
                            out.println("<td id='model-box'>" + tablaStorage.getValueAt(i, 3) + "</td>");
                            out.println("<td><button class='modify-btn btn-styles' value='" + "'>MODIFICAR</button></td>");
                            out.println("<td><button class='delete-btn btn-styles' value='" + "'>ELIMINAR</button></td></tr>");
                        }
                    } catch (Exception ex) {
                        out.println("Unable to connect to database.");
                    }

                %>
            </table>

        </div>            
    </body>
</html>