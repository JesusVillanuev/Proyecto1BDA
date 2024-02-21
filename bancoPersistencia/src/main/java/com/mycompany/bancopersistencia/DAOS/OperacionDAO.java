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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        String consulta = "SELECT * FROM operaciones WHERE id_cuenta = ?";
        List<Operacion> operaciones=new ArrayList<>();
        try(Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(consulta)) {
            comandoSQL.setInt(1, cuenta.getIdCuenta()); 
            
            try(ResultSet resultado = comandoSQL.executeQuery()) {
                while(resultado.next()){
                    
                    String tipo = resultado.getString("tipo");
                    float monto = resultado.getFloat("monto");
                    Timestamp timestamp = resultado.getTimestamp("fecha_hora");
                    String fecha=timestamp.toString();
                    Operacion operacion = new Operacion();
                    operacion.setTipo(tipo);
                    operacion.setFechaHora(fecha);
                    operacion.setMonto(monto);
                    operaciones.add(operacion);
                    
                }
            }
            LOG.log(Level.INFO, "Se encontraron {0} operaciones", operaciones.size());
            return operaciones;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al buscar operaciones", e);
            throw new persistenciaException("Error al buscar operaciones", e);
        }
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
    public Operacion depositar(CuentaDTO cuenta,float monto) throws persistenciaException {
         String consulta = "UPDATE cuentas SET saldo = saldo + ? WHERE id_cuenta = ?";
         try(Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(consulta)) {
            comandoSQL.setFloat(1, monto);
            comandoSQL.setInt(2, cuenta.getIdCuenta());
            
            int filasAfectadas = comandoSQL.executeUpdate();
            
                if (filasAfectadas==1) {
                    Operacion operacion = new Operacion();
                    operacion.setTipo("Depósito");
                    return operacion;
                }else{
                    throw new persistenciaException("No se pudo realizar el depósito en la cuenta");
                }
        } catch (Exception e) {
            LOG.log(Level.INFO, "no se puedo depositar", e);
            throw new persistenciaException("Error al depositar en la cuenta", e);
        }
    }
    
    
    
}
