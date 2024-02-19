/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Control;

import com.mycompany.bancodominio.clasesPojo.*;
import com.mycompany.bancopersistencia.Controlador.controlP;
import com.mycompany.bancopersistencia.DTOS.*;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import com.mycompany.bancopresentacion.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class control {
    controlP con=new controlP();
    ClienteDTO clienteD=new ClienteDTO();
    Cliente cliente=new Cliente();
    
    public control(){
        
    } 
    
    public void registrarCliente(JFrame frame){
        
        frmRegistro registro = new frmRegistro(frame, "Registro del cliente", true, cliente);
        clienteD.setNombres(cliente.getNombres());
        clienteD.setApellido_materno(cliente.getApellido_materno());
        clienteD.setApellido_paterno(cliente.getApellido_paterno());
        clienteD.setContraseña(cliente.getcontraseña());
        clienteD.setDomicilio(cliente.getDomicilio());
        clienteD.setUsario(cliente.getUsario());
        
        registro.setVisible(true);
        
        registro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (registro.respuesta().equals("aceptar")) {
                    try {
                        cliente=con.agregarCliente(clienteD);
                    } catch (persistenciaException ex) {
                        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
    }
    
    public void iniciarSesion(JFrame frame){
        
        frmInicioSesion inicio=new frmInicioSesion(frame, "Inicio de sesion", true,cliente);
        inicio.setVisible(true);
        clienteD.setUsario(cliente.getUsario());
        clienteD.setContraseña(cliente.getcontraseña());
        
        inicio.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (inicio.respuesta().equals("aceptar")) {
                    try {
                        cliente=con.InicioSesion(clienteD);
                        if (cliente.getNombres()!=null) {
                            JOptionPane.showMessageDialog(frame, cliente.getUsario());
                        }
                    } catch (persistenciaException ex) {
                        Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                }
            }
        });
    }
    
    public void menuPrincipal(JFrame frame){
       frmMenuPrincipal menu=new frmMenuPrincipal(frame, "Menu principal", true, cliente);
       menu.setVisible(true);
       
       
    }
}
