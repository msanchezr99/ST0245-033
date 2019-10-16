
public class BinaryTree {
    
    
    public Node root;


   
    public void insertar(int n) {
        insertarAux(root, n);
    }
   
    private Node insertarAux(Node node, int n) {
        //En caso de que el arbol este vacio, el elemento a insertar sera la raiz
        if(root==null){
            root=new node(n);
        }
        //Si es menor, se recorre el arbol por la izq
        else if(n<node){
        node.izq=insertarAux(node.izq,n);
        }
        else if(n>node){
        node.der=insertarAux(node.der,n);
        
        }
        //En cualquiera caso retorna la raiz una vez ya se haya insertado el elemento
        return root;
    }

 
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }
    
    private boolean buscarAux(Node node, int n) {
       
        if(node==null){
           return false;
           }
        if(node.dato==n){
           return true;
           }
           
        //Recorrer arbol por la izquierda/derecha buscando n
        boolean opcionIzquierda=buscarAux(node.izq,n);
        boolean opcionDerecha=buscarAux(node.der,n);
        
        //Si alguno de los dos es true, entonces n pertenece al arbol
        
        return opcionDerecha||opcionIzquierda;
           
    
    
}
    
    
    
    
    

