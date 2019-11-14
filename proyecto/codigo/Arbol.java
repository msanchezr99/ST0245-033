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

public class Arbol {
    Nodo raiz;
    //constructor
    public Arbol (Double[] [] matriz){
         raiz = new Nodo(matriz);
         raiz.mejorVariable();
        //System.out.println(raiz.matriz[0][0]);
        //System.out.println("pepapig" + raiz.valor);
    }
    
    public void ubicador(Double [][] registro){
        ubicador(registro, raiz);
    }
    private void ubicador(Double [][] registro, Nodo n){
        if (n.nodoDer==null && n.nodoIzq==null){
            System.out.println("La probabilidad de que el registro sea calificado como positivo es de: "+n.porcentajeSi);
        }else{
            if (registro[0][n.columnaVar]<=n.valor){
                
                    registro= n.reductorMatriz(registro, n.columnaVar);
                    ubicador(registro, n.nodoIzq);
                
            }else{
                
                    registro=n.reductorMatriz(registro, n.columnaVar);
                    ubicador(registro, n.nodoDer);
                
                    
            }
        }
        
    }
    
    
   
    
}
