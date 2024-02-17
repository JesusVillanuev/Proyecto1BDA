/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
 import com.mycompany.bancodominio.clasesPojo.Cliente;
import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.exception.PersistenciaException;
 
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
    public Cliente registraCliente(ClienteDTO cliente)throws PersistenciaException;
    
    /*
     * Metodo que permite editar datos del cliente
     * @param cliente
     * @return
     * @throws persistenciaException 
     */
    public Cliente editarCliente(ClienteDTO cliente)throws PersistenciaException;

}
