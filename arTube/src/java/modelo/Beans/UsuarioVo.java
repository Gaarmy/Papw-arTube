/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Beans;

/**
 *
 * @author garmy
 */
public class UsuarioVo {
    private int idPersona;
    private int nivel;
    private String nombre;
    private String correo;
    private String contraseña;
    private int genero;

    public UsuarioVo(String nombre, String correo, String contraseña, int genero) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.genero = genero;
    } 
    public void UsuarioSesionVo(String nombre, String Correo){
        this.nombre = nombre;
        this.correo = Correo;
        
    }

    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    

    
  
    
}
