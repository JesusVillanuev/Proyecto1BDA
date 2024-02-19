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
    
}