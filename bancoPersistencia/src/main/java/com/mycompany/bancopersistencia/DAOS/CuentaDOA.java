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
    public void crearCuenta(ClienteDTO cliente) throws persistenciaException {
        
        try(Connection con=this.conexionBD.crearConexion();
            CallableStatement conn=(CallableStatement)con.prepareCall("{call sp_crearCuenta(?)}"))  {
            conn.setInt(1, cliente.getIdCliente());
           
            conn.executeUpdate();

        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Fallo al crear cuenta" , e);
            throw new persistenciaException("Fallo", e);
        }
    }
    
    /**
     * 
     * @param cuenta
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public void cancelarCuenta(CuentaDTO cuenta) throws persistenciaException {
        String comandoS = "UPDATE cuentas SET estado = 'cancelada' WHERE id_cuenta = ?";
        try(Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(comandoS);) {
            
            comandoSQL.setInt(1, cuenta.getIdCuenta());
            int filasActualizadas = comandoSQL.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("La cuenta con el id " + cuenta.getIdCuenta() + " ha sido cancelada con éxito.");
            } else {
                System.out.println("No se encontró ninguna cuenta con el id " + cuenta.getIdCuenta());
            }
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Fallo al cancelar cuenta" , e);
            throw new persistenciaException("Fallo", e);
        }
    }

    @Override
    public List<Cuenta> consultarCuentas(int id) throws persistenciaException {
        String consulta = "SELECT * FROM cuentas WHERE id_cliente = ?";
        List<Cuenta> listaCuentas = new ArrayList<>();

        try (Connection conexion = this.conexionBD.crearConexion();
             PreparedStatement comandoSQL = conexion.prepareStatement(consulta)) {
            comandoSQL.setInt(1, id);
            try (ResultSet resultado = comandoSQL.executeQuery()) {
                while (resultado.next()) {
                    int idC= resultado.getInt("id_cuenta");
                    int numero = resultado.getInt("numero_cuenta");
                    String estado = resultado.getString("estado");
                    String fecha = resultado.getDate("fecha_apertura").toString();
                    float saldo = resultado.getFloat("saldo");
                    Cuenta cuentaNu = new Cuenta();
                    cuentaNu.setIdCuenta(idC);
                    cuentaNu.setNumeroCuenta(numero);
                    cuentaNu.setEstado(estado);
                    cuentaNu.setFechaApertura(fecha);
                    cuentaNu.setSaldo(saldo);
                    listaCuentas.add(cuentaNu);
                }
            }
        LOG.log(Level.INFO, "Se consultaron {0} cuentas", listaCuentas.size());
        return listaCuentas;
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"Fallo al enviar la lista" , e);
            throw new persistenciaException("Fallo", e);
        }
    }
    
    
    
    
}
