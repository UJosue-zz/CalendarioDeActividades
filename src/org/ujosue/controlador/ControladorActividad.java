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
import org.ujosue.content.Dashboard;
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
            int id = ControladorUsuario.getInstancia().getId(nick);
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
    
    public void listar(String nick, String pass){
        int id = ControladorUsuario.getInstancia().getId(nick);
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * FROM actividad WHERE idUsuario = " + id);
        System.out.println("ID		Actividad		Nota		Fecha");
        try {
            while(rs.next()){
                System.out.println(rs.getInt("idActividad") + "		" + rs.getString("nombre") + "		" + rs.getString("nota") + "		" + rs.getInt("fecha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorActividad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en ControladorActividad.java método listar");
        }
        System.out.println("Presione cualquier tecla para continuar");
        Lector.getInstancia().getTexto();
        Dashboard.getInstancia().dashboard(nick, pass);
    }
}
