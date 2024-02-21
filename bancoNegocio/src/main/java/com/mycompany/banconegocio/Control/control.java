/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.Control;

import com.mycompany.bancodominio.clasesPojo.*;
import com.mycompany.bancodominio.clasesPojo.Cuenta;
import com.mycompany.bancopersistencia.Controlador.controlP;
import com.mycompany.bancopersistencia.DTOS.*;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import com.mycompany.bancopresentacion.*;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

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
    
    public void iniciarsesion(Cliente cliente,JFrame frame) throws persistenciaException{
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas iniciar sesión con ese usuario?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
        if (respuesta==JOptionPane.OK_OPTION) {
            this.cliente=cliente;
            if (cliente.getUsario()!=null && cliente.getcontraseña()!=null) {
            
            ClienteDTO cli=new ClienteDTO();
            cli.setUsario(cliente.getUsario());
            cli.setContraseña(cliente.getcontraseña());
            cliente=con.InicioSesion(cli);
            if (cliente.getUsario()!=null) {
                JOptionPane.showMessageDialog(null, "Inicio exitoso");
                
                menuPrincipal(frame, cliente);
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto");
            }
        }
        }
        
    }
    
    
    public void abririniciarSesion(JFrame frame) throws persistenciaException{
        
        frmInicioSesion inicio=new frmInicioSesion(frame, "Inicio de sesion", true,cliente,this);
        inicio.setVisible(true);
    }
    
    public void menuPrincipal(JFrame frame,Cliente cliente) throws persistenciaException{
       
        DefaultTableModel tablaModelo = new DefaultTableModel();
        JTable tabla = new JTable(tablaModelo);
        tablaModelo.addColumn("Id cuenta");
        tablaModelo.addColumn("Número de Cuenta");
        tablaModelo.addColumn("Estado");
        tablaModelo.addColumn("Fecha de Apertura");
        tablaModelo.addColumn("Saldo");

        actualizarTabla(tablaModelo, cliente);
         Thread hiloActualizacion = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Actualizar cada 5 segundos
                    SwingUtilities.invokeLater(() -> {
                        try {
                            actualizarTabla(tablaModelo, cliente); // Actualizar la tabla periódicamente
                        } catch (persistenciaException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        hiloActualizacion.start();
       frmMenuPrincipal menu=new frmMenuPrincipal(frame, "Menu principal", true, cliente,tablaModelo,cuenta);
       menu.setVisible(true);
       
       
    }
    
    public void mostrarHistorial(JFrame frame,int id) throws persistenciaException{
        
        CuentaDTO cuenta=new CuentaDTO();
        cuenta.setIdCuenta(id);
        DefaultTableModel tabla = new DefaultTableModel();
        List<Operacion> listaOperaciones = con.consultaOperacion(cuenta);
        JTable table = new JTable(tabla);
        tabla.addColumn("Tipo");
        tabla.addColumn("Fecha y Hora");
        tabla.addColumn("Monto");
        for (Operacion operacion : listaOperaciones) {
            Object[] rowData = {operacion.getTipo(), operacion.getFechaHora(), operacion.getMonto()};
            tabla.addRow(rowData);
        }
        frmHistorial historia=new frmHistorial(frame,"Historial",true,cliente,tabla,id,this);
        historia.setVisible(true);
    }
    
    public List<Operacion> mostrarTransferencia(int id, String tipo) throws persistenciaException {
        CuentaDTO cuenta = new CuentaDTO();
        cuenta.setIdCuenta(id);
        List<Operacion> listaOperaciones = con.consultaOperacion(cuenta);
        List<Operacion> operacionesTransferencia = new ArrayList<>();

        for (Operacion operacion : listaOperaciones) {
            if (operacion.getTipo().equals(tipo)) {
                operacionesTransferencia.add(operacion);
            }
        }

        return operacionesTransferencia;
    }
    
    public void deposito(JFrame frame, int id){
        
        frmDeposito depo=new frmDeposito(frame,"Deposito",true,id,this);
        depo.setVisible(true);
    }
    
    public void depositar(float monto,int id) throws persistenciaException{
        CuentaDTO cuenta=new CuentaDTO();
        cuenta.setIdCuenta(id);
        Operacion opera=con.depositar(cuenta, monto);
        if (opera.getTipo().equals("Depósito")) {
            JOptionPane.showMessageDialog(null, "Se ha agregado el dinero");
        }
    }
    
    public void cancelar(int id) throws persistenciaException{
        CuentaDTO cuenta=new CuentaDTO();
        cuenta.setIdCuenta(id);
        con.cancelarCuenta(cuenta);
    }
    
    public void agregarNueva(Cliente cliente) throws persistenciaException{
        ClienteDTO nuevo=new ClienteDTO();
        nuevo.setIdCliente(cliente.getIdCliente());
        con.crearCuenta(nuevo);
        JOptionPane.showMessageDialog(null, "Se ha creado una nueva cuenta");
    }
    
    private void actualizarTabla(DefaultTableModel tabla, Cliente cliente) throws persistenciaException {
        try {
            List<Cuenta> listaCuentas = con.mostrarCuentas(cliente.getIdCliente());
            tabla.setRowCount(0); // Limpiar la tabla antes de actualizarla
            for (Cuenta cuenta : listaCuentas) {
                Object[] rowData = {cuenta.getIdCuenta(), cuenta.getNumeroCuenta(), cuenta.getEstado(), cuenta.getFechaApertura(), cuenta.getSaldo()};
                tabla.addRow(rowData);
            }
        } catch (Exception e) {
            throw new persistenciaException("Error al actualizar la tabla", e);
        }
    }
}
