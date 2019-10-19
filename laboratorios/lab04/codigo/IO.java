
import java.io.*; //contiene File
import java.util.*;//contiende Scanner y Stack

public class IO
{
    
    public static void main (String []args){
        //atributo Arbol
        Arbol arbol;
        
        
        String nombreArchivo=inputString("Bienvenido, por favor inserte el nombre del archivo");
        arbol=lector(nombreArchivo);
        
        String opcion=inputString("Inserte su opción: \n"+
        "a: imprimir recorrido \n"+
        "b: Buscar un archivo \n"+
        "c:Mostrar archivos y subdirectoros de un directorio");
        seleccion(opcion, arbol);
    }
    
    public static void seleccion(String leido, Arbol arbol){
        switch (leido){
            case "a":
                arbol.recorrer(arbol.raiz);
                
                break;
            case "b":
                
                break;
            case "c":
                
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    public static Arbol  lector(String nombreArchivo){
        try{
            File file=new File (nombreArchivo);
            Scanner sc= new Scanner (file); 
            String directorio=sc.nextLine();
               Arbol miArbol= new Arbol(directorio);//inicializo objeto arbol
               Nodo padreActual=miArbol.raiz;
               System.out.println("Directorio accedido:"+padreActual.toString());
               Stack<Nodo> pilaPadres=new Stack<Nodo>();
               pilaPadres.push(padreActual);
            String linea;
            String nombre;
            
            while (sc.hasNextLine()){
                //for(int i= 0;i<20; i++){
                linea= sc.nextLine();
                linea=linea.replaceAll("├", "+");
                linea=linea.replaceAll("└", "***");//identifica ultimo arch de un directorio.
                linea=linea.replaceAll("│", " ");
                linea=linea.replaceAll("── ", "");
                if (linea.indexOf("]")>-1){//revisa que la linea sea un archivo
                    //linea=linea.substring(0 ,linea.indexOf("["))+linea.substring(linea.indexOf("]"));//quito los corchetes
                    nombre= linea.substring(linea.indexOf("]")+1);// dejo solo el nombre de archivo
                    nombre=nombre.trim();//limpio de espacios
                    Nodo nodoLeido= new Nodo (linea, nombre);
                    Arbol.insertar(nodoLeido, pilaPadres, miArbol.raiz);
                    // posibilidad de hacer método insertar no estático y no tener pila(padreactual como atributo de Nodo)
                }
                
            }
            //miArbol.recorrer(miArbol.raiz);
            System.out.println("El archivo fue cargado");
            return miArbol;
            
        }catch(Exception e){
            System.out.println("No se encontró el archivo"+ e);
            return null;
        }
    }
    
    public static String inputString(String mensaje){
        Scanner sc= new Scanner (System.in);
        System.out.println(mensaje + ": ");
        String texto=sc.nextLine();
        return texto;
    }
}
