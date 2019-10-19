import java.util.*;
public class ArbolBinario
{
   NodoBinario raiz;
   
   public ArbolBinario(){
       this.raiz=new NodoBinario(); 
   }
   public void llenarDePreorden(LinkedList<Integer> cola, NodoBinario nodo){
       if (cola.size()==0){
           return; 
       }else{
           nodo.dato=cola.removeFirst();
           if (nodo.dato>cola.getFirst()){//si el siguiente número es menor
               NodoBinario nodoIzq=new NodoBinario(nodo);
               nodo.izq=nodoIzq;
               llenarDePreorden(cola, nodoIzq);
           }else{//si el siguiente número del arreglo es mayor que el dato del nodo
               if (nodo.padre==null){//si el nodo es la raiz
                   if (nodo.der==null){
                       NodoBinario nodoDer=new NodoBinario(nodo);
                       nodo.der=nodoDer;
                       llenarDePreorden(cola, nodo.der);
                   }else{
                       System.exit(0);
                       System.out.println("El nodo agregado va a un espacio ocupado");
                   }
               }else{
                   NodoBinario nodoPadre=padreAUX(cola.getFirst(),nodo);
                   NodoBinario nodoDer=new NodoBinario(nodoPadre);
                   nodoPadre.der=nodoDer;
                   llenarDePreorden(cola, nodoDer);
                   
               }
           }
       }
     
   }
   
   public static NodoBinario padreAUX(Integer numerito, NodoBinario nodo){
       if(nodo.padre==null){//si el nodo recibido es la raiz
           if (nodo.dato<numerito){
               return nodo;
           }else{
               
               return null;
           }
        }else{//nodo no es raiz
           if (nodo.padre.dato<numerito){
               
               return padreAUX(numerito, nodo.padre);
           }else{
               
               return hijoAUX(nodo);
           }
        }
   }
   public static NodoBinario hijoAUX(NodoBinario nodo){
       if (nodo.der==null){
           return nodo;
       }else{
           return hijoAUX(nodo.der);
       }
   }
   
   public static void imprimirEnPos(NodoBinario nodo){
       if (nodo!=null){
           imprimirEnPos(nodo.izq);
           imprimirEnPos(nodo.der);
           System.out.println(nodo.dato);
           
       }
   }
}
