/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author JESUS
 */
public class OperacionDTO {
    //Atributos de la clase
    private int idOperacion;
    private String tipo;
    private String fechaHora;
    private float monto;
    private int idCuenta;

    /**
     * Constructor por omision
     */
    public OperacionDTO() {
    }

    /**
     * Constructor sin id de la operacion
     * @param tipo tipo de operacion
     * @param fechaHora fecha y hora de la operacion
     * @param monto monto de la operacion
     * @param idCuenta id de la cuenta que se realiza la operacion
     */
    public OperacionDTO(String tipo, String fechaHora, float monto, int idCuenta) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    /**
     * Contructor con todos los datos del cliente
     * @param idOperacion identificador de la operacion
     * @param tipo tipo de operacion
     * @param fechaHora fecha y hora de la operacion
     * @param monto monto de la operacion
     * @param idCuenta id de la cuenta que se realiza la operacion
     */
    public OperacionDTO(int idOperacion, String tipo, String fechaHora, float monto, int idCuenta) {
        this.idOperacion = idOperacion;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    /**
     * Metodo regresa el id de la operacion
     * @return regresa el identificador
     */
    public int getIdOperacion() {
        return idOperacion;
    }
    
    /**
     * Metodo que asigna el id de la operacion
     * @param idOperacion id de la operacion
     */
    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    /**
     * Metodo que regresa el tipo operacion
     * @return regresa el tipo 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que asigna el tipo de operacion
     * @param tipo tipo de operacion
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que regresa la fecha y hora de la operacion
     * @return regresa la fecha y hora
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Metodo que asigna la fecha y hora de la operacion
     * @param fechaHora fecha y hora de la operacion
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Metodo que regresa el monto de la operacion
     * @return regresa el monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Metodo que asgina el monto de la operacion
     * @param monto monto a asignar
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Metodo que regresa el id de la cuenta que realizo la operacion
     * @return id de cuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Metodo que asignar el id de la cuenta que realiza la operacion
     * @param idCuenta id de cuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Metodo que imprime todos los datos de la operacion
     * @return regresa todos los datos
     */
    @Override
    public String toString() {
        return "Operacion{" + "idOperacion=" + idOperacion + ", tipo=" + tipo + ", fechaHora=" + fechaHora + ", monto=" + monto + ", idCuenta=" + idCuenta + '}';
    }
}
