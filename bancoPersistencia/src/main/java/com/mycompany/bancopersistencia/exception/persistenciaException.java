/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.exception;

/**
 *
 * @author JESUS
 */
public class persistenciaException extends Exception{

    public persistenciaException() {
    }

    public persistenciaException(String string) {
        super(string);
    }

    public persistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public persistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    public persistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
