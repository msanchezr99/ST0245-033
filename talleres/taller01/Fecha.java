
public class Fecha
{
    
    private int dia;
    private int mes;
    private int anyo;

    public Fecha(int dia, int mes, int anyo){
        this.dia=dia;
        this.mes=mes;
        this.anyo=anyo;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAnyo(){
        return anyo;
    }
    
    public void comparar(Fecha nueva){
        int anyoNuevo=nueva.getAnyo();
        int mesNuevo=nueva.getMes();
        int diaNuevo=nueva.getDia();
        
        
        
        if (this.anyo==anyoNuevo&&this.mes==mesNuevo&&this.dia==diaNuevo){
            System.out.println("Las fechas dadas son iguales");
        }
        
        if (this.anyo<anyoNuevo){
            System.out.println("La fecha dada es posterior");
        }
        
        if (this.anyo==anyoNuevo){
            if (this.mes<mesNuevo){
                System.out.println("La fecha dada es posterior");
            }           
            
            if (this.mes==mesNuevo){
                if (this.dia<diaNuevo){
                    System.out.println("La fecha dada es posterior");
                }
            }
        }
        
        
        
        
        
        if (this.anyo>anyoNuevo){
            System.out.println("La fecha dada es previa a la inicial");
        }
        
        if (this.anyo==anyoNuevo){
            if (this.mes>mesNuevo){
                System.out.println("La fecha dada es previa a la inicial");
            }           
            
            if (this.mes==mesNuevo){
                if (this.dia>diaNuevo){
                    System.out.println("La fecha dada es previa a la inicial");
                }
            }
        }
    }
}
