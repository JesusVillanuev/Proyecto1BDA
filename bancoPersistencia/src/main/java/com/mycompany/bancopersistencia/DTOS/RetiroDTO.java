/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DTOS;

/**
 *
 * @author JESUS
 */
public class RetiroDTO {
    //Atributos de la clase
    private int idOperacion;
    private int folio;
    private int contraseña;
    private String fechaHoraLimite;
    private String estado;
    
    /**
     * Constructor por omision
     */
    public RetiroDTO(){
        
    }

    /**
     * Metodo constructor sin id
     * @param folio folio del retiro
     * @param contraseña contraseÃ±o del retiro
     * @param fechaHoraLimite fecha hora limite del retiro
     * @param estado estado del retiro
     */
    public RetiroDTO(int folio, int contraseña, String fechaHoraLimite, String estado) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.fechaHoraLimite = fechaHoraLimite;
        this.estado = estado;
    }

    /**
     * Metodo constructor con todos los datos
     * @param idOperacion identifiacodor del retiro
     * @param folio folio del retiro
     * @param contraseña contraseÃ±o del retiro
     * @param fechaHoraLimite fecha hora limite del retiro
     * @param estado estado del retiro
     */
    public RetiroDTO(int idOperacion, int folio, int contraseña, String fechaHoraLimite, String estado) {
        this.idOperacion = idOperacion;
        this.folio = folio;
        this.contraseña = contraseña;
        this.fechaHoraLimite = fechaHoraLimite;
        this.estado = estado;
    }

    /**
     * Metodo que regresa el id del retiro
     * @return regresa el id del retiro
     */
    public int getIdOperacion() {
        return idOperacion;
    }

    /**
     * Metodo que asigna el id del retiro
     * @param idOperacion identifiacador del retiro
     */
    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    /**
     * Metodo que regresa el folio del retiro
     * @return regresa el folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Metodo que asigna el folio del retiro
     * @param folio folio del retiro
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Metodo que regresa la contraseÃ±a del retiro
     * @return regresa la contraseÃ±a
     */
    public int getContraseña() {
        return contraseña;
    }

    /**
     * Metodo que asigna la contraseÃ±a
     * @param contraseÃ±a 
     */
    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo que regresa la fecha y hora limite del retiro
     * @return regresa la fecha y hora limite
     */
    public String getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    /**
     * Metodo que asigna la fecha y hora limite
     * @param fechaHoraLimite fecha y hora limite
     */
    public void setFechaHoraLimite(String fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }

    /**
     * Metodo que regresa estado del retiro
     * @return regresa el estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metod que asigna el estado del retiro
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
