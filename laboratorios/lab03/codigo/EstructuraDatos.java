import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EstructuraDatos
{
    public static void main(String curso){
    
        metodo1(curso);
    
    }
    
    
    private static void metodo1(String curso){ // leer los archivos csv y pasarlos a un arrayList de arreglos
        
        List<String[]> filas1 = new ArrayList<>();
        List<String[]> filas2 = new ArrayList<>();
        List<String[]> filas3 = new ArrayList<>();
        
        try{
            String csv="C:/Users/juanm/OneDrive/Documentos/csv/NOTAS ST0247.txt";
            String line="";
            
            BufferedReader csvReader = new BufferedReader(new FileReader(csv));

            while ((line=csvReader.readLine())!=null){
                String[] dataLine = line.split(",");
                filas1.add(dataLine);
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("no se encontro archivo");
        }

        try{
            String csv="C:/Users/juanm/OneDrive/Documentos/csv/NOTAS ST0245.txt";
            String line="";
            
            BufferedReader csvReader = new BufferedReader(new FileReader(csv));

            while ((line=csvReader.readLine())!=null){
                String[] dataLine = line.split(",");
                filas2.add(dataLine);
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("no se encontro archivo");
        }
        
        try{
            String csv="C:/Users/juanm/OneDrive/Documentos/csv/NOTAS ST0242.txt";
            String line="";
            
            BufferedReader csvReader = new BufferedReader(new FileReader(csv));

            while ((line=csvReader.readLine())!=null){
                String[] dataLine = line.split(",");
                filas3.add(dataLine);
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("no se encontro archivo");
        }
        
        //--------------------------------------------------------
        
        
        //Si el curso es el indicado, imprime sus estudiantes y respectiva nota final
        
        if (curso.equalsIgnoreCase("fundamentos de programacion")){ 
            
            for(int i=2;i<filas3.size();i+=2){
               String[] arr=filas1.get(i);
               String[] prueba=filas1.get(i-2);
              
               
               
               
               if(!arr[1].equals(prueba[1])){
                  System.out.println(arr[0]+""+" "+arr[13]);
                  }
             }
        }
        
        else if (curso.equalsIgnoreCase("estructura datos y algoritmos 1")){
            
            for(int i=2;i<filas2.size();i+=2){
               String[] arr=filas2.get(i);
               String[] prueba=filas2.get(i-2);
              
               
               
               
               if(!arr[1].equals(prueba[1])){
                  System.out.println(arr[0]+""+" "+arr[13]);
                  }
             }
        }
        
        else if (curso.equalsIgnoreCase("estructura datos y algoritmos 2")){
            
            for(int i=2;i<filas1.size();i+=2){
               String[] arr=filas1.get(i);
               String[] prueba=filas1.get(i-2);
              
               
               
               
               if(!arr[1].equals(prueba[1])){
                  System.out.println(arr[0]+""+" "+arr[13]);
                  }
             }
        }
        
        
        
       
    }
}
