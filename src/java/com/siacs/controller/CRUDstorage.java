package com.siacs.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import com.siacs.model.conexionDB;
import java.io.IOException;
import java.sql.SQLException;
import com.siacs.model.conexionDB;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpsigcho
 */
public class CRUDstorage {

    public CRUDstorage() {
    }
    
    public DefaultTableModel tableStorage(ResultSet rs) {
        DefaultTableModel tableModel = new DefaultTableModel();
        try {            
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
        } catch (Exception ex) {
            System.out.println("Unable to populate to storage.");
        }
        return tableModel;
    }

    
    /*
        Método para conectarse a la DB y extraer la data sobre los inventarios
    */
//    public DefaultTableModel conecctiondata(String tablaconsultar) {
//        ResultSet rs = null;
//        DefaultTableModel dataStor = new DefaultTableModel();
//        try {
//            Connection connection = null;
//            conexionDB conexionClass = new conexionDB("jdbc:mysql://localhost:3306/siacs", "root", "admin");
//            connection = conexionClass.enlaceDB(connection);
//            if (!connection.isClosed()) {
//                System.out.println("<h3>BD cargada</h3>");
//            }            
//            Statement Estamento = connection.createStatement();
//            if(!tablaconsultar.isEmpty()){
//                rs = Estamento.executeQuery("select * from " + tablaconsultar);
//            }else{
//                rs = Estamento.executeQuery("select * from producto");
//            }
//            rs = Estamento.executeQuery("select * from producto");
//            if(rs.next())
//                dataStor = tableStorage(rs);
//            connection.close();
//        } catch (SQLException|IllegalArgumentException | SecurityException exception) {
//            System.out.println("Unable to connect to database.");
//            System.out.println("Error: " + exception);            
//        }
//        return dataStor;        
//    }
//    
    /*
        Método para obtener los datos del usuario
    */
    public DefaultTableModel usuario(){
        DefaultTableModel tablaUsuario = new DefaultTableModel();
//        tablaUsuario.addColumn("Id", );
//        tablaUsuario.addColumn("nombre");
//        tablaUsuario.addRow("");
        return tablaUsuario;
    } 
    
}
