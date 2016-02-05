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
public class ComprobarNumero {

    private static ComprobarNumero instancia;
	
	public static synchronized ComprobarNumero getInstancia(){
		return(instancia==null)? new ComprobarNumero():instancia;
	}
    
    public boolean esNumero(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
