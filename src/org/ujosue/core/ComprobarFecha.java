/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.core;

import java.util.StringTokenizer;

public class ComprobarFecha {
    private static ComprobarFecha instancia;
	
	public static synchronized ComprobarFecha getInstancia(){
		return(instancia==null)? new ComprobarFecha():instancia;
	}
    
    public boolean comprobar(String fecha){
        boolean comprobado = false;
        StringTokenizer st = new StringTokenizer(fecha, "-");
        String año = st.nextToken();
        String mes = st.nextToken();
        String dia = st.nextToken();
        if(año.length()==4 && mes.length()==2 && dia.length()==2){
            comprobado = true;
        }
        return comprobado;
    }
}
