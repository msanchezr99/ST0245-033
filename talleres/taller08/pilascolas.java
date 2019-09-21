import java.util.*;
public class pilascolas
{
   public static int main(String s){
    
    Stack<Integer> Stack = new Stack();
    int total=0;
    int segundo=0;
    
    for(int i=0;i<s.length();i++){
        
        if(s.charAt(i)!=' '){
        
            if(Character.isDigit(s.charAt(i))) {
            
                 Stack.add((Character.getNumericValue(s.charAt(i))));
            }
            
            else{
                segundo=Stack.pop();
                
                if(s.charAt(i)=='*'){
                    total=Stack.pop();
                    total*=segundo;
                    Stack.add(total);
                    
                
                }else if (s.charAt(i)=='/'){
                    total=Stack.pop();
                    total/=segundo;
                    Stack.add(total);
                    
                }
                else if(s.charAt(i)=='-'){
                    total=Stack.pop();
                    total-=segundo;
                    Stack.add(total);
                    
                }
                else{
                    total=Stack.pop();
                    total+=segundo;
                    Stack.add(total);
                    
                
                }
                
            
            
            }
        
        
        }
        
       
        
    
    }
    return total;

    
    
    
    }
}
