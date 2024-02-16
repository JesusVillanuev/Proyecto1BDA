/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.exception.persistenciaException;
import com.mycompany.bancopersistencia.Conexion.IConexionBD;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JESUS
 */
public class ClienteDAO implements IClienteDAO{
    
    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    public ClienteDAO(IConexionBD conexion){
        this.conexionBD=conexion;
    }
    
    @Override
    public Cliente registraCliente(ClienteDTO cliente)throws persistenciaException{
        try(Connection co=this.c) {
           
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente editarCliente(ClienteDTO cliente)throws persistenciaException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
