/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ujosue.content;

import org.ujosue.controlador.ControladorUsuario;
import org.ujosue.core.ComprobarOpcion;
import org.ujosue.core.Lector;
import org.ujosue.db.Encriptar;

public class Inicio {
    private static Inicio instancia;
	
	public static synchronized Inicio getInstancia(){
		return(instancia==null)? new Inicio():instancia;
	}
    
    public void iniciar(){
        System.out.println("Binvenido!");
        System.out.println("Calendario by UJosue");
        System.out.println("");
        System.out.println("Opciones");
        System.out.println("");
        System.out.println("[1] Ingresar    [2] Registrame");
        System.out.println("");
        System.out.print(">");
        int opcion = 0;
        try{
           opcion  = Integer.parseInt(Lector.getInstancia().getTexto());
        }catch(NumberFormatException e){
            System.out.println("Debe escribir un numero");
            System.out.println("------------------------");
            System.out.println("");
            iniciar();
        }
        if (opcion == 1){
            ingresar();
        }else if (opcion == 2){
            registrar();
        }else{
            System.out.println("Ingrese una opcion correcta");
            System.out.println("---------------------------");
            System.out.println("");
            iniciar();
        }
    }
    
    
    public void ingresar(){
        String nick, pass;
        System.out.println("Binvenido!");
        System.out.println("Agenda by UJosue");
        System.out.println("");
        System.out.println("Ingrese su usuario: ");
        System.out.print(">");
        nick = Lector.getInstancia().getTexto();
        System.out.println("Ingrese su contraseña: ");
        System.out.print(">");
        pass = Encriptar.getMD5(Lector.getInstancia().getTexto());
        if(ControladorUsuario.getInstancia().ingresar(nick, pass)==true){
            Dashboard.getInstancia().dashboard(nick, pass);
        }else{
            System.out.println("Usuario no encontrado");
            System.out.println("Presione 1 para regresar al menu y cualquier otra tecla para volver a ingresar");
            System.out.println("");
            System.out.print(">");
            if(ComprobarOpcion.getInstancia().comprobar(Lector.getInstancia().getTexto()) == 1){
                iniciar();
            }else{
                ingresar();
            }
        }
    }
    
    public void registrar(){
        System.out.println("Ingrese su nombe");
        System.out.print(">");
        String nombre = Lector.getInstancia().getTexto();
        System.out.println("Ingrese su usuario");
        System.out.print(">");
        String nick = Lector.getInstancia().getTexto();
        System.out.println("Ingrese su contraseña");
        String contraseñaOne = Encriptar.getMD5(Lector.getInstancia().getTexto());
        System.out.println("Vuelva a escribir su contraseña");
        String contraseñaTwo = Encriptar.getMD5(Lector.getInstancia().getTexto());
        if(contraseñaOne.equals(contraseñaTwo)){
            ControladorUsuario.getInstancia().registrar(nombre, nick, contraseñaOne);
        }else{
            System.out.println("Las contraseñas no coinciden");
            System.out.println("Presione 1 para volver al menu y cualquier otra tecla para volver a registrarse");
            System.out.print(">");
            if(ComprobarOpcion.getInstancia().comprobar(Lector.getInstancia().getTexto())==1){
                iniciar();
            }else{
                registrar();
            }
        }
        System.out.println("Registrado exitosamente");
        System.out.println("");
        Dashboard.getInstancia().dashboard(nick, contraseñaOne);
    }
}
