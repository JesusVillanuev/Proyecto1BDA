/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancopersistencia;

import com.mycompany.bancopersistencia.Controlador.controlP;
import com.mycompany.bancopersistencia.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;

/**
 *
 * @author JESUS
 */
public class BancoPersistencia {

    public static void main(String[] args) throws persistenciaException {
        ClienteDTO cas=new ClienteDTO("dasj","kda","2010-05-09","k","daa","sd","as");
        controlP p=new controlP();
        p.agregarCliente(cas);
        System.out.println(cas.getNombres());
    }
}
