/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIT;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class SIT {
    Usuario miUsuario=new Usuario();
    ArrayList usuarios=new ArrayList();
    
    Ruta miRuta=new Ruta();
    ArrayList rutas=new ArrayList();
    
    public SIT(){
    }
    
    public void agregarUsuario(Usuario usuario){
        for(int i=0;i<usuarios.size();i++){
            Usuario auxUsuario=(Usuario)usuarios.get(i);
            if(usuario.getIdentificacion().equals(auxUsuario.getIdentificacion())){
                JOptionPane.showMessageDialog(null, "El usuario ingresado ya existe");
            }else{
                usuarios.add(usuario);
            }
        }
    }
    
    public String consultarUsuario(String numero,String identificacion, String nombre, String direccion, String fecha, String saldo){
        boolean existe=false;
        String respuesta="Numero/Identificacion/Nombre/Direccion/Fecha/Saldo";
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario=(Usuario) usuarios.get(i);
            if(usuario.getDireccion().equals(direccion)||usuario.getFecha().equals(fecha)||usuario.getIdentificacion().equals(direccion)||usuario.getNombre().equals(nombre)||usuario.getNumero().equals(numero)||usuario.getSaldo().equals(saldo)){
                respuesta+="\n"+usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo();
                existe=true;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "No existe ningun Usuario con esas datos");
        }
        return respuesta;
    }
    
    public String listarUsuarios(){
        String respuesta="Numero/Identificacion/Nombre/Direccion/Fecha/Saldo";
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario=(Usuario) usuarios.get(i);
            respuesta+="\n"+usuario.getNumero()+"/"+usuario.getIdentificacion()+"/"+usuario.getNombre()+"/"+usuario.getDireccion()+"/"+usuario.getFecha()+"/"+usuario.getSaldo();
        }
        return respuesta;
    }
    
    public void agregarRuta(Ruta ruta){
        boolean existe=false;
        for(int i=0;i<rutas.size();i++){
            Ruta auxRuta=(Ruta)rutas.get(i);
            if(ruta.getNombre().equals(auxRuta.getNombre())){
                JOptionPane.showMessageDialog(null, "La ruta ingresado ya existe");
                existe=true;
            }
        }
        if(!existe){
            rutas.add(ruta);
        }
    }
    
    public String consultarRuta(String codigo,String nombre, String descripcion, String tipo){
        boolean existe=false;
        String respuesta="Codigo/Nombre/Descripcion/Tipo";
        for(int i=0;i<rutas.size();i++){
            Ruta ruta=(Ruta) rutas.get(i);
            if(ruta.getCodigo().equals(codigo)||ruta.getDescripcion().equals(descripcion)||ruta.getNombre().equals(nombre)||ruta.getTipo().equals(tipo)){
                respuesta+="\n"+ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getDescripcion()+"/"+ruta.getTipo();
                existe=true;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "No existe ningun bus con esas caracteristicas");
        }
        return respuesta;
    }
    
    public String listarRutas(){
        String respuesta="Codigo/Nombre/Descripcion/Tipo";
        for(int i=0;i<rutas.size();i++){
            Ruta ruta=(Ruta) rutas.get(i);
            respuesta+="\n"+ruta.getCodigo()+"/"+ruta.getNombre()+"/"+ruta.getDescripcion()+"/"+ruta.getTipo();
        }
        return respuesta;
    }
    
    public Ruta getRuta(String nombre){
    Ruta respuesta=new Ruta();
    for (int i=0; i< rutas.size(); i++){
        Ruta ruta= (Ruta) rutas.get(i);
        if(ruta.getNombre().equals(nombre)){
            rutas.set(i, ruta); 
            respuesta=(Ruta)rutas.get(i);
        }
    }
    return respuesta;
    }
    
    public void agregarBusRuta(Bus bus, Ruta ruta){
            ruta.agregarBus(bus);
    }
    
    public String consultarBusRuta(String placa,String modelo, String marca, String tipo, String capacidad, Ruta ruta){
        return ruta.consultarBus(placa, modelo, marca, tipo, capacidad);
    }
    
    public String listarBusesRuta(Ruta ruta){
        return ruta.listarBuses();
    }
    
    //Retorna el numero de Rutas registradas
    public int numeroRutas(){
    int respuesta=0;
        for (int i=0; i< rutas.size(); i++){
            respuesta+=1;
        }
    return respuesta;
    }
}
