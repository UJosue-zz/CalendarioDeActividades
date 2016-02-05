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
public class Actividad {
    int idActividad, idUsuario;
    String nombre, nota, fecha;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
        public Actividad(int idActividad, int idUsuario, String nombre, String nota, String fecha){
		this.idUsuario = idUsuario;
                this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nota = nota;
                this.fecha = fecha;
	}
	
	public Actividad(){
		super();
	}
}
