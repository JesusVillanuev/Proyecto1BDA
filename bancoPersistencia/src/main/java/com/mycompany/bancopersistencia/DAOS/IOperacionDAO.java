/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;
import com.mycompany.bancopersistencia.DTOS.TransferenciaDTO;
import com.mycompany.bancopersistencia.DTOS.RetiroDTO;
import com.mycompany.bancopersistencia.DTOS.OperacionDTO;
import com.mycompany.bancodominio.clasesPojo.Operacion;
import com.mycompany.bancodominio.clasesPojo.Retiro;
import com.mycompany.bancodominio.clasesPojo.Transeferencia;
import com.mycompany.bancopersistencia.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.PersistenciaException.persistenciaException;
import java.util.List;

/**
 *
 * @author JESUS
 */
public interface IOperacionDAO {
    public Operacion transferencia(CuentaDTO cuenta,int numeroDirigido)throws persistenciaException;
    public List<Operacion> listaOperaciones(CuentaDTO cuenta)throws persistenciaException;
    public Operacion generarRetiro(CuentaDTO cuenta)throws persistenciaException;
    public Operacion realizarRetiro(int folio,int contraseña)throws persistenciaException;
    public Operacion depositar(CuentaDTO cuenta)throws persistenciaException;
    
}
