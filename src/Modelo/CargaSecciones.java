
package Modelo;

import Controlador.Productos;
import java.sql.*;
import Controlador.*;

public class CargaSecciones {
    Conexion miConexion;
    private ResultSet rs;
    
    public CargaSecciones()
    {
    miConexion=new Conexion();
    }
    
    public String ejecutaConsulta()
    {
      Productos miProducto=null;
      Connection accesoDB=miConexion.conexion();
      
        try {
            Statement secciones=accesoDB.createStatement();
            
            rs=secciones.executeQuery("SELECT SECCIÓN FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR01'");
            miProducto=new Productos();
            while (rs.next()) {                
                
              miProducto.setnSeccion(rs.getString(1));

            }
            rs.close();
        } catch (Exception e) {
        }
        return miProducto.getnSeccion();
    }
}
