/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.operaciones;
import java.util.Random;
/**
 *
 * @author JESUS
 */
public class metodosAuxiliares {
    
    public int generarNumCuenta(){
        Random random = new Random();
        StringBuilder numeroCuenta = new StringBuilder();
        
        for (int i = 0; i < 12; i++) {
            int digito = random.nextInt(10); 
            numeroCuenta.append(digito);
        }
        
        return Integer.parseInt(numeroCuenta.toString());
    }
}
