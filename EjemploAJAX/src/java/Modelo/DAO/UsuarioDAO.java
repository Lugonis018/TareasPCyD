/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Bean.UsuarioBean;
import Util.ConexionBD;
import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author AUTONOMA
 */
public class UsuarioDAO {
    Connection cnn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    UsuarioBean objUsuarioBean=null;
    ArrayList<UsuarioBean> lista=null;
    public boolean ValidarUsuario(UsuarioBean obj)
    {
        boolean estado=false;
        try
        {
            cnn=ConexionBD.getConexionBD();
            pt=cnn.prepareStatement("select * from usuario where usuarios=? and clave=?");
            pt.setString(1, obj.getUsuario());
            pt.setString(2, obj.getClave());
            rs=pt.executeQuery();
            if(rs.next())
            {
                estado=true;
            }
            pt.close();
            rs.close();
            cnn.close();
        }catch(Exception e){estado=false;}
        return estado;
    }
}
