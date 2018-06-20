<%@ page import="java.sql.*,com.siacs.controller.CRUDstorage" %>
<%@ page import="java.io.*,javax.swing.table.DefaultTableModel" %>

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
        <%
            HttpSession objSesion = request.getSession(false);
            if (!((String) objSesion.getAttribute("usuario")).isEmpty()) {
                out.println("<h3>Administrador</h3>");
            } else {
                out.println("<h3>Usuario</h3>");
            }
        %>
        <form action="mostrar.jsp">
            <div id="dd">                
                <!-- <input id="codigo" type="text" placeholder="Codigo" maxlength="30">-->
                <input id="nombre" type="text" placeholder="Nombre" maxlength="30">
                <input id="descripcion" type="text" placeholder="Descripcion" maxlength="30">   
                <input id="cantidad" type="text" placeholder="Cantidad" maxlength="5">   
                <input id="ubicacion" type="text" placeholder="Ubicacion" maxlength="5">   
                <input id="observaciones" type="text" placeholder="Observaciones" maxlength="5">   
                <button class="add-btn btn-styles" >AÑADIR</button>                
            </div>
        </form>
        <div id="body">
            <select id="selectBox" onchange="changeFunc();">
                <option onselect="" value="Insumo">Insumo</option>
                <option value="Materiales">Materiales</option>
            </select>
            
            <table border="0" >                                
              <!--  <%
//                    CRUDstorage neo = new CRUDstorage();
//                    try {
//                        String consulta = "";
//                        if (request.getParameter("selectBox") != null && !request.getParameter("selectBox").isEmpty()) {
//                                consulta = request.getParameter("selectBox");                            
//                        }
//                        DefaultTableModel tablaStorage = new DefaultTableModel();
//                        tablaStorage = neo.conecctiondata(consulta);
//                        if (tablaStorage.getRowCount() > 0) {
//                            out.println("<table class=inventario border=1 align= left>");
//                            out.println("<tr>");
//                            for (int j = 0; j < tablaStorage.getColumnCount(); j++) {
//                                out.println("<th>" + tablaStorage.getColumnName(j) + "</th>");
//                                //<th>Nombre</th><th>Cantidad</th><th>Descripcion</th></tr>");
//                            }
//                            out.println("</tr>");
//                            //out.println("<tr><th>Id</th><th>Nombre</th><th>Cantidad</th><th>Descripcion</th></tr>");
//                            for (int i = 0; i < tablaStorage.getRowCount(); i++) {
//                                out.println("<tr><td id='id-box'>" + tablaStorage.getValueAt(i, 0) + "</td>");
//                                out.println("<td id='marca  -box'>" + tablaStorage.getValueAt(i, 1) + "</td>");
//                                out.println("<td id='cntd-box' align='center'>" + tablaStorage.getValueAt(i, 2) + "</td>");
//                                out.println("<td id='model-box'>" + tablaStorage.getValueAt(i, 3) + "</td>");
//                                out.println("<td><button class='modify-btn btn-styles' value='" + "'>MODIFICAR</button></td>");
//                                out.println("<td><button class='delete-btn btn-styles' value='" + "'>ELIMINAR</button></td></tr>");
//                            }
//                        } else {
//                            out.println("<h3>LA TABLA NO TIENE REGISTROS</h3>");
//                        }
//                    } catch (Exception ex) {
//                        out.println("Unable to connect to database.");
//                    }

                %>-->
            </table>
            
            <footer>Copyright &copy; W3Schools.com</footer>
        </div>            
    </body>
</html>