package com.lords.conexion2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionBase {

private String nombreBD;
private String url;
private String usuario;
private String pass;

public ConexionBase(){

    nombreBD="verifact";
    url="jdbc:mysql://localhost/"+nombreBD;
    usuario="root";
    pass=null;
    
 }

public Connection conectarBase(){
 
    Connection cadenaConexion = null;
    
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        cadenaConexion = DriverManager.getConnection(url,usuario,pass);
        JOptionPane.showMessageDialog(null,"Conexion exitosa!","Felicidades", JOptionPane.INFORMATION_MESSAGE);
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "No encuentra la clase Driver","Error", JOptionPane.ERROR_MESSAGE);
    } catch (InstantiationException ex) {
        JOptionPane.showMessageDialog(null, "No se pudo crear la instancia","Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalAccessException ex) {
        JOptionPane.showMessageDialog(null, "Acceso denegado","Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos","Error", JOptionPane.ERROR_MESSAGE);
    }
   return cadenaConexion; 
 }
    public static void main(String [] args){
        ConexionBase jdbc = new ConexionBase();
        Connection cadenaConexion = jdbc.conectarBase();
    }
}
