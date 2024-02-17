/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

/**
 *
 * @author JESUS
 */
public class Cuenta {
    //Atributos de cuenta
    private int idCuenta;
    private int numeroCuenta;
    private String estado;
    private String fechaApertura;
    private float saldo;
    private int idCliente;

    /**
     * Constructor por omision
     */
    public Cuenta() {
    }

    /**
     * Contructor sin id
     * @param numeroCuenta numero de cuenta
     * @param estado estado de la cuenta
     * @param fechaApertura fecha de apertura de la cuenta
     * @param saldo saldo de la cuenta
     * @param idCliente id del cliente que le pertenece la cuenta
     */
    public Cuenta(int numeroCuenta, String estado, String fechaApertura, float saldo, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }
    
    /**
     * Constructor con todos los datos
     * @param idCuenta id de la cuenta
     * @param numeroCuenta numero de cuenta
     * @param estado estado de la cuenta
     * @param fechaApertura fecha de apertura de la cuenta
     * @param saldo saldo de la cuenta
     * @param idCliente id del cliente que le pertenece la cuenta
     */
    public Cuenta(int idCuenta, int numeroCuenta, String estado, String fechaApertura, float saldo, int idCliente) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    /**
     * Metodo regresa el id de la cuenta
     * @return regresa el id
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Metodo que asigna el id de la cuenta
     * @param idCuenta id de la cuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Metodo que regresa el numero de la cuenta
     * @return regresa el numero de cuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Metodo asigna el numero de cuenta
     * @param numeroCuenta numero de cuenta
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Metodo que regresa el estado de la cuenta
     * @return regresa el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo asigna el estado de la cuenta
     * @param estado estado de cuenta
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que regresa la fecha de apertura de la cuenta
     * @return regresa la fecha
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Metodo que asigna la fecha de apertura de la cuenta
     * @param fechaApertura fecha de apertura
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Metodo que regresa el saldo de la cuenta
     * @return regresa el saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Metodo que asigna el saldo a la cuenta
     * @param saldo saldo de la cuenta
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo que regresa el id de cliente de la cuenta
     * @return regresa el id del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo que asigna el id del cliente a la cuenta
     * @param idCliente id del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metod que regresa todos los datos de la cuenta
     * @return regresa todos los datos
     */
    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", estado=" + estado + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }
}
