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
    Cliente cliente=new Cliente();
    Cuenta cuenta=new Cuenta();
    public control(){
        
    } 
    
    public void registrarCliente(JFrame frame){
        frmRegistro registro = new frmRegistro(frame, "Registro del cliente", true, cliente);
        registro.setVisible(true);
        
        registro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                    if (registro.respuesta().equals("aceptar")) {
                    try {
                        ClienteDTO clienteD=new ClienteDTO(cliente.getUsario(), cliente.getcontraseña(), cliente.getFechaNacimiento(), cliente.getNombres(), cliente.getApellido_paterno(), cliente.getApellido_materno(), cliente.getDomicilio());
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
        
        
    }
    
    public void menuPrincipal(JFrame frame){
       frmMenuPrincipal menu=new frmMenuPrincipal(frame, "Menu principal", true, cliente);
       menu.setVisible(true);
       
       
    }

}
