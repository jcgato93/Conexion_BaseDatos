
package Controlador;

import java.sql.*;




public class Conexion {

    Connection miConexion=null;
    String db="pruebas";
    String url="jdbc:mysql://localhost:3306/"+db;
    String usuario="root";
    String contrasena="";
    
    public Conexion() {
    }
   
    
 /**
  * 
  * @return conexion a la vase de datos 
  */   
public Connection conexion()
{
    try {
        
         miConexion = DriverManager.getConnection(url,usuario,contrasena);
        
    } catch (Exception e) {
        System.out.print(db);
    }
    return miConexion;
  
}
    
}
