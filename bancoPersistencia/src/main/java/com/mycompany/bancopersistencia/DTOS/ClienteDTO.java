/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author JESUS
 */
public class ClienteDTO {
    //Atributos de la clase
    private int idCliente;
    private String usario;
    private String contraseña;
    private String fechaNacimiento; // "2020-2-2"
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String domicilio;
    
    /**
     * Constructor por omision
     */
    public ClienteDTO(){
        
    }
    
    /**
     * Contructor sin id de cliente
     * @param usario usuario del cliente
     * @param contraseña contraseña del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param nombres nombres del cliente
     * @param apellido_paterno apellido paterno del cliente
     * @param apellido_materno apellido materno del cliente
     * @param domicilio domicilio del cliente
     */
    public ClienteDTO(String usario, String contraseña, String fechaNacimiento, String nombres, String apellido_paterno, String apellido_materno, String domicilio) {
        this.usario = usario;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.domicilio = domicilio;
    }
    
    /**
     * Metodo que regresa el id cliente
     * @return id cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo que envie el id cliente
     * @param idCliente el id del cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metodo que regresa el cliente
     * @return el usuario del cliente
     */
    public String getUsario() {
        return usario;
    }

    /**
     * Metodo que asigna un usuario de cliente
     * @param usario usario del cliente
     */
    public void setUsario(String usario) {
        this.usario = usario;
    }

    /**
     * Metodo que regresa la contraseña del cliente
     * @return regresa la contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Metodo asigna la contraseña de un cliente
     * @param contraseña contraseña a asignar
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo que regresa la fecha de nacimiento
     * @return regresa la fecha de nacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo que asigna la fecha de nacimiento
     * @param fechaNacimiento fecha de nacimiento a asignar
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo que regresa el nombre del cliente
     * @return regresa el nombre del cliente
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Metodo que asigna el nombre del cliente
     * @param nombres nombres a asignar
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Metodo que regresa el apellido parterno del cliente
     * @return regresa el apellido paterno
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Metodo que asgina el appellido paterno del cliente
     * @param apellido_paterno apellido paterno del cliente
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Metodo que regresa el apellido materno del cliente
     * @return regresa el apellido materno
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Metodo asigna el apellido materno del cliente
     * @param apellido_materno apellido materno del cliente
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Metodo que regresa el domicilio del cliente
     * @return regresa el domicilio del cliente
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Metodo que asgina el domicilio del cliente
     * @param domicilio domicilio del cliente
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Metodo que muestra todo los datos del cliente
     * @return datos del cliente
     */
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", usario=" + usario + ", contrase\u00f1a=" + contraseña + ", fechaNacimiento=" + fechaNacimiento + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", domicilio=" + domicilio + '}';
    }
}
