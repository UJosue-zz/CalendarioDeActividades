/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue
 */
public class Lector {
    private static Lector instancia;
	
	public static synchronized Lector getInstancia(){
		return(instancia==null)? new Lector():instancia;
	}
        
        public String getTexto(){
            BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
            String texto = "";
        try {
            texto = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
            return texto;
        }
}
