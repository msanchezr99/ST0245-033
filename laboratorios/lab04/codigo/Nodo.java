import java.util.ArrayList;

public class Nodo
{
    public String linea;// podría hacerse con genérico class Nodo<T>.... 
    //atributo private <T> dato=null;
    public String nombre;
    //public Nodo padre;
    public int numHijos;
    public ArrayList<Nodo>listaHijos;
    
    public Nodo (String nombre){// constructor raíz
        this.nombre=nombre;
        this.linea="Directorio analizado: "+nombre;
        this.numHijos=0;
        listaHijos= new ArrayList<Nodo>();
    }
    public Nodo (String linea, String nombre){
        this.linea=linea;
        this.nombre=nombre;
        this.numHijos=0;
        listaHijos= new ArrayList<Nodo>();
    }
   
    public void agregarHijo(Nodo hijo){//no necesita parámetro padre pq no es estático.Agreg el hij al Nodo actual
        listaHijos.add(hijo);
        numHijos=listaHijos.size(); //numHijos+1;         
    }
    
    public String getLinea(){
        return linea;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        return "nombre="+this.nombre;
    }
     
    /* public Nodo (String linea, String nombre, Nodo padre){//
        //this.padre=padre;
        this.linea=linea;
        this.nombre=nombre;
        this.numHijos=0;
       listaHijos=new ArrayList<Nodo>();
    }
    */
}