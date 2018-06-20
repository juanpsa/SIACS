/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.model;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpsigcho
 */
public class conexionDB {

    private Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String jdbcUsername;
    private String jdbcPassword;

//    private Connection jdbcConnection;
//    private String jdbcURL;
//    private String jdbcUsername;
//    private String jdbcPassword;
    public conexionDB(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    /*
        Método para establecer la conexión a la DB.          
     */
    public void conectar() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName(jdbcDriver);
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public Connection getjdbcConnection() {
        return jdbcConnection;
    }

    
    
}
