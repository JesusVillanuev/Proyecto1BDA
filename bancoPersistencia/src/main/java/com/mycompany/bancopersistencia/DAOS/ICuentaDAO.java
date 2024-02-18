/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancodominio.clasesPojo.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.exception.PersistenciaException;
 
/**
 *
 * @author JESUS
 */
public interface ICuentaDAO {
    public Cuenta crearCuenta() throws PersistenciaException;
    public Cuenta cancelarCuenta(CuentaDTO cuenta) throws PersistenciaException;
    
    
}
