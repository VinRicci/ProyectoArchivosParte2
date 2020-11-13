/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author vinic
 */
public class buscador {
    

    public String buscarNombre(String nombre){
        String line="";
       try {
            Scanner input = new Scanner(new File("C:\\Users\\vinic\\Documents\\Archivossss\\Proyecto1\\InformacionCanciones.txt"));
            
            if(input.findAll(nombre)!=null){
                 while (input.hasNextLine()) {
                
                 line+= input.nextLine()+"\n";
                System.out.println(line);
            }
            
            input.close();
            }else{
                line="no existe";
            }
            
           
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       return line;
    }
    
    public String buscaranio(int anio){
        String line="";
       try {
            Scanner input = new Scanner(new File("C:\\Users\\vinic\\Documents\\Archivossss\\Proyecto1\\InformacionCanciones.txt"));
            
            if(input.findAll(Integer.toString(anio))!=null){
                 while (input.hasNextLine()) {
                
                 line+= input.nextLine()+"\n";
                System.out.println(line);
            }
            
            input.close();
            }else{
                line="no existe";
            }
            
           
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       return line;
    }
    
    public String buscarArtista(String nombre){
        String line="";
       try {
            Scanner input = new Scanner(new File("C:\\Users\\vinic\\Documents\\Archivossss\\Proyecto1\\InformacionCanciones.txt"));
            
            if(input.findAll(nombre)!=null){
                 while (input.hasNextLine()) {
                
                 line+= input.nextLine()+"\n";
                System.out.println(line);
            }
            
            input.close();
            }else{
                line="no existe";
            }
            
           
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       return line;
    }
     

    
}
