
package conexion_basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CRUD_SQL {


    public static void main(String[] args) {
         Connection  miConexion=null; 
        try {
            
            //1. Crear Conexion
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            
            //2. Crear un objeto de tipo Statement para enviar consultas Sql a la base de datos 
            
            Statement miStatement=miConexion.createStatement();
            
            //==================INSERT  ======================================================
            String query="INSERT INTO productos(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES('AR77','PANTALON',25.33)";
            
            miStatement.executeUpdate(query);//EJECUTA LA QUERY

            miConexion.close();
            miStatement=null;
            
            
            //====================UPDATE=========================================================
            query="UPDATE productos SET NOMBREARTÍCULO='CAMISA',PRECIO=26.40 WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(query);
            
            miConexion.close();
            miStatement=null;
            
            
            //=======================DELETE ========================================
            query="DELETE FROM productos WHERE CÓDIGOARTÍCULO='AR77'";
            miStatement.executeUpdate(query);
            
            miConexion.close();
            miStatement=null;
            
            
            
        } catch (Exception e) {
             
            System.out.println("No conecta ");
             e.printStackTrace();   //muestra la causa del error
        
        }
        finally
        {
             try {
                 miConexion.close();
             } catch (SQLException ex) {
                 Logger.getLogger(CRUD_SQL.class.getName()).log(Level.SEVERE, null, ex);
             }
           
        }
    }
    
}
