/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.controlador;

import org.josue.db.Conexion;
import org.ujosue.core.ComprobarFecha;
import org.ujosue.core.Lector;

/**
 *
 * @author Josue
 */
public class ControladorActividad {
    private static ControladorActividad instancia;
	
	public static synchronized ControladorActividad getInstancia(){
		return(instancia==null)? new ControladorActividad():instancia;
	}
    
    public boolean agregar(String nick,String pass, String nombre, String nota, String fecha){
        if(ComprobarFecha.getInstancia().comprobar(fecha)==true){
            int id = ControladorUsuario.getInstancia().getId(nick, pass);
            System.out.println("INSERT INTO actividad (`idUsuario`, `nombre`, `nota`, `fecha`) VALUES ("+id+", '"+nombre+"', '"+nota+"', '"+fecha+"')");
            Conexion.getInstancia().ejecutarConsulta("INSERT INTO actividad (`idUsuario`, `nombre`, `nota`, `fecha`) VALUES ("+id+", '"+nombre+"', '"+nota+"', '"+fecha+"')");
            return true;
        }else{
            System.out.println("Ingrese una fecha correcta");
            System.out.println("Presione cualquier tecla para continuar...");
            Lector.getInstancia().getTexto();
            return false;
        }
    }
    
    public void listar(String nick){
        //id = 
    }
}
