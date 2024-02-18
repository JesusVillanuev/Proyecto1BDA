/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Control;

import com.mycompany.bancodominio.clasesPojo.Cliente;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopresentacion.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class control {
   
    ClienteDTO G=new ClienteDTO();
    Cliente c=new Cliente();
    public control(){
        
    }
    
    
    public void registrarCliente(JFrame frame){
       
        frmRegistro registro= new frmRegistro(frame, "Registro del cliente", true,c);
        
        registro.setVisible(true);
        
        
    }
    
    public void iniciarSesion(JFrame frame){
        
    }
    
    public void menuPrincipal(JFrame frame){
        G.setNombres(c.getNombres());
        JOptionPane.showMessageDialog(frame, "",""+G.getNombres(),JOptionPane.INFORMATION_MESSAGE);
        
        
       frmMenuPrincipal menu=new frmMenuPrincipal(frame, "Menu principal", true, c);
       
       menu.setVisible(true);
    }
}
