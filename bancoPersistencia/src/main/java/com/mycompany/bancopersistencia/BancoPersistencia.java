/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancopersistencia;

import com.mycompany.bancopersistencia.Controlador.controlP;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import com.mycompany.bancodominio.clasesPojo.Cliente;
/**
 *
 * @author JESUS
 */
public class BancoPersistencia {

    public static void main(String[] args) throws persistenciaException {
        ClienteDTO n =new ClienteDTO();
        n.setUsario("as");
        n.setContraseña("as");
        Cliente f=new Cliente();
        controlP C=new controlP();
        f=C.InicioSesion(n);
        System.out.println(f.getNombres());
    }
}
