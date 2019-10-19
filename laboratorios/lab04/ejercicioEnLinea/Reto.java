import java.util.*;
public class Reto
{
    public static void main (String[] args){
      
      /*Ciclo modificado de una respuesta en StackOverflow
       * usuario del autor: asiew
       * Dispoible en:https://stackoverflow.com/questions/39316625/make-user-only-input-integer-in-scanner-java
       */ 
      Scanner sc=new Scanner(System.in);
      String leido="";
      int dato;
      LinkedList <Integer>cola=new LinkedList<Integer>();
      
      while (sc.hasNextInt()) {
          dato=sc.nextInt();
          cola.addLast(dato);
          leido= leido+ ", "+ dato;
          System.out.println("La lista contiene los elementos "+leido);
      }
      ArbolBinario arbol= new ArbolBinario();
      arbol.llenarDePreorden(cola, arbol.raiz);
      
    }
    
    
    
}
