/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.core;

/**
 *
 * @author Josue
 */
public class ComprobarOpcion {
    private static ComprobarOpcion instancia;
	
	public static synchronized ComprobarOpcion getInstancia(){
		return(instancia==null)? new ComprobarOpcion():instancia;
	}
        
        public int comprobar(String opcion){
            if(opcion.equals("1")){
                return 1;
            }else{
                return 2;
            }
        }
}
