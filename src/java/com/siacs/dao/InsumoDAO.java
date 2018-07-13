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
    private String tablaInsumos = "insumoinv";

    public InsumoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(jdbcPassword);
        con = new conexionDB(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Integer obtenerIndex() throws SQLException {
        Integer indexsiguiente = 1;
        String sql= "Select max(id)+1 from " +tablaInsumos;
        con.conectar();
        connection = con.getjdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        if (resulSet.next()) {
            if (resulSet.getInt(1) > 0) {
                indexsiguiente = resulSet.getInt(1);
            }
        }
        return indexsiguiente;

    }

    // listar todos los productos
    public List<Insumo> listarInsumos() throws SQLException {

        List<Insumo> listaInsumos = new ArrayList<Insumo>();
        String sql = "SELECT * FROM " + tablaInsumos;
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

    // insertar insumo en la tabla de insumos
    public boolean insertar(Insumo insumo) throws SQLException {
        String sql = "INSERT INTO " + tablaInsumos + " (id, codigo, nombre, descripcion, cantidad, ubicacion, "
                + "observaciones)" + " VALUES (?, ?, ?,?,?,?,?)";
        System.out.println(insumo.getDescripcion());
        con.conectar();
        connection = con.getjdbcConnection();
        boolean rowInserted;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, insumo.getId());
            statement.setString(2, insumo.getCodigo());
            statement.setString(3, insumo.getNombre());
            statement.setString(4, insumo.getDescripcion());
            statement.setInt(5, insumo.getCantidad());
            statement.setString(6, insumo.getUbicacion());
            statement.setString(7, insumo.getObservaciones());
            rowInserted = statement.executeUpdate() > 0;
        }
        con.desconectar();
        return rowInserted;
    }

    // obtener por id
    public Insumo obtenerPorId(int id) throws SQLException {
        Insumo insumo = null;

        String sql = "SELECT * FROM " + tablaInsumos + " WHERE id= ? ";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            insumo = new Insumo(res.getInt("id"), res.getString("codigo"), res.getString("nombre"),
                    res.getString("descripcion"), res.getInt("cantidad"), res.getString("ubicacion"),
                    res.getString("observaciones"));
        }
        res.close();
        con.desconectar();

        return insumo;
    }

    // actualizar
    public boolean actualizar(Insumo insumo) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE " + tablaInsumos + " SET nombre=?,descripcion=?,cantidad=?, ubicacion=?, observaciones=? "
                + "WHERE id=?";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, insumo.getNombre());
        statement.setString(2, insumo.getDescripcion());
        statement.setInt(3, insumo.getCantidad());
        statement.setString(4, insumo.getUbicacion());
        statement.setString(5, insumo.getObservaciones());
        statement.setInt(6, insumo.getId());

        rowActualizar = statement.executeUpdate() > 0;
        System.out.println(statement.toString());
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    //eliminar
    public boolean eliminar(Insumo insumo) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM " + tablaInsumos + " WHERE ID=?";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, insumo.getId());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();

        return rowEliminar;
    }

}
