/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Control;

import com.mycompany.bancodominio.clasesPojo.Cliente;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopresentacion.frmRegistro;
import javax.swing.JFrame;

/**
 *
 * @author JESUS
 */
public class control {
    
    ClienteDTO clienteG=new ClienteDTO();
    
    public void registrarCliente(JFrame frame){
        Cliente clienteG=new Cliente();
        frmRegistro registro= new frmRegistro(frame, "Registro del cliente", true,clienteG);
        registro.setVisible(true);
        
        
    }
    
    public void iniciarSesion(JFrame frame){
        
    }
    
    public void menuPrincipal(JFrame frame){
        
    }
}
