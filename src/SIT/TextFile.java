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
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class TextFile {

    FileInputStream fBus,
                    fRutas,
                    fUsuarios,
                    fDescuentos,
                    fRecargas;

    FileWriter fwBus=null,
               fwRutas=null,
               fwUsuarios=null,
               fwDescuentos=null,
               fwRecargas=null;

    BufferedWriter bwBus,
                   bwRutas,
                   bwUsuarios,
                   bwDescuentos,
                   bwRecargas;

    DataInputStream frBus=null,
                    frRutas=null,
                    frUsuarios=null,
                    frDescuentos=null,
                    frRecargas=null;

    BufferedReader brBus,
                   brRutas,
                   brUsuarios,
                   brDescuentos,
                   brRecargas;


   public TextFile(){
       /*
     try{
       fBus=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\buses.txt");
       fRutas=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\rutas.txt");
       fUsuarios=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\usuarios.txt");
       fDescuentos=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\descuentos.txt");
       fRecargas=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\recargas.txt");

       fwBus=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\buses.txt",true);
       fwRutas=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\rutas.txt",true);
       fwUsuarios=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\usuarios.txt",true);
       fwDescuentos=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\descuentos.txt",true);
       fwRecargas=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\recargas.txt",true);

       bwBus=new BufferedWriter(fwBus);
       bwRutas=new BufferedWriter(fwRutas);
       bwUsuarios=new BufferedWriter(fwUsuarios);
       bwDescuentos=new BufferedWriter(fwDescuentos);
       bwRecargas=new BufferedWriter(fwRecargas);

       frBus=new DataInputStream(fBus);
       frRutas=new DataInputStream(fRutas);
       frUsuarios=new DataInputStream(fUsuarios);
       frDescuentos=new DataInputStream(fDescuentos);
       frRecargas=new DataInputStream(fRecargas);

       brBus=new BufferedReader(new InputStreamReader(frBus));
       brRutas=new BufferedReader(new InputStreamReader(frRutas));
       brUsuarios=new BufferedReader(new InputStreamReader(frUsuarios));
       brDescuentos=new BufferedReader(new InputStreamReader(frDescuentos));
       brRecargas=new BufferedReader(new InputStreamReader(frRecargas));
     }catch(IOException e){
       e.printStackTrace();
       System.out.println("error"+e.getMessage());
     }
   }*/

public boolean yaExiste(String archivo,String objeto){
         boolean respuesta=false;
        String linea;
        
        try{
            if(archivo.equals("fBus")){
                fBus.getChannel().position(0);
                brBus= new BufferedReader(new InputStreamReader(fBus));
                while((linea=brBus.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                    }
                }
                
            }
            if(archivo.equals("fRutas")){
                fRutas.getChannel().position(0);
                brRutas= new BufferedReader(new InputStreamReader(fRutas));
                while((linea=brRutas.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                }
                }
            }
            if(archivo.equals("fUsuarios")){
                fUsuarios.getChannel().position(0);
                brUsuarios= new BufferedReader(new InputStreamReader(fUsuarios));
                while((linea=brUsuarios.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                }
                }
            }
            if(archivo.equals("fDescuentos")){
                fDescuentos.getChannel().position(0);
                brDescuentos= new BufferedReader(new InputStreamReader(fDescuentos));
                while((linea=brDescuentos.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                }
                }
            }
            if(archivo.equals("fRecargas")){
                fRecargas.getChannel().position(0);
                brRecargas= new BufferedReader(new InputStreamReader(fRecargas));
                while((linea=brRecargas.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
        return respuesta;
     }

public void guardar(ArrayList rutas,ArrayList usuarios){
        try{
            
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
            if(!(this.yaExiste("fBus",ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+ruta.getDescripcion()))){
                bwRutas.write(ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+ruta.getDescripcion());
                bwRutas.newLine();
            }
            
        }
        
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
        for(int j=0;j<ruta.buses.size();j++){
            Bus bus= (Bus) ruta.buses.get(j);
            
            if(!(this.yaExiste("fRutas",bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre()))){
                bwRutas.write(bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre());
                bwRutas.newLine();
            }
        }
        }
        
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
            if(!(this.yaExiste("fUsuarios",usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo()))){
                bwRutas.write(usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo());
                bwRutas.newLine();
            }
            
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaDescuento.size();j++){
            String fechaDescuento= (String) usuario.fechaDescuento.get(j);
            
            if(!(this.yaExiste("fRutas",usuario.getIdentificacion()+"_"+fechaDescuento))){
                bwRutas.write(usuario.getIdentificacion()+"_"+fechaDescuento);
                bwRutas.newLine();
            }
        }
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaRecarga.size();j++){
            String fechaRecarga= (String) usuario.fechaRecarga.get(j);
            
            if(!(this.yaExiste("fRutas",usuario.getIdentificacion()+"_"+fechaRecarga))){
                bwRutas.write(usuario.getIdentificacion()+"_"+fechaRecarga);
                bwRutas.newLine();
            }
        }
        }
        
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }











}
