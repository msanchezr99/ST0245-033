import java.util.*;

public class Arbol
{
    Nodo raiz;
    
    public Arbol (String nombre){
        this.raiz= new Nodo(nombre);
                
    }
    
    public void recorrer(Nodo raiz){
        System.out.println(raiz.nombre);
        //for(int i=0;i<raiz.listaHijos.size();i++){
            //recorrer(raiz.listaHijos.get(i));
        for (Nodo b: raiz.listaHijos){
            recorrer(b);
        
        }
    }
    
    public void buscar(Nodo raiz){
        
    }
    public static void insertar(Nodo nodo, Stack<Nodo> pilaPadres, Nodo padreActual){
        int i=0;
        try{
            if (nodo.nombre.contains(".")){//si la linea es archivo simple
                        if (nodo.linea.contains("***")){//es el último archivo del subdirectorio
                            if (pilaPadres.size()>1){
                                padreActual.agregarHijo(nodo);
                                pilaPadres.pop();
                                padreActual=pilaPadres.peek();
                           }else{//Es el último archivo de todo el directorio 
                               padreActual.agregarHijo(nodo);
                               padreActual=pilaPadres.pop();
                           }
                        }else{
                            padreActual.agregarHijo(nodo);
                        }
                        
                    }else{//si la linea es nuevo diectorio
                        if (nodo.linea.contains("***")){
                            padreActual.agregarHijo(nodo);
                            padreActual=nodo;
                            pilaPadres.pop();
                            pilaPadres.push(nodo);
                        }else{
                            padreActual.agregarHijo(nodo);
                            padreActual=nodo;
                            pilaPadres.push(padreActual);
                        }
                    }
        }catch (Exception e){
            System.out.println("Se produjo error "+e);
                }
    }
}


