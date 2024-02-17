/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author JESUS
 */
public interface IConexioBD {
     /**
     * Metodo Conexion de la BD
     * @return conexion
     * @throws SQLException excepcion
     */
     public Connection crearConexion () throws SQLException;
    
}
