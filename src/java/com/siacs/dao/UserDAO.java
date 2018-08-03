/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.dao;

/**
 *
 * @author jpsigcho
 */
import java.sql.*;
import com.siacs.model.conexionDB;
import java.sql.PreparedStatement;
import com.siacs.model.User;
 
public class UserDAO {    
    private conexionDB con;
    private Connection connection;
    private String tablaUsusarios = "usuarioinv";

    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(jdbcPassword);
        con = new conexionDB(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    //Metodo para consultar si un email y contraseñan pertenecen a una cuenta registrada
    public boolean isAcountExists(String email, String password) throws SQLException{
        String sql = "SELECT * FROM "+ tablaUsusarios+" WHERE email='"+email.trim()
                +"' AND password='"+password.trim()+"'";
        con.conectar();
        connection = con.getjdbcConnection();        
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);        
        return resulSet.next();
    }
    
    public String getUsernameByEmail(String email) throws SQLException{
        String sql = "SELECT * FROM "+ tablaUsusarios+" WHERE email='"+email+"'";
        con.conectar();
        connection = con.getjdbcConnection();        
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        if(resulSet.next()){
            return resulSet.getString("username");
        }        
        return null;
    }
    
    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String email) throws SQLException{
        String sql =  "SELECT * FROM "+ tablaUsusarios+" WHERE email='"+email+"'";
        con.conectar();
        connection = con.getjdbcConnection();        
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);        
        return resulSet.next();
    }
    
    //Metodo para registrar una cuenta
    public boolean insertar(User usuario) throws SQLException{
        String sql = "INSERT INTO " + tablaUsusarios + " (identificador, nombres, apellidos, rol, email, "
                + "username, password, observaciones)" + " VALUES (?, ?, ?,?,?,?,?)";
        con.conectar();
        connection = con.getjdbcConnection();
        boolean rowInserted;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuario.getIdentificador());
            statement.setString(2, usuario.getNombres());
            statement.setString(3, usuario.getApellidos());
            statement.setString(4, usuario.getRol());
            statement.setString(5, usuario.getEmail().toString());
            statement.setString(6, usuario.getUsername());
            statement.setString(7, usuario.getObservaciones());
            rowInserted = statement.executeUpdate() > 0;
        }
        con.desconectar();
        return rowInserted;        
    }    
}