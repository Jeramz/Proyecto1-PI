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
public class Usuario {
    String numero,
           identificacion,
           nombre,
           direccion,
           fecha;
    ArrayList fechaRecarga=new ArrayList();
    ArrayList fechaDescuento=new ArrayList();
    double saldo,recarga,descuento;
    int cantidadViajes=0;

    public Usuario(){
    }

    public void setNumero(String numero){
        this.numero=numero;
    }

    public String getNumero(){
        return numero;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion=identificacion;
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setFecha(String fecha){
        this.fecha=fecha;
    }

    public String getFecha(){
        return fecha;
    }
    
    public void addDescuento(String descuento){
        fechaDescuento.add(descuento);
    }
    
    public void addRecarga(String recarga){
        fechaRecarga.add(recarga);
    }

    public void recarga(double valorRecarga, String fecha){
        saldo+=valorRecarga;
        recarga+=valorRecarga;
        fechaRecarga.add(fecha+"/"+valorRecarga);
        JOptionPane.showMessageDialog(null, "Recarga Realizada con exito");
    }

    public void descuento(double valorDescuento, String fecha){
        if(saldo<valorDescuento){
            JOptionPane.showMessageDialog(null, "No se pudo realizar el descuento, saldo insuficiente en la tarjeta");
        }else{
            saldo-=valorDescuento;
            descuento+=valorDescuento;
            fechaDescuento.add(fecha+"/"+valorDescuento);
            cantidadViajes+=1;
            JOptionPane.showMessageDialog(null, "Descuento Realizado con exito");
        }
    }

    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

    public double getSaldo(){
        return saldo;
    }
    
    public String getRecargasMes(String mes){
        String respuesta=identificacion+"/"+nombre+"\n";
        String fecha;
        String listaFecha[];
        for(int i=0;i<fechaRecarga.size();i++){
            fecha=(String)fechaRecarga.get(i);
            listaFecha=fecha.split("/");
            if(listaFecha[1].equals(mes)){
            respuesta+=fechaRecarga.get(i)+"\n";
            }
        }
        return respuesta;
    }
    
    public double getRecaudadoMes(String mes){
        double respuesta=0;
        String fecha;
        String listaFecha[];
        for(int j=0;j<fechaRecarga.size();j++){
                fecha=(String)fechaRecarga.get(j);
                listaFecha=fecha.split("/");
                if(listaFecha[1].equals(mes)){
                    respuesta+=Double.parseDouble(listaFecha[3]);
                }
            }
        return respuesta;
    }
    
    public String getDescuentosMes(String mes){
        String respuesta=identificacion+"/"+nombre+"\n";
        String fecha;
        String listaFecha[];
        for(int i=0;i<fechaDescuento.size();i++){
            fecha=(String)fechaDescuento.get(i);
            listaFecha=fecha.split("/");
            if(listaFecha[1].equals(mes)){
            respuesta+=fechaDescuento.get(i)+"\n";
            }
        }
        return respuesta;
    }
    
    public double getGastadoMes(String mes){
        double respuesta=0;
        String fecha;
        String listaFecha[];
        for(int j=0;j<fechaDescuento.size();j++){
                fecha=(String)fechaDescuento.get(j);
                listaFecha=fecha.split("/");
                if(listaFecha[1].equals(mes)){
                    respuesta+=Double.parseDouble(listaFecha[3]);
                }
            }
        return respuesta;
    }

}
