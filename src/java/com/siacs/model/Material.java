package com.siacs.model;

/*
 * @autor: Elivar Largo
 * @ web: www.ecodeup.com 
 */
public class Material {

    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String ubicacion;
    private int numerousos;    
    private int disponibilidad; 
    private String funcionalidad;
    private String observaciones;
    
    
    //constructor del método
    public Material(int id, String codigo, String nombre, String descripcion, int cantidad, String ubicacion, 
            int numerousos, int disponibilidad, String funcionalidad, String observaciones) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.numerousos = numerousos;
        this.disponibilidad = disponibilidad;
        this.funcionalidad = funcionalidad;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumerousos() {
        return numerousos;
    }

    public void setNumerousos(int numerousos) {
        this.numerousos = numerousos;
    }
    
    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
