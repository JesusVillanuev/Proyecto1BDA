/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.control;
import com.mycompany.bancopresentacion.*;
import com.mycompany.banconegocio.DTOS.*;
import javax.swing.JFrame;
/**
 *
 * @author JESUS
 */
public class Control {
    
    
    public void registroCliente(JFrame frame){
        ClienteDTO cliente=new ClienteDTO();
        frmRegistro fr=new frmRegistro(frame, "Registro de usuario", true, cliente);
    }
}
