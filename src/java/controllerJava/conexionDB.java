/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerJava;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import modelSIACS.dataStorage;

/**
 *
 * @author jpsigcho
 */
public class conexionDB {

    protected String connectionURL = "jdbc:mysql://localhost:3306/prueba";
    protected String driver = "com.mysql.jdbc.Driver";
    protected String usuarioDB = "root";
    protected String passDB = "admin";

    public conexionDB() {
    }

    /*
        Método para establecer la conexión a la DB. 
        Parámetros: 
                    * DBlink ->   objeto de tipo Connection que se ejecuta en la clase que va a 
                                establecer la conexión y consulta contra la BD. 
     */
    protected Connection enlaceDB(Connection DBlink) {
        try {
            Class.forName(driver).newInstance();
            DBlink = DriverManager.getConnection(connectionURL, usuarioDB, passDB);
            if (!DBlink.isClosed()) {
                System.out.println("<h3>BD cargada</h3>");
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return DBlink;
    }

    /*
        Método para almacenar en una tabla de datos el ResultSet obtenido a partir de una consulta a la DB
        Parámetros: 
                    * rs -> es el ResultSet obtenido de la consulta a la Base de datos.
     */
    public DefaultTableModel tableStorage(ResultSet rs) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            if (rs.next()) {
                //Retrieve meta data from ResultSet
                ResultSetMetaData metaData = rs.getMetaData();
                //Get number of columns from meta data
                int columnCount = metaData.getColumnCount();
                //Get all column names from meta data and add columns to table model
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    tableModel.addColumn(metaData.getColumnLabel(columnIndex));
                }
                //Create array of Objects with size of column count from meta data
                Object[] row = new Object[columnCount];
                //Scroll through result set
                while (rs.next()) {
                    //Get object from column with specific index of result set to array of objects
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    //Now add row to table model with that array of objects as an argument
                    tableModel.addRow(row);
                }
                //Now add that table model to your table and you are done :D
            }
        } catch (Exception ex) {
            System.out.println("Unable to populate to storage.");
        }
        return tableModel;
    }

    /*
        Método para conectarse a la DB y extraer la 
     */
    public DefaultTableModel conecctiondata() {
        ResultSet rs = null;
        DefaultTableModel dataStor = new DefaultTableModel();
        try {
            //String connectionURL = "jdbc:mysql://localhost:3306/prueba";
            Connection connection = null;
            connection = enlaceDB(connection);
            Statement Estamento = connection.createStatement();
            rs = Estamento.executeQuery("select * from producto");
            dataStor = tableStorage(rs);
            connection.close();
        } catch (Exception ex) {
            System.out.println("Unable to connect to database.");
        }
        return dataStor;

    }
}
