/*
  Clase ManejadorDatos: guarda los datos del programa (buses, rutas, usuarios) en sus respectivas tablas 
  en una base de datos,se encargar de abrir y cerrar la conexión con la base de datos
  Además, carga la información que se encuentra en la base de datos para ser usados en el programa.

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 10 mayo 2018
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
            if(!(this.existe(ruta.getCodigo(), "rutas"))){
        sql_guardarRutas="INSERT INTO rutas VALUES ('" +
                ruta.getCodigo() + "', '" + ruta.getNombre() +  "', '" +
                ruta.getTipo() + "', '" + ruta.getDescripcion() + "')";
            }
        try{
            Statement sentencia0=conn.createStatement();
            sentencia0.executeUpdate(sql_guardarRutas);
            
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
            if(!(this.existe(bus.getPlaca(), "buses"))){
            sql_guardarBuses="INSERT INTO buses VALUES ('" +
                bus.getPlaca() + "', '" + bus.getModelo()+  "', '" +
                bus.getMarca() + "', '" + bus.getTipo()+"', '" +
                bus.getCapacidad() +"', '" + ruta.getCodigo() + "')";
            }
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
            if(!(this.existe(usuario.getIdentificacion(), "usuarios"))){
            sql_guardarUsuarios="INSERT INTO usuarios VALUES ('" +
                usuario.getNumero() + "', '" + usuario.getIdentificacion()+  "', '" +
                usuario.getNombre() + "', '" + usuario.getDireccion()+"', '" +
                usuario.getFecha() +"', " + usuario.getSaldo() + ")";
            }else{
                sql_guardarUsuarios="update usuarios set saldo= " + usuario.getSaldo() + "where identificacion= '" + usuario.getIdentificacion() + "';";
            }
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
                if(!(this.existe((descuentos[0]+"/"+descuentos[1]+"/"+descuentos[2]), "descuentos"))){
                sql_guardarDescuentos="INSERT INTO descuentos VALUES ('" +
                    usuario.getIdentificacion() + "', '" + (descuentos[0]+"/"+descuentos[1]+"/"+descuentos[2])+  "', " +
                    descuentos[3] + ")";
                
                }
                
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
            if(!(this.existe((recargas[0]+"/"+recargas[1]+"/"+recargas[2]), "recargas"))){
            sql_guardarRecargas="INSERT INTO recargas VALUES ('" +
                    usuario.getIdentificacion() + "', '" + (recargas[0]+"/"+recargas[1]+"/"+recargas[2])+  "', " +
                    recargas[3] + ")";
            
            
            }
            
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
    public boolean existe(String primaryKey, String tabla){
        boolean respuesta=false;
        String sql_selectRutas,sql_selectBus,sql_selectUsuarios,sql_selectDescuento,sql_selectRecarga;
        sql_selectRutas="SELECT codigo, nombre,tipo, descripcion FROM  rutas ";
        sql_selectBus="SELECT placa, modelo,marca, tipo,capacidad,rutaBus FROM  buses ";
        sql_selectUsuarios="SELECT numero, identificacion,nombre, direccion, fecha,saldo FROM  usuarios ";
        sql_selectDescuento="SELECT identificacionUsuario, fechaDescuento,valorDescuento FROM  descuentos ";
        sql_selectRecarga="SELECT identificacionUsuario, fechaRecarga,valorRecarga FROM  recargas ";
        try{
            
        if(tabla.equals("rutas")){
            Statement sentencia0 = conn.createStatement();
            ResultSet tablaRutas = sentencia0.executeQuery(sql_selectRutas);
        while(tablaRutas.next()){                            
               if(tablaRutas.getString(1).equals(primaryKey)){
               respuesta=true;
               }
            }
        }
        
        if(tabla.equals("buses")){
            Statement sentencia1 = conn.createStatement();
            ResultSet tablaBus = sentencia1.executeQuery(sql_selectBus);
            while(tablaBus.next()){     
                
               if(tablaBus.getString(1).equals(primaryKey)){
                   respuesta=true;
               }
                }
        }
        
        if(tabla.equals("usuarios")){
            Statement sentencia2 = conn.createStatement();
            ResultSet tablaUsuarios = sentencia2.executeQuery(sql_selectUsuarios);
            while(tablaUsuarios.next()){         
               if(tablaUsuarios.getString(2).equals(primaryKey)){
                   respuesta=true;
               }
            }
        }
        
        if(tabla.equals("descuentos")){
            Statement sentencia3 = conn.createStatement();
            ResultSet tablaDescuentos = sentencia3.executeQuery(sql_selectDescuento);
            while(tablaDescuentos.next()){         
               if(tablaDescuentos.getString(2).equals(primaryKey)){
                   respuesta=true;
               }
            }
        }
        
        if(tabla.equals("recargas")){
            Statement sentencia4 = conn.createStatement();
            ResultSet tablaRecargas = sentencia4.executeQuery(sql_selectRecarga);
            while(tablaRecargas.next()){         
               if(tablaRecargas.getString(2).equals(primaryKey)){
                   respuesta=true;
               }
            }
        }
        
        }catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return respuesta;
    }
    public void  CargarDatos(SIT miSIT){
        
        String sql_selectRutas,sql_selectBus,sql_selectUsuarios,sql_selectDescuento,sql_selectRecarga;
        sql_selectRutas="SELECT codigo, nombre,tipo, descripcion FROM  rutas ";
        sql_selectBus="SELECT placa, modelo,marca, tipo,capacidad,rutaBus FROM  buses ";
        sql_selectUsuarios="SELECT numero, identificacion,nombre, direccion, fecha,saldo FROM  usuarios ";
        sql_selectDescuento="SELECT identificacionUsuario, fechaDescuento,valorDescuento FROM  descuentos ";
        sql_selectRecarga="SELECT identificacionUsuario, fechaRecarga,valorRecarga FROM  recargas ";
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
                   Bus bus=new Bus();
               bus.setPlaca(tablaBus.getString(1));
               bus.setModelo(tablaBus.getString(2));
               bus.setMarca(tablaBus.getString(3));
               bus.setTipo(tablaBus.getString(4));
               bus.setCapacidad(tablaBus.getString(5));
               miSIT.agregarBusRuta(bus, ruta);
               }
               
               
               
                }
            }
            
            System.out.println("consultando Usuarios en la base de datos");
            Statement sentencia2 = conn.createStatement();
            ResultSet tablaUsuarios = sentencia2.executeQuery(sql_selectUsuarios);
            
            while(tablaUsuarios.next()){                            
               Usuario usuario=new Usuario();
               usuario.setNumero(tablaUsuarios.getString(1));
               usuario.setIdentificacion(tablaUsuarios.getString(2));
               usuario.setNombre(tablaUsuarios.getString(3));
               usuario.setDireccion(tablaUsuarios.getString(4));
               usuario.setFecha(tablaUsuarios.getString(5));
               usuario.setSaldo(tablaUsuarios.getFloat(6));
               
               
               miSIT.agregarUsuario(usuario);
               
            }
            
            Statement sentencia3 = conn.createStatement();
            Statement sentencia4 = conn.createStatement();
           
            for(int i=0;i<miSIT.usuarios.size();i++){
                 ResultSet tablaDescuentos = sentencia3.executeQuery(sql_selectDescuento);
                 ResultSet tablaRecargas = sentencia4.executeQuery(sql_selectRecarga);
                Usuario usuario=(Usuario)miSIT.usuarios.get(i);
            while(tablaDescuentos.next()){  
                   if(tablaDescuentos.getString(1).equals(usuario.getIdentificacion())){
                       usuario.addDescuento(tablaDescuentos.getString(2)+"/"+tablaDescuentos.getString(3));
                       miSIT.usuarios.set(i, usuario);
                   }
               }
            while(tablaRecargas.next()){  
                   if(tablaRecargas.getString(1).equals(usuario.getIdentificacion())){
                       usuario.addRecarga(tablaRecargas.getString(2)+"/"+tablaRecargas.getString(3));
                       miSIT.usuarios.set(i, usuario);
                   }
            }
            
            
            
            
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
