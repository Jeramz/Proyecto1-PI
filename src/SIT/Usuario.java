/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIT;

/**
 *
 * @author Jesus
 */
public class Usuario {
    String numero,
           identificacion,
           nombre,
           direccion,
           fecha,
           saldo;
    
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
    
    public void setSaldo(String saldo){
        this.saldo=saldo;
    }
    
    public String getSaldo(){
        return saldo;
    }
}
