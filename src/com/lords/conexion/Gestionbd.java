/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lords.conexion;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author macbookpro
 */
public class Gestionbd { 
    Connection lineaconexion;
    Statement sentencia;
    Conexion objconexion=new Conexion();
    
    public Gestionbd(){
        lineaconexion=objconexion.conectandobd();
    }
    
    public void ejecutar(String sentenciabd){
        try{
            sentencia=lineaconexion.createStatement();
            sentencia.execute(sentenciabd);
            JOptionPane.showMessageDialog(null,"Transaccion realizada con exito","",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo realizar la transaccion"+ e);
        }
    }
    public ResultSet ejecutarsentencia(String sentenciabd){
        ResultSet rs = null;
        try{
            sentencia=lineaconexion.createStatement();
            rs=sentencia.executeQuery(sentenciabd);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se realizo la consulta " +e);
        }
        return rs;
    }
}
