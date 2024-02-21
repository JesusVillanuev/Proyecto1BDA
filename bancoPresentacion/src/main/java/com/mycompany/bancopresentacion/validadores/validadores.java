/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion.validadores;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author JESUS
 */
public class validadores {
    private static final Pattern patronNombre = Pattern.compile("^[A-Za-z ]{1,50}$");     
    private static final Pattern patronDomicilio = Pattern.compile("^(?!.*\\s{2,})[0-9a-zA-Z\\p{Punct} ]{1,200}$");
    private static final Pattern patronUsuario = Pattern.compile("^[a-zA-Z0-9]{1,30}$");
    private static final Pattern patronContrasena = Pattern.compile("^[a-zA-Z0-9]{1,30}$");
    private static final Pattern patronMonto = Pattern.compile("^\\d{1,10}(\\.\\d{1,2})?$");
    
    public validadores(){
        
    }
    
    public boolean validaNombre(String nombre){
        return patronNombre.matcher(nombre).matches() && !nombre.contains("  ");
    }
    
    public boolean validaDomicilio(String domicilio){
        return patronDomicilio.matcher(domicilio).matches();
    }
    
    public boolean validaUsuario(String usuario){
        return patronUsuario.matcher(usuario).matches() && !usuario.contains("  ");
    }
    
    public boolean validaContraseña(String contraseña){
        return patronContrasena.matcher(contraseña).matches();
    }
    
    public boolean validaMonto(String monto) {
        return patronMonto.matcher(monto).matches();
    }
    
}
