/*
Clase TextFile:Crea los archivos .txt donde se guardará la información
 referente a los buses, rutas y usuarios. Guarda los datos de las rutas, buses y usuarios
 en sus respectivos archivos .txt, lee y carga los datos guardados 
 de las rutas, buses y usuarios con anterioridad de los archivos. Al finalizar,
 cierra los archivos .txt

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 10 mayo 2018
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
    String rutaBus="/home/invitado/Descargas/Proyecto1-PI/Proyecto1-PI/src/SIT/buses.txt",
           rutaRutas="/home/invitado/Descargas/Proyecto1-PI/Proyecto1-PI/src/SIT/rutas.txt",
           rutaUsuarios="/home/invitado/Descargas/Proyecto1-PI/Proyecto1-PI/src/SIT/usuarios.txt",
           rutaDescuentos="/home/invitado/Descargas/Proyecto1-PI/Proyecto1-PI/src/SIT/descuentos.txt",
           rutaRecargas="/home/invitado/Descargas/Proyecto1-PI/Proyecto1-PI/src/SIT/recargas.txt";
    
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
       fBus=new FileInputStream(rutaBus);
       fRutas=new FileInputStream(rutaBus);
       fUsuarios=new FileInputStream(rutaUsuarios);
       fDescuentos=new FileInputStream(rutaDescuentos);
       fRecargas=new FileInputStream(rutaRecargas);

       fwBus=new FileWriter(rutaBus,true);
       fwRutas=new FileWriter(rutaRutas,true);
       fwUsuarios=new FileWriter(rutaUsuarios,true);
       fwDescuentos=new FileWriter(rutaDescuentos,true);
       fwRecargas=new FileWriter(rutaRecargas,true);

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
            if(!(this.yaExiste("fBus",ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+"/"+ruta.getDescripcion()))){
                bwRutas.write(ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getTipo()+"/"+ruta.getDescripcion());
                bwRutas.newLine();
            }
            
        }
        
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
        for(int j=0;j<ruta.buses.size();j++){
            Bus bus= (Bus) ruta.buses.get(j);
            
            if(!(this.yaExiste("fRutas",bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre()))){
                bwBus.write(bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+ruta.getNombre());
                bwBus.newLine();
            }
        }
        }
        
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
            if(!(this.yaExiste("fUsuarios",usuario.getNumero()+"_"+usuario.getIdentificacion()+"_"+usuario.getNombre()+"_"+usuario.getDireccion()+"_"+usuario.getFecha()+"_"+usuario.getSaldo()))){
                bwUsuarios.write(usuario.getNumero()+"_"+usuario.getIdentificacion()+"_"+usuario.getNombre()+"_"+usuario.getDireccion()+"_"+usuario.getFecha()+"_"+usuario.getSaldo());
                bwUsuarios.newLine();
            }
            
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaDescuento.size();j++){
            String fechaDescuento= (String) usuario.fechaDescuento.get(j);
            
            if(!(this.yaExiste("fDescuentos",usuario.getIdentificacion()+"/"+fechaDescuento))){
                bwDescuentos.write(usuario.getIdentificacion()+"/"+fechaDescuento);
                bwDescuentos.newLine();
            }
        }
        }
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaRecarga.size();j++){
            String fechaRecarga= (String) usuario.fechaRecarga.get(j);
            
            if(!(this.yaExiste("fRecargas",usuario.getIdentificacion()+"/"+fechaRecarga))){
                bwRecargas.write(usuario.getIdentificacion()+"/"+fechaRecarga);
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
            usuario=linea.split("_");
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
