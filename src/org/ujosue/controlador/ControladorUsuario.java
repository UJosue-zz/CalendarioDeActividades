/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.controlador;

import org.josue.db.Conexion;
import org.ujosue.bean.Usuario;

/**
 *
 * @author Josue
 */
public class ControladorUsuario {
    Usuario usuario = new Usuario();
    private static ControladorUsuario instancia;
	
	public static synchronized ControladorUsuario getInstancia(){
		return(instancia==null)? new ControladorUsuario():instancia;
	}
        
        public Usuario getSesion(){
            return usuario;
        }
        
        public void Registrar(String nombre, String nick, String pass){
            Conexion.getInstancia().EjecutarConsulta("INSERT INTO usuario (`nombre`, `nick`, `contraseña`) VALUES ('"+nombre+"', '"+nick+"', '"+pass+"')");
        }
}
