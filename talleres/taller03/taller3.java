/**
 * Write a description of class taller3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class taller3
{
    public static void torres(int n){
        
        torresAux(n,'A','B','C');
        
    }


    public static void torresAux(int n,char A,char B,char C){
    
        if(n==1){
        System.out.println("disco "+ 1 + " de "+ A+ " a " + C);
        }
        else{
        torresAux(n-1,A,C,B);
        
        System.out.println("disco "+ n + " de "+ A+ " a " + C);
        
        torresAux(n-1,B,A,C);
        }
    
    
    
    
    }
    
    public static void comb(String s){
        combina2("",s);
    }
    public static void combina2(String aux, String s){
    
        if(s.length()>0){
        System.out.println(aux+s.charAt(0));
        
        combina2(aux+s.charAt(0),s.substring(1));
        combina2(aux,s.substring(1));
    }
        
    }
    
}
