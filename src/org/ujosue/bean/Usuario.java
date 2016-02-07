/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.bean;

/**
 *
 * @author Josue
 */
public class Usuario {
    int idUsuario;
    String nombre, nick, contraseña;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
        public Usuario(int idUsuario, String nombre, String nick,
			String contraseña){
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nick = nick;
		this.contraseña = contraseña;
	}
	
	public Usuario(){
		super();
	}
    
}
