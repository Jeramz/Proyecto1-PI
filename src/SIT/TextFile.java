/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jesus
 */
public class TextFile {

    FileInputStream fBus,
                    fRutas,
                    fUsuarios;

    FileWriter fwBus=null,
               fwRutas=null,
               fwUsuarios=null;

    BufferedWriter bwBus,
                   bwRutas,
                   bwUsuarios;

    DataInputStream frBus=null,
                    frRutas=null,
                    frUsuarios=null;

    BufferedReader brBus,
                   brRutas,
                   brUsuarios;


   public TextFile(){
     try{
       fBus=new FileInputStream("Documentos\\Buses.txt");
       fRutas=new FileInputStream("Documentos\\Rutas.txt");
       fUsuarios=new FileInputStream("Documentos\\Usuarios.txt");

       fwBus=new FileWriter("Documentos\\Buses.txt",true);
       fwRutas=new FileWriter("Documentos\\Rutas.txt",true);
       fwUsuarios=new FileWriter("Documentos\\Usuarios.txt",true);

       bwBus=new BufferedWriter(fwBus);
       bwRutas=new BufferedWriter(fwRutas);
       bwUsuarios=new BufferedWriter(fwUsuarios);

       frBus=new DataInputStream(fBus);
       frRutas=new DataInputStream(fRutas);
       frUsuarios=new DataInputStream(fUsuarios);

       brBus=new BufferedReader(new InputStreamReader(frBus));
       brRutas=new BufferedReader(new InputStreamReader(frRutas));
       brUsuarios=new BufferedReader(new InputStreamReader(frUsuarios));
     }catch(IOException e){
       e.printStackTrace();
       System.out.println("error"+e.getMessage());
     }
   }















}
