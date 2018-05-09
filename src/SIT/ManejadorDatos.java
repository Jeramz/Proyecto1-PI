/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kdd
 */
public class ManejadorDatos {
    FachadaBD fachada;
    Connection conn;
    
    public ManejadorDatos(){
        fachada= new FachadaBD();
        
    }
    
        
    
    public void guardarDatos(ArrayList rutas, ArrayList usuarios){
        String sql_guardarRutas="";
        String sql_guardarUsuarios="";
        String sql_guardarBuses="";
        String sql_guardarDescuentos="";
        String sql_guardarRecargas="";
        int numFilas=0;
        
        //Guarda las rutas
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
        sql_guardarRutas="INSERT INTO rutas VALUES ('" +
                ruta.getCodigo() + "', '" + ruta.getNombre() +  "', '" +
                ruta.getTipo() + "', '" + ruta.getDescripcion() + "')";
        try{
            Statement sentencia=conn.createStatement();
            sentencia.executeUpdate(sql_guardarRutas);
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        }
        //Guarda los buses
        for(int i=0;i<rutas.size();i++){
            Ruta ruta= (Ruta) rutas.get(i);
        for(int j=0;j<ruta.buses.size();j++){
            Bus bus= (Bus) ruta.buses.get(j);
            sql_guardarBuses="INSERT INTO buses VALUES ('" +
                bus.getPlaca() + "', '" + bus.getModelo()+  "', '" +
                bus.getMarca() + "', '" + bus.getTipo()+"', '" +
                bus.getCapacidad() +"', '" + ruta.getCodigo() + "')";
            try{
            Statement sentencia1=conn.createStatement();
            sentencia1.executeUpdate(sql_guardarBuses);
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        }
        }
        //Guarda los usuarios
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
            sql_guardarUsuarios="INSERT INTO usuarios VALUES ('" +
                usuario.getNumero() + "', '" + usuario.getIdentificacion()+  "', '" +
                usuario.getNombre() + "', '" + usuario.getDireccion()+"', '" +
                usuario.getFecha() +"', " + usuario.getSaldo() + ")";
            try{
            Statement sentencia2=conn.createStatement();
            sentencia2.executeUpdate(sql_guardarUsuarios);
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        }
        //Guarda los descuentos
        String descuentos[];
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
            for(int j=0;j<usuario.fechaDescuento.size();j++){
                String fechaDescuento= (String) usuario.fechaDescuento.get(j);
                descuentos=fechaDescuento.split("/");
                
                sql_guardarDescuentos="INSERT INTO recargas VALUES ('" +
                    usuario.getIdentificacion() + "', '" + (descuentos[0]+"/"+descuentos[1]+""+descuentos[2])+  "', " +
                    descuentos[3] + ")";
                
                try{
                    Statement sentencia3=conn.createStatement();
                    sentencia3.executeUpdate(sql_guardarDescuentos);
            
                }
                catch(SQLException e){
                    System.out.println(e); 
                }
                catch(Exception e){ 
                    System.out.println(e);
                }
            }
                
        }
        
        //Guarda las recargas
        String recargas[];
        for(int i=0;i<usuarios.size();i++){
            Usuario usuario= (Usuario) usuarios.get(i);
        for(int j=0;j<usuario.fechaRecarga.size();j++){
            String fechaRecarga= (String) usuario.fechaRecarga.get(j);
            recargas=fechaRecarga.split("/");
            sql_guardarRecargas="INSERT INTO descuentos VALUES ('" +
                    usuario.getIdentificacion() + "', '" + fechaRecarga+  "', " +
                    recargas[3] + ")";
            
            try{
                    Statement sentencia4=conn.createStatement();
                    sentencia4.executeUpdate(sql_guardarRecargas);
            
                }
                catch(SQLException e){
                    System.out.println(e); 
                }
                catch(Exception e){ 
                    System.out.println(e);
                }
        }
        }
        
    }//fin guardar
    
    public void  CargarDatos(SIT miSIT){
        
        String sql_selectRutas,sql_selectBus,sql_selectUsuarios,sql_selectDescuento,sql_selectRecarga;
        sql_selectRutas="SELECT codigo, nombre,nivel, num_creditos FROM  programa ";
        sql_selectBus="SELECT codigo, nombre,nivel, num_creditos FROM  programa ";
        sql_selectUsuarios="SELECT codigo, nombre,nivel, num_creditos FROM  programa ";
        sql_selectDescuento="SELECT codigo, nombre,nivel, num_creditos FROM  programa ";
        sql_selectRecarga="SELECT codigo, nombre,nivel, num_creditos FROM  programa ";
         try{
           
            System.out.println("consultando Rutas en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tablaRutas = sentencia.executeQuery(sql_selectRutas);
            
            while(tablaRutas.next()){                            
               Ruta ruta=new Ruta();
               ruta.setCodigo(tablaRutas.getString(1));
               ruta.setNombre(tablaRutas.getString(2));
               ruta.setTipo(tablaRutas.getString(3));
               ruta.setDescripcion(tablaRutas.getString(4));
               
               miSIT.agregarRuta(ruta);
               
            }
            
            System.out.println("consultando Buses en la base de datos");
            Statement sentencia1 = conn.createStatement();
            for(int i=0;i<miSIT.rutas.size();i++){
                
                ResultSet tablaBus = sentencia1.executeQuery(sql_selectBus);
                    Ruta ruta = (Ruta)miSIT.rutas.get(i);
            while(tablaBus.next()){     
                
               if(tablaBus.getString(6).equals(ruta.getCodigo())){
               }
               Bus bus=new Bus();
               bus.setPlaca(tablaBus.getString(1));
               bus.setModelo(tablaBus.getString(2));
               bus.setMarca(tablaBus.getString(3));
               bus.setTipo(tablaBus.getString(4));
               bus.setCapacidad(tablaBus.getString(5));
               
               miSIT.agregarBusRuta(bus, ruta);
                }
            }
            
            System.out.println("consultando Usuarios en la base de datos");
            Statement sentencia2 = conn.createStatement();
            ResultSet tablaUsuarios = sentencia2.executeQuery(sql_selectRutas);
            
            Statement sentencia3 = conn.createStatement();
            
            
            Statement sentencia4 = conn.createStatement();
            
            
            while(tablaUsuarios.next()){                            
               Usuario usuario=new Usuario();
               usuario.setNumero(tablaUsuarios.getString(1));
               usuario.setIdentificacion(tablaUsuarios.getString(2));
               usuario.setNombre(tablaUsuarios.getString(3));
               usuario.setDireccion(tablaUsuarios.getString(4));
               usuario.setFecha(tablaUsuarios.getString(5));
               usuario.setSaldo(tablaUsuarios.getFloat(6));
               ResultSet tablaDescuentos = sentencia3.executeQuery(sql_selectRutas);
               while(tablaDescuentos.next()){  
                   if(tablaDescuentos.getString(1).equals(usuario.getIdentificacion())){
                       usuario.addDescuento(tablaDescuentos.getString(3));
                   }
               }
               ResultSet tablaRecargas = sentencia4.executeQuery(sql_selectRutas);
               while(tablaRecargas.next()){  
                   if(tablaRecargas.getString(1).equals(usuario.getIdentificacion())){
                       usuario.addRecarga(tablaRecargas.getString(3));
                   }
               }
               miSIT.agregarUsuario(usuario);
               
            }
           
          
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        
    }
    
    
    public void abrirConexionBD(){
        conn= fachada.getConnetion();
        
    }
    public void cerrarConexionBD(){
        fachada.closeConection(conn);
        
    }
}
