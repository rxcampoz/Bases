/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;
import java.sql.*;
/**
 *
 * @author Owner
 */
public class Conexion {

    Connection conx;
    String url;
    String usuarioDB;
    String passwordDB;
    Statement stm;
    ResultSet rs;

    public Conexion()	{
    //elimina el constructor por defecto
    }

    public Conexion(Connection conx, String ur, String user, String pwd, Statement stm, ResultSet rs) {
        this.conx = conx;
        this.url = ur;
        this.usuarioDB = user;
        this.passwordDB = pwd;
        this.stm = stm;
        this.rs = rs;
    }

    public void abrirConexion(){
    try	{
        //Especificar Driver
        Class.forName("oracle.jdbc.OracleDriver");
        //Obtener conexión 1521
        conx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","proyecto","linux");

       // conx = DriverManager.getConnection("jdbc:oracle:@localhost:1521:xe","system","system");

   }
   catch(ClassNotFoundException ex){
        System.out.println("DRIVER NO ENCONTRADO");
    }
    catch(SQLException ex){
        System.out.println("CONEXION NO ESTABLECIDA");
    }
    catch(Exception ex) {
            System.out.println("ERROR");
        }
    }

    public void cerrarConexion()throws SQLException {
        conx.close();
    }

    public Connection getConexion() {
        return conx;
    }
}
