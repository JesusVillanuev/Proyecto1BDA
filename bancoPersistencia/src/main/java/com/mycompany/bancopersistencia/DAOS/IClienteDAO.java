/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancodominio.clasesPojo.Cliente;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
 
/**
 *
 * @author JESUS
 */
public interface IClienteDAO {
     /*
     * 
     * Metodo que registra al cliente
     * @param cliente
     * @return
     * @throws persistenciaException 
     */
    public Cliente registraCliente(ClienteDTO cliente)throws persistenciaException;
    
    /*
     * Metodo que permite editar datos del cliente
     * @param cliente
     * @return
     * @throws persistenciaException 
     */
    public Cliente editarCliente(ClienteDTO cliente)throws persistenciaException;
    
    public Cliente buscarUsuarioContra(ClienteDTO cliente)throws persistenciaException;
}
