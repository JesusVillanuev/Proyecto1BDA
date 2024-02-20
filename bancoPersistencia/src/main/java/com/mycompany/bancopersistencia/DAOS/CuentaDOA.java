/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;

import com.mycompany.bancodominio.clasesPojo.Cuenta;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import com.mycompany.bancopersistencia.Conexion.IConexioBD;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JESUS
 */
public class CuentaDOA implements ICuentaDAO{
    IConexioBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    /**
     * 
     * @param conexion 
     */
    public CuentaDOA(IConexioBD conexion) {
        this.conexionBD=conexion;
    }

    /**
     * 
     * @param cuenta
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cuenta crearCuenta(ClienteDTO cliente) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * 
     * @param cuenta
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cuenta cancelarCuenta(CuentaDTO cuenta) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> consultarCuentas(int id) throws persistenciaException {
        String consulta = "SELECT * FROM cuentas WHERE id_cliente = (?)";
        List<Cuenta> listaCuentas=new ArrayList<>();
        
        try(Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(consulta);) {
            comandoSQL.setInt(1, id);
            ResultSet resultado = comandoSQL.executeQuery();
            
            resultado.next();
            
            while(resultado.next()){
                int numero=resultado.getShort("numero_cuenta");
                String estado=resultado.getString("estado");
                String fecha=resultado.getDate("fecha_apertura").toString();
                float saldo=resultado.getFloat("saldo");
                Cuenta cuentaNu=new Cuenta();
                cuentaNu.setNumeroCuenta(numero);
                cuentaNu.setEstado(estado);
                cuentaNu.setFechaApertura(fecha);
                cuentaNu.setSaldo(saldo);
                listaCuentas.add(cuentaNu);
            }
            LOG.log(Level.INFO, "Se consultaron {0} cuentas", listaCuentas.size());
            return listaCuentas;
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Fallo al enviar la lista" , e);
            throw new persistenciaException("Fallo", e);
        }
    }
    
    
    
    
}
