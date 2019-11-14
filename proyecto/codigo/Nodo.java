/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import java.util.Stack;

/**
 *
 * @author msanchezr
 */
public class Nodo {
    Nodo nodoIzq;
    Nodo nodoDer;
    Double [][] matriz;
    Double impureza;
    Double valor;//valor de la variable
    int columnaVar;//variable(columna)
    Double porcentajeSi;
    
    public Nodo (Double [][] matriz){
        this.matriz= matriz;
        this.impureza= impuGini(matriz);
        this.nodoDer=null;
        this.nodoIzq=null;
       // mejorVariable();
    }
    
    @Override
    public String toString(){ 
        String cadena="porcentaje de sis: " +this.porcentajeSi+ "\n"+
                "impureza del nodo: "+ this.impureza;
        return cadena;
    }
    
    //este método define la mejor variable para un nodo
    public void mejorVariable(){
        //caso final
        if (this.matriz[0].length<=1){
            this.porcentajeSi=porcentajeSi(this.matriz, this.matriz.length);
        }
        //caso recursivo
        else{
        
            Double [][] matrizIzq=null;
            Double [][] matrizDer=null;
            int columna=0;//columnda de la varaible
            double valorDeVar=0;
            double infGain=0;
            int variablesRestantes=this.matriz[0].length-1 ;//numero de variables sin contar categoría
            int filas=this.matriz.length;        

            for(int j=0;j<variablesRestantes;j++){//por cada columna
                for(int i=0;i<filas;i++){
                    Double [][] matrizMenor=matrizMenor(this.matriz,j,this.matriz[i][j]);
                    Double [][] matrizMayor=matrizMayor(this.matriz,j,this.matriz[i][j]);
                    double posibleImpureza = impurezaPromPond(filas,matrizMenor,matrizMayor);
                    Double posibleGain=this.impureza-posibleImpureza;
                    if ( posibleGain>infGain ){
                        infGain=posibleGain;
                        columna=j;
                        valorDeVar=this.matriz[i][j];
                        matrizIzq=matrizMenor;
                        matrizDer=matrizMayor;
                    }
                }
            }
            if (infGain>0){
                this.valor=valorDeVar;
                this.columnaVar= columna;//variable
                this.nodoIzq= new Nodo (reductorMatriz(matrizIzq, columna) );
                this.nodoDer= new Nodo (reductorMatriz(matrizDer, columna) );
                //System.out.println("el valor de variable tomó el valor de: "+this.valor);

                this.nodoDer.mejorVariable();
                this.nodoIzq.mejorVariable();
            }else{
                this.nodoDer=null;
                this.nodoIzq=null;
                this.porcentajeSi=porcentajeSi(this.matriz, filas);
            }
        }
    }
    
    
    
    //métodos auxiliares
    private static double porcentajeSi(Double[][] matrizTerminal, int filas){
        double porcentaje=0;
        int sis=0;
        for (int i=0;i<filas;i++){
            if ( matrizTerminal[i][matrizTerminal[0].length-1]== 1.0){
                sis++;
            }
        }
        porcentaje=(double)(sis)/filas;
        return porcentaje;
        
    }
    
    
    //Este método evalúa la impureza de una matriz dada
    private static double impuGini( Double [][] matriz){
        int datosFila=matriz.length;
        int cantidadSi=0;
        int cantidadNo=0;
        double impurity;
        double probSi;
        double probNo;
        
        
        for (int i =0; i<datosFila; i++) {
            if (matriz[i][matriz[0].length-1]==0.0) {
                cantidadNo++;
            } 
            if (matriz[i][matriz[0].length-1]==1.0) {
                cantidadSi++;
            }
        }
        probSi=(double)cantidadSi/datosFila;
        probNo=(double)cantidadNo/datosFila;
        impurity= 1-(probSi*probSi +probNo*probNo);
        return impurity;
    }
    
    
    private Double[][] matrizMenor(Double [][] matriz, int columnaVar, Double valor){//O(nxm) en el peor de los casos (matrizMenor=matrizOrig)
        Double[][]matrizIzq;
        Stack<Integer> indices =new Stack();
        for (int i=0;i <matriz.length;i++){
            if (matriz[i][columnaVar]<=valor){
                indices.add(i);
            }
        }
        matrizIzq=new Double[indices.size()][matriz[0].length];
        
        int i=0;
        while(! indices.isEmpty()){
            int indice=indices.pop();
            for(int j=0; j<matriz[0].length; j++){//columna de categoría
                matrizIzq[i][j]= matriz[indice][j];   
            }
            i++;
        }
        return matrizIzq;
    }
    
    
    private Double[][] matrizMayor(Double [][] matriz, int columnaVar, Double valor){
        Double[][]matrizDer;
        Stack<Integer> indices =new Stack();
        for (int i=0;i <matriz.length;i++){
            if (matriz[i][columnaVar]>valor){
                indices.add(i);
            }
        }
        matrizDer=new Double[indices.size()][matriz[0].length];
        
        int i=0;
        while(!indices.isEmpty()){
            int indice=indices.pop();
           for(int j=0; j<matriz[0].length; j++){//columna de categoría
                matrizDer[i][j]= matriz[indice][j];   
            }   
            i++;
        }
        return matrizDer;
    }
    
    private double impurezaPromPond(int filas, Double[][]matrizIzq, Double[][] matrizDer){
        double impurezaIzq=impuGini(matrizIzq);
        double impurezaDer=impuGini(matrizDer);
        double ponderada= (matrizIzq.length/filas)*impurezaIzq+
                (matrizDer.length/filas)*impurezaDer;
        
        return ponderada;
    }
    
    
    
    
    
    public Double[][] reductorMatriz(Double [][] matriz, int j){
        Double [][] matrizCortada=new Double[matriz.length][matriz[0].length-1];        
        for (int i=0;i<matriz.length;i++){
            for (int h=0;h<matriz[0].length;h++){
                if (h<j){
                    matrizCortada[i][h]=matriz[i][h];
                
                }else{ 
                    if(h==j){
                        
                    }else{
                        matrizCortada[i][h-1]=matriz[i][h];
                    }
                }
            }
        }
        return matrizCortada;
    }
}
//Registro de pruebas 
/* public static void main(String[] args){
        //Double [][] numeros={{1.0,6.7,8.0,4.5,59.0,3.0,0.0},{2.9,6.6,7.0,4.5,59.0,3.0,0.0},{1.9,5.0,7.0,4.5,9.0,3.0,1.0},{1.7,6.0,7.0,4.5,9.0,3.0,1.0}};
        Double [][] numeros={{2.0,6.7,1.0},{2.9,6.9,1.0},{0.9,6.2,0.0},{0.5,6.0,0.0}};
        //Double [][] numeros={{2.0,1.0},{2.9,1.0},{0.9,0.0},{0.5,0.0}};
        Nodo nodo =new Nodo (numeros);
        nodo.mejorVariable();
        nodo.ubicador(IO.lectorNuevoRegistro());
        //System.out.println(nodo.nodoDer.toString());
    }*/
    /*public void ubicador(Double [][] registro){
        if (this.nodoDer==null || this.nodoIzq==null){
            System.out.println("La probabilidad de que el registro sea calificado como positivo es de: "+this.porcentajeSi);
        }else{
            if (registro[0][this.columnaVar]<=this.valor){
                
                    registro=reductorMatriz(registro, this.columnaVar);
                    this.nodoIzq.ubicador(registro);
                
            }else{
                
                    registro=reductorMatriz(registro, this.columnaVar);
                    this.nodoDer.ubicador(registro);
                
                    
            }
        }
        
    }*/