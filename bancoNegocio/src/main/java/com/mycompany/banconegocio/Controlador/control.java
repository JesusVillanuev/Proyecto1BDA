/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Controlador;
import com.mycompany.bancopresentacion.*;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancodominio.clasesPojo.*;
import javax.swing.JFrame;
/**
 *
 * @author JESUS
 */
public class control {
    
    ClienteDTO clienteG=new ClienteDTO();
    
    public void agregarCliente(JFrame frame){
        Cliente clienteG=new Cliente();
        ClienteDTO clienteD= new ClienteDTO();
        
        frmRegistro registro= new frmRegistro(frame, "Registro del cliente", true,clienteG);
        registro.setVisible(true);
        
        
    }
    
    
}
