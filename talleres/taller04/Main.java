import java.lang.*;

public class Main
{
    public static void main (String [] args){
        /*for (int i = 1000; i <= 1000000; i =i+1000) {
            long startTime = System.nanoTime();
            suma(new int[i], 0);
            long end = System.nanoTime();
            System.out.println(end - startTime);
        }*/
       
        for (int i = 10; i <= 1000; i =i+10) {
            long startTime = System.nanoTime();
            f(i);
            long end = System.nanoTime();
            System.out.println(end - startTime);
        }
    }
    
    public static int suma(int []arr,int index){

        if (index==arr.length){ //c1
            return 0;
        }
        else{
            return arr[index]+suma(arr,index+1); //t(n)=c2+t(n-1)
            //--> t(n)=(c2*n)+c1
        }

    }
    
    public static boolean subgrupo(int index,int arr[],int objetivo){
        if(index==arr.length){
            return objetivo==0;// c1
        }
        else{

            return subgrupo(index+1,arr,objetivo-arr[index])||
            //t(n)=c2+t(n-1)+t(n-1) 
            subgrupo(index+1,arr,objetivo); 
            //-->t(n)=c1*(2^n-1)+(c2*((2^n)-1))
        }

    }
    
    public static int f(int n){
       if (n<=1){
           return 1;
        }else{
            return n*f(n-1); 
        }
    }
}
