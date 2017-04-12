package com.lords.conexion2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestionBD {

    private Connection cadenaConexion;
    private Statement sentencia;
    private ResultSet cdr;
    
    public GestionBD(){
        ConexionBase objCBD = new ConexionBase();
        cadenaConexion = objCBD.conectarBase();
    }
    
    public void altasBajasCambios (String instruccionBD){
        try {
            sentencia = cadenaConexion.createStatement();
            sentencia.executeUpdate(instruccionBD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la operacion "+ex);
        }
        
    }
    
    public ResultSet consultas(String instruccionBD){
        try {
            sentencia = cadenaConexion.createStatement();
            cdr = sentencia.executeQuery(instruccionBD);
        } catch (SQLException ex) {
            Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cdr;
    }    
}
