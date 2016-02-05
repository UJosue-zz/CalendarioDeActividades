/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.content;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ujosue.controlador.ControladorActividad;
import org.ujosue.controlador.ControladorUsuario;
import org.ujosue.core.Cls;
import org.ujosue.core.ComprobarOpcion;
import org.ujosue.core.Lector;


public class Dashboard {
    
    private static Dashboard instancia;
	
	public static synchronized Dashboard getInstancia(){
		return(instancia==null)? new Dashboard():instancia;
	}
    
    public void dashboard(String nick, String pass){
        Cls.getInstancia().cls();
        System.out.println("Bienvenido " + nick);
        System.out.println("");
        System.out.println("Opciones");
        System.out.println("[1] Ver Actividades");
        System.out.println("[2] Agregar Actividades");
        System.out.println("[3] Eliminar Actividades");
        String actividad = Lector.getInstancia().getTexto();
        System.out.println("actividad : " + actividad);
        if(actividad.equals("1")){
            
        }else if(actividad.equals("2")){
            agregar(nick,pass);
        }else{
            System.out.println("Ingrese una opcion correcta");
            System.out.println("Presione enter para continuar");
            Lector.getInstancia().getTexto();
            dashboard(nick,pass);
        }
    }
    
    public void agregar(String nick, String pass){
        System.out.println("");
        System.out.println("Ingrese el nombre de la actividad");
        System.out.print(">");
        String nombre = Lector.getInstancia().getTexto();
        System.out.println("Ingrese una anotación");
        System.out.print(">");
        String nota = Lector.getInstancia().getTexto();
        System.out.println("Ingrese la fecha de la actividad");
        System.out.println("FORMATO: YYYY-MM-DD");
        System.out.print(">");
        String fecha = Lector.getInstancia().getTexto();
        if(ControladorActividad.getInstancia().agregar(nick, pass, nombre, nota, fecha)==true){
            dashboard(nick,pass);
        }else{
            System.out.println("");
            System.out.println("No se ha podido agregar la actividad");
            System.out.println("presione 1 si quiere volver al menu o cualquier tecla si quiere volver a agregar");
            System.out.print(">");
            if(ComprobarOpcion.getInstancia().comprobar(Lector.getInstancia().getTexto())==1){
                dashboard(nick, pass);
            }else{
                agregar(nick, pass);
            }
        }
    }
    
    public void ver(String nick, String pass){
        
    }
}
