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
    private String observaciones; 

    public Material(int id, String codigo, String nombre, String descripcion, int cantidad, String ubicacion, String observaciones) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.observaciones = observaciones;
    }
    


    //getters y setters

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    }
