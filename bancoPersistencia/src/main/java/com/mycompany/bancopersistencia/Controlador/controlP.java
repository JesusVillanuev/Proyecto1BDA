/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Controlador;
import com.mycompany.bancopersistencia.Conexion.*;
import com.mycompany.bancodominio.clasesPojo.*;
import com.mycompany.bancopersistencia.DTOS.*;
import com.mycompany.bancopersistencia.DAOS.*;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import java.util.List;
/**
 *
 * @author JESUS
 */
public class controlP {
    String cadenaConexion = "jdbc:mysql://localhost/banco";
    String usuario = "root";
    String contrasenia = "1234";
    IConexioBD conexionBD = new ConexionBD(cadenaConexion, usuario, contrasenia);
    IClienteDAO cliente=new ClienteDAO(conexionBD);
    ICuentaDAO cuenta=new CuentaDOA(conexionBD);
    
    public Cliente agregarCliente(ClienteDTO cliente) throws persistenciaException{
        Cliente cli=this.cliente.registraCliente(cliente);
        return cli;
    }
    
    public Cliente edicionCliente(ClienteDTO cliente)throws persistenciaException{
        Cliente cli=this.cliente.editarCliente(cliente);
        return cli;
    }
    
    public Cliente InicioSesion(ClienteDTO cliente)throws persistenciaException{
        Cliente cli=this.cliente.buscarUsuarioContra(cliente);
        return cli;
    }
    
    public List<Cuenta> mostrarCuentas(int id)throws persistenciaException{
        List<Cuenta> cuentas=this.cuenta.consultarCuentas(id);
        return cuentas;
    }
    
    public void cancelarCuenta(CuentaDTO cuenta) throws persistenciaException{
        this.cuenta.cancelarCuenta(cuenta);
    }
    
    public Cuenta crearCuenta(ClienteDTO cliente)throws persistenciaException{
        Cuenta cuenta=this.cuenta.crearCuenta(cliente);
        return cuenta;
    }
}
