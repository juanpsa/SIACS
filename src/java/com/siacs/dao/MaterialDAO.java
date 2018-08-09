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

import com.siacs.model.Material;
import com.siacs.model.conexionDB;
import java.sql.PreparedStatement;

/**
 *
 * @author mdcarrion7
 */
public class MaterialDAO {

    private conexionDB con;
    private Connection connection;
    private String tablaMateriales = "materialinv";

    public MaterialDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        System.out.println(jdbcUsername);
        System.out.println(jdbcPassword);
        con = new conexionDB(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Integer obtenerIndex() throws SQLException {
        Integer indexsiguiente = 1;
        String sql = "Select max(id)+1 from " + tablaMateriales;
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
    public List<Material> listarMateriales() throws SQLException {

        List<Material> listaMateriales = new ArrayList<Material>();
        String sql = "SELECT * FROM " + tablaMateriales;
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
            int numerousos = resulSet.getInt("numerousos");
            int disponibilidad = resulSet.getInt("disponibilidad");
            String funcionalidad = resulSet.getString("funcionalidad");
            String observaciones = resulSet.getString("observaciones");
            Material material = new Material(id, codigo, nombre, descripcion, cantidad, ubicacion, numerousos,
                    disponibilidad, funcionalidad, observaciones);
            listaMateriales.add(material);
        }
        con.desconectar();
        return listaMateriales;
    }

    // insertar material en la tabla de materiales
    public boolean insertar(Material material) throws SQLException {
        String sql = "INSERT INTO " + tablaMateriales + " (id, codigo, nombre, descripcion, cantidad, ubicacion, "
                + "numerousos, disponibilidad, funcionalidad, observaciones)" + " VALUES (?,?,?,?,?,?,?,?,?)";
        con.conectar();
        connection = con.getjdbcConnection();
        boolean rowInserted;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, material.getId());
            statement.setString(2, material.getCodigo());
            statement.setString(3, material.getNombre());
            statement.setString(4, material.getDescripcion());
            statement.setInt(5, material.getCantidad());
            statement.setString(6, material.getUbicacion());
            statement.setInt(7, material.getNumerousos());
            statement.setInt(8, material.getDisponibilidad());
            statement.setString(9, material.getFuncionalidad());
            statement.setString(10, material.getObservaciones());
            rowInserted = statement.executeUpdate() > 0;
        }
        con.desconectar();
        return rowInserted;
    }

    // obtener por id
    public Material obtenerPorId(int id) throws SQLException {
        Material material = null;

        String sql = "SELECT * FROM " + tablaMateriales + " WHERE id= ? ";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            material = new Material(res.getInt("id"), res.getString("codigo"), res.getString("nombre"),
                    res.getString("descripcion"), res.getInt("cantidad"), res.getString("ubicacion"),
                    res.getInt("numerousos"), res.getInt("disponibilidad"), res.getString("funcionalidad"),
                    res.getString("observaciones"));
        }
        res.close();
        con.desconectar();

        return material;
    }

    // actualizar
    public boolean actualizar(Material material) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE " + tablaMateriales + " SET nombre=?,descripcion=?,cantidad=?, ubicacion=?, observaciones=? "
                + "WHERE id=?";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, material.getNombre());
        statement.setString(2, material.getDescripcion());
        statement.setInt(3, material.getCantidad());
        statement.setString(4, material.getUbicacion());
        statement.setString(5, material.getObservaciones());
        statement.setInt(6, material.getId());

        rowActualizar = statement.executeUpdate() > 0;
        System.out.println(statement.toString());
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    //eliminar
    public boolean eliminar(Material material) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM " + tablaMateriales + " WHERE ID=?";
        con.conectar();
        connection = con.getjdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, material.getId());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();

        return rowEliminar;
    }

}
