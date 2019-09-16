import java.util.*;

public class telefonoRoto
{
    public static void metodo(String cadena){

        LinkedList<String> lista=new LinkedList<String>();  
        LinkedList<String> lista2=new LinkedList<String>();  
        for(int i=0;i<cadena.length();i++){
            lista.add(String.valueOf(cadena.charAt(i)));

        }

        for(int i=0;i<lista.size();i++){

            if(lista.get(i).equals("[")){
                i++;
                while ((i<lista.size()-1)&&(!lista.get(i+1).equals("[")&&!lista.get(i+1).equals("]"))){
                    lista2.addFirst(lista.get(i));
                    i++;

                }
                if(i==lista.size()-1||lista.get(i+1).equals("[")){
                    lista2.addFirst(lista.get(i));
                }
            }

        }

        for(int i=0;i<lista.size();i++){
            if(lista.get(i).equals("[")){
                break;
            }
            System.out.print(lista.get(i));

        }
        for (int i=0;i<lista2.size();i++){
            System.out.print(lista2.get(i));
        }

    }
}
