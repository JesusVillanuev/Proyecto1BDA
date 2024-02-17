/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio.clasesPojo;

/**
 *
 * @author JESUS
 */
public class Transeferencia {
    //Atributos de la clase
    private int idOperacion;

    /**
     * Contructor por omision
     */
    public Transeferencia() {
    }

    /**
     * Constructor con id de la operacion
     * @param idOperacion 
     */
    public Transeferencia(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    /**
     * Metodo que regresa id de la transferencia
     * @return regresa el id
     */
    public int getIdOperacion() {
        return idOperacion;
    }

    /**
     * Metodo que asigna el id de la transferencia
     * @param idOperacion identificador de la transferencia
     */
    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }
}
