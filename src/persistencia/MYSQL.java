/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import modelos.*;
import java.sql.*;
        
/**
 *
 * @author Sandy
 */
public class MYSQL{
    private Connection conexion;
    static MYSQL instancia;
    
    public static MYSQL getInstance(){
        if(MYSQL.instancia == null){
            MYSQL.instancia = new MYSQL();
        }
        return MYSQL.instancia;
    }
    
    private MYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            Statement query = conexion.createStatement();
            query.execute("CREATE DATABASE /*!32312 IF NOT EXISTS*/`juegazo` /*!40100 DEFAULT CHARACTER SET latin1 */;");
            query.execute("" 
                    + "CREATE TABLE IF NOT EXISTS `juegazo`.`ganadores` ("
                    + "  `id` int NOT NULL AUTO_INCREMENT,"
                    + "  `nombre` varchar(50) DEFAULT NULL,"
                    + "  `puntos` int DEFAULT 0,"
                    + "  PRIMARY KEY (`id`)"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            conexion.close();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegazo", "root", "");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void guardarWinner(Jugador winner){
        try{
            String txt = "INSERT INTO ganadores(nombre,puntos) VALUES (?,?)";
            PreparedStatement query = conexion.prepareStatement(txt);
            query.setString(1, winner.getname());
            query.setInt(2, winner.getPuntos());
            query.execute();
        } catch (SQLException e){
            
        }
    }
    
    
}
