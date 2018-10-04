/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AUTONOMA
 */
public class ConexionBD {

    public static Connection getConexionBD(){
        Connection cnn=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cnn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_registro","root","");
            System.out.println("Conectado a la base de datos");
        }catch(Exception e)
        {
            System.out.println("No conectado "+e.getMessage());
        }
        return cnn;
        
    }
    public static void main(String[] args) {
          getConexionBD();
    }
    
}
