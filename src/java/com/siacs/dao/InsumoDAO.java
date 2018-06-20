/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siacs.model.Insumo;
import com.siacs.model.conexionDB;
import java.sql.PreparedStatement;

/**
 *
 * @author mdcarrion7
 */
public class InsumoDAO {

    private conexionDB con;
    private Connection connection;

    public InsumoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(jdbcPassword);
        con = new conexionDB(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insertar insumo en la tabla de insumos
    public boolean insertar(Insumo insumo) throws SQLException {
        String sql = "INSERT INTO articulos (id, codigo, nombre, descripcion, cantidad, ubicacion, "
                + "observaciones)" + " VALUES (?, ?, ?,?,?,?,?)";
        System.out.println(insumo.getDescripcion());
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, insumo.getId());
        statement.setString(2, insumo.getCodigo());
        statement.setString(3, insumo.getNombre());
        statement.setString(4, insumo.getDescripcion());
        statement.setInt(5, insumo.getCantidad());
        statement.setString(6, insumo.getUbicacion());
        statement.setString(7, insumo.getObservaciones());        

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los productos
    public List<Insumo> listarInsumos() throws SQLException {

        List<Insumo> listaInsumos = new ArrayList<Insumo>();
        String sql = "SELECT * FROM insumoinv";
        con.conectar();
        connection = con.getjdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        System.out.println("retornado");                
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            String codigo = resulSet.getString("codigo");
            String nombre = resulSet.getString("nombre");
            String descripcion = resulSet.getString("descripcion");
            int cantidad = resulSet.getInt("cantidad");
            String ubicacion = resulSet.getString("ubicacion");
            String observaciones = resulSet.getString("observaciones");
            Insumo insumo = new Insumo(id, codigo, nombre, descripcion, cantidad, ubicacion, observaciones);
            listaInsumos.add(insumo);
        }
        con.desconectar();
        return listaInsumos;
    }
}
