/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.josue.db.Conexion;
import org.ujosue.bean.Usuario;

/**
 *
 * @author Josue
 */
public class ControladorUsuario {
    private static ControladorUsuario instancia;
	
	public static synchronized ControladorUsuario getInstancia(){
		return(instancia==null)? new ControladorUsuario():instancia;
	}        
        
        public boolean registrar(String nombre, String nick, String pass){
            ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select * from usuario");
            boolean existe = false;
        try {
            while(rs.next()){
                if(rs.getString("nick").equals(nick)){
                    existe = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(existe == false){
                Conexion.getInstancia().ejecutarConsulta("INSERT INTO usuario (`nombre`, `nick`, `contraseña`) VALUES ('"+nombre+"', '"+nick+"', '"+pass+"')");
            } else {
                System.out.println("El usuario ya existe");
            }
            return existe;
        }
        
        public boolean ingresar(String nick, String pass){
            boolean encontrado = false;
            ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select * from usuario");
        try {
            while(rs.next()){
                if(rs.getString("nick").equals(nick) && rs.getString("contraseña").equals(pass)){
                    encontrado = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de ControladorUsuario.java método ingresar [1]");
        }
            
            return encontrado;
        }
        
        public int getId(String nombre){
            int id = 0;
            ResultSet rs = Conexion.getInstancia().obtenerConsulta("Select * from usuario");
        try {
            while(rs.next()){
                if(rs.getString("nick").equals(nombre)){
                    id = rs.getInt("idUsuario");
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en controladorusuario.java método getId");
        }
        return id;
        }
}
