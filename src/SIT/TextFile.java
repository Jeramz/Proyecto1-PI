/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
       
     try{

       fBus=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\buses.txt");
       fRutas=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\rutas.txt");
       fUsuarios=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\usuarios.txt");
       fDescuentos=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\descuentos.txt");
       fRecargas=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\recargas.txt");

       fwBus=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\buses.txt",true);
       fwRutas=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\rutas.txt",true);
       fwUsuarios=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\usuarios.txt",true);
       fwDescuentos=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\descuentos.txt",true);
       fwRecargas=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\Proyecto1-PI\\src\\SIT\\recargas.txt",true);

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
   }

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
                        
                    }
                }
                
            }
            if(archivo.equals("fRutas")){
                fRutas.getChannel().position(0);
                brRutas= new BufferedReader(new InputStreamReader(fRutas));
                while((linea=brRutas.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        
                }
                }
            }
            if(archivo.equals("fUsuarios")){
                fUsuarios.getChannel().position(0);
                brUsuarios= new BufferedReader(new InputStreamReader(fUsuarios));
                while((linea=brUsuarios.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        
                }
                }
            }
            if(archivo.equals("fDescuentos")){
                fDescuentos.getChannel().position(0);
                brDescuentos= new BufferedReader(new InputStreamReader(fDescuentos));
                while((linea=brDescuentos.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        
                }
                }
            }
            if(archivo.equals("fRecargas")){
                fRecargas.getChannel().position(0);
                brRecargas= new BufferedReader(new InputStreamReader(fRecargas));
                while((linea=brRecargas.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        
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
            if(!(this.yaExiste("fRutas",ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+"/"+ruta.getDescripcion().replaceAll("\n", "~")))){
                bwRutas.write(ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+"/"+ruta.getDescripcion().replaceAll("\n", "~"));
                bwRutas.newLine();
            }
            
        }
        
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
        for(int j=0;j<ruta.buses.size();j++){
            Bus bus= (Bus) ruta.buses.get(j);
            
            if(!(this.yaExiste("fBus",bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre()))){
                bwBus.write(bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre());
                bwBus.newLine();
            }
        }
        }
        
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
            if(!(this.yaExiste("fUsuarios",usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo()))){
                bwUsuarios.write(usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo());
                bwUsuarios.newLine();
            }
            
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaDescuento.size();j++){
            String fechaDescuento= (String) usuario.fechaDescuento.get(j);
            
            if(!(this.yaExiste("fDescuento",usuario.getIdentificacion()+"_"+fechaDescuento))){
                bwDescuentos.write(usuario.getIdentificacion()+"_"+fechaDescuento);
                bwDescuentos.newLine();
            }
        }
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaRecarga.size();j++){
            String fechaRecarga= (String) usuario.fechaRecarga.get(j);
            
            if(!(this.yaExiste("fRecargas",usuario.getIdentificacion()+"_"+fechaRecarga))){
                bwRecargas.write(usuario.getIdentificacion()+"_"+fechaRecarga);
                bwRecargas.newLine();
            }
        }
        }
        
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }

public void cargarDatos(SIT miSIT){
    String linea;
    String bus[]=new String[5];
    String ruta[]=new String[3];
    String descuento[]=new String[1];
    String recarga[]=new String[1];
    String usuario[]=new String[5];
    int i=0;
    try{
        while((linea=brRutas.readLine())!= null){
            ruta=linea.split("/");
            Ruta rutas=new Ruta();
            rutas.setCodigo(ruta[0]);
            rutas.setNombre(ruta[1]);
            rutas.setTipo(ruta[2]);
            rutas.setDescripcion(ruta[3].replaceAll("~", "\n"));
            try{
                miSIT.agregarRuta(rutas);
                //JOptionPane.showMessageDialog(null, rutas.getCodigo());
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            
        }
        while((linea=brBus.readLine())!= null){
            bus=linea.split("/");
            Bus buses=new Bus();
            buses.setCapacidad(bus[4]);
            buses.setMarca(bus[2]);
            buses.setModelo(bus[1]);
            buses.setPlaca(bus[0]);
            buses.setTipo(bus[3]);
            try{
                miSIT.agregarBusRuta(buses, miSIT.getRuta(bus[5]));
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            
        }
        while((linea=brUsuarios.readLine())!= null){
            usuario=linea.split("/");
            Usuario usuarios=new Usuario();
            
            usuarios.setNumero(usuario[0]);
            usuarios.setIdentificacion(usuario[1]);
            usuarios.setNombre(usuario[2]);
            usuarios.setDireccion(usuario[3]);
            usuarios.setFecha(usuario[4]);
            usuarios.setSaldo(Double.parseDouble(usuario[5]));
            
            try{
                miSIT.agregarUsuario(usuarios);
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            
        }
        
            while((linea=brDescuentos.readLine())!= null){
                descuento=linea.split("_");
                for(int j=0;j<miSIT.usuarios.size();j++){
                    Usuario usuarios = (Usuario)miSIT.usuarios.get(j);
                    if(descuento[0].equals(usuarios.getIdentificacion())){
                        usuarios.addDescuento(descuento[1]);
                        miSIT.usuarios.set(j, usuarios);
                    }
                }
                
            
            try{
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            }
            
        while((linea=brRecargas.readLine())!= null){
                descuento=linea.split("_");
                for(int j=0;j<miSIT.usuarios.size();j++){
                    Usuario usuarios = (Usuario)miSIT.usuarios.get(j);
                    if(descuento[0].equals(usuarios.getIdentificacion())){
                        usuarios.addRecarga(descuento[1]);
                        miSIT.usuarios.set(j, usuarios);
                    }
                }
                
            
            try{
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            }
    }catch(IOException e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
}

public void cerrar(){
    try{
    bwBus.close();
    bwRutas.close();
    bwUsuarios.close();
    bwDescuentos.close();
    bwRecargas.close();
    }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
}









}
