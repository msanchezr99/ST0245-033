
/**
 * Write a description of class taller7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class taller7
{
    public static void main(){
        
        Nodo uno=new Nodo(1);
        Nodo dos=new Nodo(2);
        Nodo tres=new Nodo(3);
        Nodo cuatro=new Nodo(4);
        
        uno.siguiente=dos;
        dos.siguiente=tres;
        tres.siguiente=cuatro;
        
        listaEnlazada list = new listaEnlazada();
        list.primero=uno;
        Nodo ultimo=list.primero.siguiente.siguiente.siguiente;
        
        list.get(1);
        list.insertarEnI(7,2);
        list.InsertarInicio(0);
        
        
        
        
        
        
        
        
    }
    
    
}

class listaEnlazada{
    public Nodo primero;
    
    public void insertarEnI( int numero,int i){
        Nodo entrante= new Nodo(numero);
        
        Nodo auxiliar=primero;
       
        for(int j=0;j<=i;j++){
        auxiliar=auxiliar.siguiente;
       
        }
        entrante=auxiliar;
        auxiliar.siguiente=auxiliar;
        
    
    }
    
    public void InsertarInicio(int numero){
        Nodo entrante= new Nodo(numero);
        
        entrante.siguiente=primero;
        
        this.primero=entrante;
        
    
    
    }
    
    private Nodo CicloParaGet(int i){
    
        Nodo auxiliar=primero;
        for(int j=1;j<=i;j++){
        
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    
    
    }
    public Nodo get(int i){
    
    
    return CicloParaGet(i);
    }
    
    
    
    
}
class Nodo{
    
public int numero;    
public Nodo siguiente;

public Nodo(int unNumero){
    siguiente=null;
    numero=unNumero;
}
    

}
