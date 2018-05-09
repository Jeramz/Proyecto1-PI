/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SIT;

/**
 *
 * @author Oswaldo
 */
import java.sql.*;
public class FachadaBD {
        String url, usuario, password;
        Connection conexion =null;
        Statement instruccion;
        ResultSet tabla;
        FachadaBD(){
            url="jdbc:postgresql://pgsql2/201731388";
            usuario="201731388";
            password="201731388";
        }
        
        

        public Connection conectar(){
            try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.out.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.out.println( "Conexion  exitosa con la base de datos" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.out.println( "Error: No se pudo conectar a la Base de datos" );
                return null;
             }

        }//end connectar

        public Connection getConnetion(){
            if (conexion == null) {
                return this.conectar();
            }
            else{
                  return conexion;      
            }
            
        }
        
        public void closeConection(Connection c){
            try{
                if (conexion != null){
                    c.close();
                }
                 
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar." );
            }
        }
}//end class
