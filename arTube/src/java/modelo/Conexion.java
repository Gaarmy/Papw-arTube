/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author garmy
 */
public class Conexion {
    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3306/artubebd";
    private String user = "root";
    private String password = "";

    public Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
            
        } catch (InstantiationException | IllegalAccessException
                     | ClassNotFoundException | SQLException e) {
             // TODO Auto-generated catch block
              e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return con;
    }
    
    public void cerrarConexion(){
        try{
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
