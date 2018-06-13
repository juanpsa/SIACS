<%@ page import="java.sql.*,controllerJava.conexionDB" %>
<%@ page import="java.io.*,controllerJava.CRUDstorage,javax.swing.table.DefaultTableModel" %>

<%
    HttpSession objSesion = request.getSession(false);
    String usuario = (String) objSesion.getAttribute("usuario");
    out.println("Usuario en sesion: " + usuario);
%>

<html>
    <head>
        <!--<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">-->
        <link rel="stylesheet" type="text/css" href="../css/stylesmain.css">
        <script type="text/javascript">

            function changeFunc() {
                var selectBox = document.getElementById("selectBox");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                alert(selectedValue);
            }

        </script>
        <title>Inventario</title>
    </head>
    <body>
        <h1>Inventario</h1>
        <form action="connection.jsp">
            <div id="navbar">
                <span>Nuevo</span>            
                <input id="marca" type="text" placeholder="Id" maxlength="30">
                <input id="modelo" type="text" placeholder="Nombre" maxlength="30">
                <input id="conect" type="text" placeholder="Apellido" maxlength="30">
                <input id="tipo" type="text" placeholder="ROL" maxlength="30">            
                <button class="add-btn btn-styles" >AÑADIR</button>                
            </div>
        </form>
        <div id="body">
            <select id="selectBox" onchange="changeFunc();">
                <option onselect="" value="Insumo">Insumo</option>
                <option value="Materiales">Materiales</option>
            </select>
            <table border="0" >                                
                <%
                    CRUDstorage neo = new CRUDstorage();
                    try {
                        DefaultTableModel tablaStorage = new DefaultTableModel();
                        tablaStorage = neo.conecctiondata();
                        if (tablaStorage.getRowCount() > 0) {
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
                        } else {
                            out.println("<h3>LA TABLA NO TIENE REGISTROS</h3>");
                        }
                    } catch (Exception ex) {
                        out.println("Unable to connect to database.");
                    }

                %>
            </table>
            <footer>Copyright &copy; W3Schools.com</footer>
        </div>            
    </body>
</html>