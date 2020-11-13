/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author vinic
 */
public class mp3reader {
        private int puntero=270;
        private String ruta;
        RandomAccessFile file;
        String concatenar="";
        int cont=0;
        
    public mp3reader(String ruta) throws FileNotFoundException {
        this.file = new RandomAccessFile(ruta,"r");
        this.ruta = ruta;
    }

    public String getConcatenar() {
        concatenar+=cont;
        cont++;
        return concatenar;
    }

    public void setConcatenar(String concatenar) {
        this.concatenar = concatenar;
    }
    
  
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public long tamaño () throws IOException{
        long size = file.length();
        concatenar+="Tamaño del archivo: "+size+" bytes";
        concatenar+="\n";
        return size;
    }
    
    public String nombre() throws IOException{
        byte nombre[]=new byte[20];
        int cant=0;
        file.seek(puntero);

        for (int i = 0; i <= 19; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               nombre[i]=hola;
               System.out.println(hola+"xx");
               System.out.println(nombre[i]);
               cant+=1; 
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        
        String name = new String(nombre, StandardCharsets.UTF_8);
        concatenar+="Nombre de la cancion: " + name;
        concatenar+="\n";
        puntero+=cant;
        System.out.println(puntero+"-1");
        return name;
    }
    
    public String ubicacion(){
        concatenar+="Ruta del archivo: "+getRuta();
        concatenar+="\n";
        return getRuta();
                }
    
    public String artista() throws IOException{
        puntero+=25;
        byte artista[]=new byte [15];
        file.seek(puntero);
        int cant=0;
        System.out.println(puntero);
        
        for (int i = 0; i <= 14; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               artista[i]=hola;
               System.out.println(hola+"xx");
               System.out.println(artista[i]);
               cant+=1; 
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        
        String art = new String(artista, StandardCharsets.UTF_8);
        puntero+=cant;
        concatenar+="Nombre del artista: " + art;
        concatenar+="\n"; 
        System.out.println(puntero+"-2");
        return art;
    }
    
    public String año() throws IOException{
        puntero+=25;
        int cant=0;
        byte anio[]=new byte [4];
        file.seek(puntero);
        
        for (int i = 0; i <= 3; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               anio[i]=hola;
               System.out.println(hola+"xx");
               System.out.println(anio[i]);
               cant+=1; 
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        String añito = new String(anio, StandardCharsets.UTF_8);
        concatenar+="Año del disco: " + añito;
        concatenar+="\n";
        puntero+=cant;
        System.out.println(puntero+"-3");
        return añito;
    }
    
    public String album() throws IOException{
        puntero+=25;
        int cant=0;
        byte album[]=new byte[20];
        file.seek(puntero);
        for (int i = 0; i <= 19; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               album[i]=hola;
               System.out.println(hola+"xx");
               System.out.println(album[i]);
               cant+=1; 
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        String albume = new String(album, StandardCharsets.UTF_8);
        concatenar+="Nombre del album: " + albume;
        concatenar+="\n";
        puntero+=cant;
        System.out.println(puntero+"-4");
        return albume;
    }
    
    public String duracion() throws IOException{
        puntero+=25;
        int cant=0;
        byte duracion[]=new byte[5];
        file.seek(puntero);
        for (int i = 0; i <= 4; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               duracion[i]=hola;
               System.out.println(hola+"xix");
               System.out.println(duracion[i]);
               cant+=1; 
               
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        String durac = new String(duracion, StandardCharsets.UTF_8);
        concatenar+="Duracion de la cancion: " + durac;
        concatenar+="\n";
        puntero+=cant;
        System.out.println(puntero+"-5");
        
        return durac;
    }
    
    public String genero() throws IOException{
        puntero+=25;
        int cant=0;
        byte gene[]=new byte[30];
        file.seek(puntero);
        for (int i = 0; i < 30; i++) {
            byte hola=file.readByte();
           if(hola!=0){
               gene[i]=hola;
               System.out.println(hola+"xix");
               System.out.println(gene[i]);
               cant+=1; 
               
          } else{
           System.out.println(hola+"!!!!");
           }
        }
        String gen = new String(gene, StandardCharsets.UTF_8);
        concatenar+="Genero: " + gen;
        concatenar+="\n";
        puntero+=cant;
        System.out.println(puntero+"-4");
        
        return gen;
    }
    
    
    public void guardar() throws FileNotFoundException, IOException{
        String nombreArchivo="InformacionCanciones.txt";
        String cadena;
        int escribir;
        String cadenas;
//        File archivos = new File(nombreArchivo);
//        Writer output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivos, true),"UTF-8")); 
        FileOutputStream archivo=new FileOutputStream(nombreArchivo);
        DataOutputStream escritor= new DataOutputStream(archivo);
       // FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true); //opción append habilitada!
//        Writer output = new BufferedWriter(new FileWriter(nombreArchivo, true)); 
//       FileReader f= new FileReader(ruta);
//       BufferedReader b=new BufferedReader(f);
//       while((cadena=b.readLine())!=null){
//           System.out.println(cadena);
//         //  escritor.writeUTF(cadena);
//       }

//        archivos.getAbsoluteFile();
//        archivos.setWritable(true);
//        output.append("|");
//        output.append("1"+ nombre());
        
        escritor.writeUTF("|");
        escritor.writeUTF("1" + nombre());
        escritor.writeUTF("2" + artista());
        escritor.writeUTF("3" + album());
        escritor.writeUTF("4" + genero());
        escritor.writeUTF("5" + año());
        escritor.writeUTF("6" + getRuta());
        escritor.writeUTF("7" + tamaño());
        escritor.writeUTF("8" + duracion());
        escritor.writeUTF("|"); 
    }
    
    
    
    public void listarFicherosPorCarpeta(final File carpeta) throws IOException {
    for (final File ficheroEntrada : carpeta.listFiles()) {
        if (ficheroEntrada.isDirectory()) {
            listarFicherosPorCarpeta(ficheroEntrada);
        } else {
                tamaño();
                nombre();
                artista();
                album();
                año();
                duracion();
                genero();
        }
    }
}
 
}

   
