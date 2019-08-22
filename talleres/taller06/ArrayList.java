
public class ArrayList
{
  
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    public ArrayList() {

        size=0;
        elements=new int[DEFAULT_CAPACITY];

    }     

    public int size() {
        return this.size;
    }   

    public void add(int e) {
        if(size<elements.length){
            elements[size]=e;
        } else{
            int []arr=new int[elements.length*2];
            for(int i=0;i<elements.length;i++){
                arr[i]=elements[i];

            }
            elements=arr;
            elements[size]=e;
        }
        size++;

    }    

    public int get(int i) {
        if(i<size){
            return elements[i];
        }else{

            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public void add(int index, int e) {  // Complejidad O(n)
        if(index >=1&&index<size){
            int[]arr=new int[elements.length+1];
            for(int i=0;i<index;i++){

                arr[i]=elements[i];

            }

            arr[index]=e;

            for(int i=index+1;i<elements.length;i++){
                arr[i]=elements[i-1];

            }
            elements=arr;
            size++;

        }else{
            throw new IndexOutOfBoundsException();
        }
    } 

    
    /**
     * Método para borrar un elemento 
     * 
     * @param  El índice del elemento a eliminar 
     */
    
    public void del(int ind)
    {
      if (elements.length==size){ 
          for (int i=ind;i<size;i++){
                elements[i]=elements[i+1];
               }
          elements[elements.length-1]=0;
          size=size-1;
        }else 
        {    if (ind<size){
               for (int i=ind;i<=size;i++){
                elements[i]=elements[i+1];
               }
               size--;
           }else{
               throw new IndexOutOfBoundsException();
           }
           
     }
    }
}
