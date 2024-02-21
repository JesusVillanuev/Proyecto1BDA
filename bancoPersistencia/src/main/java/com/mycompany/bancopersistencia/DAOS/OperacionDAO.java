/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancopersistencia.DTOS.TransferenciaDTO;
import com.mycompany.bancopersistencia.DTOS.RetiroDTO;
import com.mycompany.bancopersistencia.DTOS.OperacionDTO;
import com.mycompany.bancodominio.clasesPojo.Operacion;
import com.mycompany.bancodominio.clasesPojo.Retiro;
import com.mycompany.bancodominio.clasesPojo.Transeferencia;
import com.mycompany.bancopersistencia.DAOS.IOperacionDAO;
import com.mycompany.bancopersistencia.Conexion.IConexioBD;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JESUS
 */
public class OperacionDAO implements IOperacionDAO{
    IConexioBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    public OperacionDAO(IConexioBD conexion){
        this.conexionBD=conexion;
    }

    @Override
    public Operacion transferencia(CuentaDTO cuenta, int numeroDirigido) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Operacion> listaOperaciones(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Operacion generarRetiro(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Operacion realizarRetiro(int folio, int contraseña) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Operacion depositar(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
