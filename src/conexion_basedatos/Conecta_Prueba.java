
package conexion_basedatos;


import java.sql.*;



public class Conecta_Prueba {

 
    public static void main(String[] args) {
       
        try {
            
            //1. Crear Conexion
            Connection  miConexion;
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            
            //2. Crear un objeto de tipo Statement para enviar consultas Sql a la base de datos 
            
            Statement miStatement=miConexion.createStatement();
            
            
            
            //3. Ejecutar la instruccion Sql
            
            ResultSet miResultset=miStatement.executeQuery("SELECT * FROM productos");
            
            
            //4. Recorrer el ResultSet
                
            while (miResultset.next()) {//mientras exista otro registro!!

                System.out.println(miResultset.getString(1)+" "+miResultset.getString(2)+" "+miResultset.getString(3));                
         
            }
              

        } catch (Exception e) {
             
            System.out.println("No conecta ");
             e.printStackTrace();   //muestra la causa del error
            
        
        
        }
        
        
    }
    
}
