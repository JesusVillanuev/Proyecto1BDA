/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancodominio.clasesPojo.Cliente;
import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.exception.PersistenciaException;
import com.mycompany.bancopersistencia.Conexion.IConexionBD;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
    public Cliente registraCliente(ClienteDTO cliente)throws PersistenciaException{
        try(Connection con=this.conexionBD.crearConexion();
            CallableStatement conn=(CallableStatement)con.prepareCall("{call sp_insertarClienteNuevo(?,?,?,?,?,?,?)}")  ) {
            
            conn.setString(1,cliente.getNombres());
            conn.setString(2,cliente.getApellido_paterno());
            conn.setString(3,cliente.getApellido_materno());
            conn.setString(4,cliente.getFechaNacimiento());
            conn.setString(5,cliente.getUsario());
            conn.setString(6,cliente.getContraseña());
            conn.setString(7,cliente.getDomicilio());
            
            int registro=conn.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registro);
            
            ResultSet registroG=conn.getGeneratedKeys();
            registroG.next();
            
            Cliente clienteNuevo=new Cliente(registroG.getInt(1),
            cliente.getUsario(),
            cliente.getContraseña(), 
            cliente.getFechaNacimiento(), 
            cliente.getNombres(), 
            cliente.getApellido_paterno(), 
            cliente.getApellido_materno(),
            cliente.getDomicilio());
            
            return clienteNuevo;
           
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el cliente",e);
            throw new PersistenciaException("No se pudo guardar", e);
        }
        
    }

    @Override
    public Cliente editarCliente(ClienteDTO cliente)throws PersistenciaException{
        try(Connection con=this.conexionBD.crearConexion();
            CallableStatement conn=(CallableStatement)con.prepareCall("{call sp_actualizar_cliente(?,?,?,?,?,?,?,?)}")  ) {
            
            conn.setInt(1, cliente.getIdCliente());
            conn.setString(2,cliente.getNombres());
            conn.setString(3,cliente.getApellido_paterno());
            conn.setString(4,cliente.getApellido_materno());
            conn.setString(5,cliente.getFechaNacimiento());
            conn.setString(6,cliente.getUsario());
            conn.setString(7,cliente.getContraseña());
            conn.setString(8,cliente.getDomicilio());
            
            int registro=conn.executeUpdate();
            LOG.log(Level.INFO, "Se actualizo con éxito {0} ", registro);
            
            if (registro>0) {
                ResultSet registroG=conn.getGeneratedKeys();
                registroG.next();
                
                Cliente clienteNuevo=new Cliente(registroG.getInt(1),
                cliente.getUsario(),
                cliente.getContraseña(), 
                cliente.getFechaNacimiento(), 
                cliente.getNombres(), 
                cliente.getApellido_paterno(), 
                cliente.getApellido_materno(),
                cliente.getDomicilio());
                
                return clienteNuevo;
            }else{
                throw new PersistenciaException("No se pudo actualizar el cliente. No se encontraron registros afectados");
            }
            
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al actualizar el cliente");
            throw new PersistenciaException("Fallo al actualizar el cliente",e);
        }
    }
}
