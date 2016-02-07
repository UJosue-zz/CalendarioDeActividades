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
import org.ujosue.bean.Actividad;
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
    
    public void listar(String nick){
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
    }
    
    public boolean eliminar(String id){
        Conexion.getInstancia().ejecutarConsulta("DELETE FROM actividad WHERE idActividad = " + id);
        return true;
    }
    
    public Actividad getEditar(String id){
        Actividad actividad = new Actividad();
        ResultSet rs = Conexion.getInstancia().obtenerConsulta("SELECT * FROM actividad WHERE idActividad = " + id);
        try {
            while(rs.next()){
                actividad.setIdActividad(rs.getInt("idActividad"));
                actividad.setIdUsuario(rs.getInt("idUsuario"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setNota(rs.getString("nota"));
                actividad.setFecha(rs.getString("fecha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorActividad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en ControladorActividad.java método getEditar");
        }
        return actividad;
    }
    
    public boolean editar(Actividad act){
        Conexion.getInstancia().ejecutarConsulta("UPDATE actividad SET nombre = '"+act.getNombre()+"', nota = '"+act.getNota()+"', fecha = '"+act.getFecha() +
                "' WHERE idActividad = " + act.getIdActividad());
        return true;
    }
    
    public Actividad comprobarCambios(Actividad act, String nombre, String nota, String fecha){
        if(!act.getNombre().equals(nombre)){
            act.setNombre(nombre);
        }
        if(!act.getNota().equals(nota)){
            act.setNota(nota);
        }
        if(!act.getFecha().equals(fecha)){
            act.setNombre(fecha);
        }
        return act;
    }
}
