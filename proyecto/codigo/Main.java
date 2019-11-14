/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author msanchezr
 */
public class Main {
    public static void main(String[] args){
        Arbol arbol = new Arbol( IO.lectorArchivoMatriz() );//creo una raiz de arbol 
        arbol.ubicador(IO.lectorNuevoRegistro() );
        
     
    }
}
