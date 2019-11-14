/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author msanchezr
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class IO {
//el método de lectura pero entrando los datos en una matriz
    public static Double[] [] lectorArchivoMatriz (){
        String nombre;
        String path;
        
        nombre=inputString("Inserte el nombre del archivo .csv");
        path =inputString("Inserte la ruta del archivo .csv");
        
        File archivo= new File (path, nombre);
        try{
            Scanner sc=new Scanner (archivo);
            String etiquetas= sc.nextLine();
            Double [][] matriz= new Double[countLine(archivo) -1][7];//inicializo un arreglo del tamaño de lineas del archivo, sin contar la linea etiquetas
            
            int i=0;
            while ( sc.hasNextLine() ){
                String linea=sc.nextLine();
                String [] x=linea.split(",");
                
                
                matriz [i][0] =Double.valueOf(x[0]);
                matriz [i][1]=Double.valueOf(x[1]);
                matriz [i][2]=Double.valueOf(x[2]);
                matriz [i][3]=Double.valueOf(x[3]);
                matriz [i][4]=Double.valueOf(x[4]);
                matriz [i][5]=Double.valueOf(x[5]);
                matriz[i][6]=x[6].equals("yes")?1.0:0.0;
                
                i++;
            }
            

            return matriz;
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado"+ e);
            return null;
        }
        
    }
    
//método para recibir el dato a clasificar. El dato lo asume como matriz de una fila.
    public static Double [][] lectorNuevoRegistro(){
        Double [][] registro;
        String cadena=inputString("Inserte el vector de variables separados por comas");
        String [] x=cadena.split(",");
        registro= new Double [1][x.length+1];
        for (int i =0;i<x.length;i++){
            registro[0][i]=Double.valueOf(x[i]);
        }
        registro[0][x.length]=0.5;
        return registro;
    }
    

//métodos auxiliares
    public static String inputString(String mensaje){
        Scanner sc= new Scanner (System.in);
        System.out.println(mensaje + ": ");
        String texto=sc.nextLine();
        return texto;
    }
    public static int countLine(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int line=0;
        while(sc.hasNextLine()){
            sc.nextLine();
            line++;
        }
        return line;
    }
    
    
    
    //primera prueba que hice para corroborar que el método de contar lineas funcionara
    /*public static void main(String[] args){
        int a = lectorArchivo("C:\\Users\\msanchezr\\Documents\\DataSets", "data_set_train.csv" );//compie el file path
        //C:\Users\msanchezr\Documents\NetBeansProjects\ProyectoDatosyAlg\src\Programa\data_set_train.csv si se quiere el constructor con solam. el param. path
        System.out.println(a);
    }
    
    public static int lectorArchivo (String path, String nombre){
        
        File archivo= new File (path, nombre);
        Planta [] arrDatos=null;
        try{
            Scanner sc=new Scanner (archivo);
            String etiquetas= sc.nextLine();
            arrDatos= new Planta[countLine(archivo) -1];
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado"+ e);
        }
        return arrDatos.length;
    }*/
    
}
