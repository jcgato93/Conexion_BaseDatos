
package conexion_basedatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MetaDatos {

  
    public static void main(String[] args) throws SQLException {
       
        
        MetaDatos datos=new MetaDatos();
        datos.mostrarInfo_DB();
    }
    
    
    public void mostrarInfo_DB() throws SQLException
    {  
        
        Connection  miConexion=null; 
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            
            //Obtencion de MetaDatos
            DatabaseMetaData datosBBDD=miConexion.getMetaData();
            
            //Mostrar info de la base de datos
            
            String Gestor=datosBBDD.getDatabaseProductName();//devuelve el nombre del gestor de base de datos
            
            String version=datosBBDD.getDatabaseProductVersion();//version del gestor
            
            String driver=datosBBDD.getDriverName();//Driver
            
            String driverVersion=datosBBDD.getDriverVersion();//Version del driver
            
          
            
            
            
        } catch (Exception e) {
        }
        finally{
        miConexion.close();
        }
     
    
    
    }
}
