/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.core;

public class Cls {
    private static Cls instancia;
	
	public static synchronized Cls getInstancia(){
		return(instancia==null)? new Cls():instancia;
	}
    
    public void cls(){
        for(int x = 0; x<=50;x++){
         System.out.println("");   
        }
    }
}
