/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancodominio.Cuenta;
import com.mycompany.banconegocio.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.exception.persistenciaException;
import com.mycompany.bancopersistencia.Conexion.IConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JESUS
 */
public class CuentaDAO implements ICuentaDAO{

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());
    
    public CuentaDAO(IConexionBD conexion){
        this.conexionBD=conexion;
    }
    
    @Override
    public Cuenta crearCuenta(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta cancelarCuenta(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void MostrarTablaCuentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
