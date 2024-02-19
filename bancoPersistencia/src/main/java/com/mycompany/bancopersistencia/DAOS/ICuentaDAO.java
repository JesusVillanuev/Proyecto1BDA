/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancodominio.clasesPojo.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
 
/**
 *
 * @author JESUS
 */
public interface ICuentaDAO {
    public Cuenta crearCuenta(CuentaDTO cuenta) throws persistenciaException;
    public Cuenta cancelarCuenta(CuentaDTO cuenta) throws persistenciaException;
    
    
}
