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
public class Conexion {
    String bd="verifact";
    String login="root";
    String pass="";
    String url="jdbc:mysql://localhost/"+bd;
    
    public Connection conectandobd(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(url,login,pass);
        }catch(InstantiationException e){
            JOptionPane.showMessageDialog(null,"No se pudo crear la instancia ","",JOptionPane.ERROR_MESSAGE);
        }catch(IllegalAccessException e){
            JOptionPane.showMessageDialog(null,"No pudo accesar al driver","",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"No encontro el driver","",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se pudo conectar a la base o no existe" + e);
        }
        return conn;
    }
    public static void main(String [] args){
        Conexion obj= new Conexion();
        obj.conectandobd();
    }
    }

