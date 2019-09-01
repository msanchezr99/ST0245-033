
/**
 * Write a description of class InsertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsertionSort
{
    
    
    
    
    public static void main (){         //medir tiempos de insertionSort
        for(int i=1;i<=20;i++){
        
            int []arr=new int[i*10000];
            
            for(int j=arr.length-1;j>0;j--){
            
            arr[j]=j;
            }
            long start = System.nanoTime();
            insertionSort(arr);
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            
            System.out.println(arr.length+"  "+timeElapsed/1000000);
            
            
        
        }
            
        
        
        
        }
    public static int[] insertionSort(int [] arr){
        
        for (int i=1;i<arr.length;i++){           //2n+1
            
            for(int j=i;j>0;j--){                 //(2n+1)*n
                
                if(arr[j]<arr[j-1]){              //c*n*n
                    int aux=arr[j]; 
                    arr[j]=arr[j-1];
                    arr[j-1]=aux;

                }                                   

        
            }
            
            
            
        }                                      ////-->(O)n*n  Notacion Asintotica     
        return arr;
    }
        
        