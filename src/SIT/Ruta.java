/*
  Clase Ruta: Le asigna los valores basicos a una ruta (codigo, nombre,descripción, tipo), así como también los retorna.
  agregar buses a la ruta, permite consultar si un bus se encuentra en la ruta, lista todos los buses que se encuentren en la ruta

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 10 mayo 2018
 */
package SIT;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Ruta {
    String codigo,
           nombre,
           descripcion,
           tipo;
    Bus miBus=new Bus();
    ArrayList buses=new ArrayList();

    public Ruta(){
    }

    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void agregarBus(Bus bus){
        boolean existe=false;
        if(bus.getCapacidad().equals("")||bus.getMarca().equals("")||bus.getModelo().equals("")||bus.getPlaca().equals("")||bus.getTipo().equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Adverntecia",JOptionPane.WARNING_MESSAGE);
        }else{
            for(int i=0;i<buses.size();i++){
                Bus auxBus= (Bus)buses.get(i);
                if(auxBus.getPlaca().equals(bus.getPlaca())){
                    JOptionPane.showMessageDialog(null, "El bus ingresado ya existe","Error",JOptionPane.ERROR_MESSAGE);
                    existe=true;
                }
            }
            if(!existe){
                buses.add(bus);
            }
        }
    }

    public String consultarBus(String placa,String modelo, String marca, String tipo, String capacidad){
        boolean existe=false;
        String respuesta="Placa/Modelo/Marca/Tipo/Capacidad/Ruta";
        for(int i=0;i<buses.size();i++){
            Bus bus=(Bus) buses.get(i);
            if(placa.equals(bus.getPlaca())||modelo.equals(bus.getModelo())||marca.equals(bus.getMarca())||tipo.equals(bus.getTipo())||capacidad.equals(bus.getCapacidad())){
                respuesta+="\n"+bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+this.nombre;
                existe=true;
            }
        }
        if(!existe){
            JOptionPane.showMessageDialog(null, "No existe ningun bus con esas caracteristicas","Error",JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }

    public String listarBuses(){
        String respuesta="";
  
        for(int i=0;i<buses.size();i++){
            Bus bus=(Bus) buses.get(i);
            respuesta+="\n"+bus.getPlaca()+"/"+bus.getModelo()+"/"+bus.getMarca()+"/"+bus.getTipo()+"/"+bus.getCapacidad()+"/"+this.nombre;
        }
        
        return respuesta;
    }
}
