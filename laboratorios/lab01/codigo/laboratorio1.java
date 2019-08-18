

public class laboratorio1
{
    
    
    
    public static void medirTiempos(){
    
        for (int i=0;i<=51;i+=3){
        
        
        
        long inicio = System.nanoTime();
        contenedores(i);
        long fin = System.nanoTime();
        long total = fin-inicio;
        
        System.out.println(i+" "+ total+" nanosegundos");
    }
    
    }
    
    
    public static int contenedores(int n){
    
    if(n<3){
    
    return n;
    }
    else{
    return contenedores(n-2)+contenedores(n-1);
    }   
    
    
    }
}
