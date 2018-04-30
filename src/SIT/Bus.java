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
public class Bus {
    String placa, 
           modelo, 
           marca,
           tipo,
           capacidad;
    
    public Bus(){
    }
    
    public void setPlaca(String placa){
        this.placa=placa;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setMarca(String marca){
        this.marca=marca;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    
    public String getTipo(){
       return tipo;
    }
    
    public void setCapacidad(String capacidad){
        this.capacidad=capacidad;
    }
    
    public String getCapacidad(){
        return capacidad;
    }
    
    
}
