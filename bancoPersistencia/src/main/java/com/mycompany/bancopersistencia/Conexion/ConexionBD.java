/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JESUS
 */
public class ConexionBD implements IConexioBD{
    //Declaracion de Variables de la Clase Conexion 
    final private String cadenaConexion;
    final private String usuario;
    final private String contra;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    public ConexionBD(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }
    
    

    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexión exitosa ", cadenaConexion);
        return conexion;   
    }
}
