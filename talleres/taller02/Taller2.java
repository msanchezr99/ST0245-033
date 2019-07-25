

public class Taller2
{
    public static void main(){
    
    euclides(150,345);
    
    
    }
    
    public static int euclides(int p,int q){
    
    if(q==0) return p;
    return euclides(q,p%q);
    
    }
    
    public static boolean punto3(int arr[],int index, int objetivo){
        
        if(index==arr.length){
            return objetivo==0;
        }
        
        else{
        return punto3(arr,index+1,objetivo)||punto3(arr,index+1,objetivo-arr[index]);
        }
        
        
    }
    
}
