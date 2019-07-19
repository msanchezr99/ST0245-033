
import java.lang.Math;

public class Punto {
     //Atributos
    
    int x;
    int y;
    double radio;
    
    
    
    //Métodos
    
    
    public Punto (int x, int y){
        this.x=x;
        this.y=y;
        this.radio=Math.sqrt(x*x+y*y);
    }
    
    public double getX(){

        return x;

    }

    public double getY(){
        return y;
    }
    
    
    public double angulo(){
        double seno= y/radio;
        
        double angulo = Math.asin(seno);
        return angulo;
    }
    
    public double distanciaEuclidea(Punto p2){
        
        return Math.sqrt(Math.pow((p2.getX()-this.x),2)+ Math.pow((p2.getY()-this.y),2));

    }
}