
package conexion_basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Transacciones {

    //Se usa cuando queremos ejecutar un bloque de consultas SQL 
    //que su transaccion a la base debe ser completa o no ejecutarse ninguna si alguna falla

    public static void main(String[] args) throws SQLException {
                Connection  miConexion=null; 
                 String query="";
        try {
            
            
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            
            miConexion.setAutoCommit(false);// Con este indicamos que se enviara un bloque de consulta SQL
            
            Statement miStatement=miConexion.createStatement();
            
      
             query="INSERT INTO productos(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES('AR77','PANTALON',25.33)";
            
            miStatement.executeUpdate(query);//EJECUTA LA QUERY

             query="INSERT INTO productos(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES('AR100','TEST',25.33)";
             
             miStatement.executeUpdate(query);//EJECUTA LA QUERY
             
             
             miConexion.commit();//si llega hasta este punto sin errores ...confirmara las instrucciones SQL
             
            
            miConexion.close();
            miStatement=null;
            
        }catch(Exception ex){
        
        miConexion.rollback();//asegura la integridad de los datos y deja intacta la base de datos
        
        }
        finally
        { 
            miConexion.close();           
        }
    }
    
}
