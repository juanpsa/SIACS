/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siacs.model;

/**
 *
 * @author mdcarrion7
 */
public class sesiondata {
    
    private int id;    
    private String nombres;
    private String apellidos;    
    private String rol;
    private String email;
    private String username;
    private int idInvInsumo;
    private int idInvMaterial;

    public sesiondata(int id, String nombres, String apellidos, String rol, String email, String username, int idInvInsumo, int idInvMaterial) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.email = email;
        this.username = username;
        this.idInvInsumo = idInvInsumo;
        this.idInvMaterial = idInvMaterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdInvInsumo() {
        return idInvInsumo;
    }

    public void setIdInvInsumo(int idInvInsumo) {
        this.idInvInsumo = idInvInsumo;
    }

    public int getIdInvMaterial() {
        return idInvMaterial;
    }

    public void setIdInvMaterial(int idInvMaterial) {
        this.idInvMaterial = idInvMaterial;
    }
    

}
