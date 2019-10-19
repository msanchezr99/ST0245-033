

public class NodoBinario
{
    NodoBinario padre;
    NodoBinario izq;
    NodoBinario der;
    int dato;
    
    public NodoBinario(){//Nodo raiz
        this.padre=null;
    }
    public NodoBinario(NodoBinario padre){
        this.padre=padre;
    }
}
