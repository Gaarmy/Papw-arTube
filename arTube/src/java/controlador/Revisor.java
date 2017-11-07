/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author garmy
 */
public class Revisor {
    public static boolean revisaContenidoRegistro(String nombre, String email, String contraseña, String genero){
        boolean falta = true;
        
        if(!nombre.equals("") && !email.equals("") && !contraseña.equals("") && !genero.equals("")){
            falta = false;
        }
        return falta; 
    }
    public static int parseogenero(String nombregenero){
        int tipo;
        if(nombregenero.equals("male")){
            tipo=1;
        }else tipo=0;
        return tipo;
    }
    public static boolean revisaLlenadoLogin(String email, String contraseña){
        boolean falta = true;
        if(!email.equals("") && !contraseña.equals("")){
            falta = false;
        }
        return falta;
    }
    
}
