/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Dao;

import modelo.Beans.UsuarioVo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author garmy
 */
public class UsuarioDao {
      
    public static boolean agregarUsuario(UsuarioVo usuario){
        boolean agregado = false;
        int nivel = 2;
    
        usuario.setNivel(nivel);

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                st.executeUpdate("call sp_agregaUsuario('" + usuario.getNivel() + "','" + usuario.getNombre() + "','" + usuario.getCorreo() + "',MD5('" + usuario.getContraseña() + "'),'" + usuario.getGenero() + "')");
                agregado = true;
                st.close();
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            agregado = false;
            e.printStackTrace();
        }
        return agregado;        
    }
    public static boolean buscaUsuario(UsuarioVo usuario){
        boolean busco = false;
       
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if(con!=null){
                String sql = "";
                PreparedStatement pst;
                ResultSet rs;
                
                sql="call sp_loginUsuario('"+usuario.getCorreo()+"','"+usuario.getContraseña()+"')";
       
                pst= con.prepareStatement(sql);
                rs=pst.executeQuery();
                
                    if (!rs.next()) {
                     //ResultSet esta vacio
                    } else {
                         usuario.setNombre(rs.getString("nombre"));                   
                         usuario.setIdPersona(rs.getInt("idUsuario"));                    
                         usuario.setNivel(rs.getInt("nivel"));

                        /*while(rs.next()){
                              nuevoNombre = rs.getString("nombre");
                         }*/
                    }   
                busco = true;
                rs.close();
            }
            c.cerrarConexion();
        } catch (SQLException e) {
            busco = false;
            e.printStackTrace();
        }
        
        
        return busco;
    }
    
}
