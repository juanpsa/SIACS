<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,controllerJava.conexionDB" %>


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
                <button class="add-btn btn-styles" onclick="viewSIACS/reports.jsp">AÑADIR</button>
                <%
                    conexionDB neo  = new conexionDB();                    
                    out.println("<h3>"+neo.fImpr()+"</h3>");
                %>
            </div>
        </form>
        <div id="body">
            
            <table border="0" >                                
                <%
                    try {                        
                        String connectionURL = "jdbc:mysql://localhost:3306/prueba";
                        Connection connection = null;
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        connection = DriverManager.getConnection(connectionURL, "root", "admin");
                       
                        if (!connection.isClosed()) {
                            out.println("<h3>BD cargada</h3>");
                        }
                        
                        Statement Estamento = connection.createStatement();
                        ResultSet rs = Estamento.executeQuery("select * from producto");
                        //out.println(rs.first());                                                    
                        while (rs.next()) {
                            out.println("<tr><td id='id-box'>" + rs.getInt(1) + "</td>");
                            out.println("<td id='marca  -box'>" + rs.getString(2) + "</td>");
                            out.println("<td id='cntd-box' align='center'>" + rs.getInt(3) + "</td>");
                            out.println("<td id='model-box'>" + rs.getString(4) + "</td>");
                            out.println("<td><button class='modify-btn btn-styles' value='" + rs.getInt(1) + "'>MODIFICAR</button></td>");
                            out.println("<td><button class='delete-btn btn-styles' value='" + rs.getInt(1) + "'>ELIMINAR</button></td></tr>");
                        }
                        connection.close();
                    } catch (Exception ex) {
                        out.println("Unable to connect to database.");
                    }

                %>
            </table>

        </div>            
    </body>
</html>