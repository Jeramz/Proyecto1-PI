/*
  Clase Bus: le asigna valores a la placa, modelo, marca tipo y capacidad del bus.
  Del mismo modo los retorna

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 10 mayo 2018
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
