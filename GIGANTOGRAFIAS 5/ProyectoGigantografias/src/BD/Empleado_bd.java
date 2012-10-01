/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Empleado;
import Listas.ListaEmpleados;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Robinson
 */
public class Empleado_bd {
    static  Empleado usuario_del_sistema = new Empleado();
    static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();

    public Empleado_bd() {



    }

    public boolean es_empleado(String usuario,String password)throws SQLException{
       
        String query = "BEGIN pack_empleado.ingresar_sistema(?,?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setString(1,usuario);
        cst.setString(2,password);
        cst.registerOutParameter(3, OracleTypes.CURSOR);
        cst.execute();
        


       resultado = ((OracleCallableStatement)cst).getCursor(3);
       if(resultado.next()){
          
       usuario_del_sistema = new Empleado(resultado.getString(1),
               resultado.getString(2),
               resultado.getString(3),
               resultado.getString(4),
               resultado.getString(5),
               resultado.getString(6),
               resultado.getString(7),
               resultado.getString(8),
               resultado.getString(9));
       
       return true ;
       }


       return false;
    }

 public Empleado buscar(String usuario) throws SQLException{
      
         Empleado cli = new Empleado();
      String query = "BEGIN pack_empleado.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1, usuario);
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            cli = new Empleado((String)resultado.getString(1),(String)resultado.getString(2) ,(String)resultado.getString(3) ,(String)resultado.getString(4),(String)resultado.getString(5),(String)resultado.getString(6) ,(String)resultado.getString(7) ,(String)resultado.getString(8),(String)resultado.getString(9));

         }else{

          return  cli = new Empleado("", "","","", "", "", "", "","");

         }
                              
     conexion.cerrarConexion();
     return cli;
     }

 public Empleado buscarXcedula(String cedula) throws SQLException{
         Empleado cli = new Empleado(null,null,null,null,null,null,null,null,null);
      String query = "BEGIN pack_empleado.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1, cedula);
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            cli = new Empleado(resultado.getString(1),resultado.getString(2) ,resultado.getString(3) ,resultado.getString(4),resultado.getString(5),resultado.getString(6) ,resultado.getString(7) ,resultado.getString(8),resultado.getString(9));

         }else{
            JOptionPane.showMessageDialog(null,"No se encontro\n ninguna coinsidencia");


         }

     conexion.cerrarConexion();
     return cli;
     }

 public void insertar(Empleado empleado) throws SQLException{
        String query = "BEGIN pack_empleado.ingreso(?,?,?,?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1, empleado.getUsuario());
        cst.setString(2, empleado.getPassword());
        cst.setString(3, empleado.getNombre());
        cst.setString(4, empleado.getApellido());
        cst.setString(5, empleado.getCedula());
        cst.setString(6, empleado.getDireccion());
        cst.setString(7, empleado.getTelefono());
        cst.setString(8, empleado.getDepartamento());
        cst.setString(9, empleado.getTipo());
        cst.execute();
        cst.close();

    }

 public void Modificar(Empleado e) throws SQLException{

     String query = "BEGIN pack_empleado.modificar(?,?,?,?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1, e.getUsuario());
        cst.setString(2, e.getPassword());
        cst.setString(3,e.getNombre());
        cst.setString(4, e.getApellido());
        cst.setString(5, e.getCedula());
        cst.setString(6, e.getDireccion());
        cst.setString(7, e.getTelefono());
        cst.setString(8, e.getDepartamento());
        cst.setString(9, e.getTipo());
        cst.execute();
        cst.close();



     }

 public ListaEmpleados cargar() throws SQLException{
     ListaEmpleados lista = new ListaEmpleados();
        String query = "BEGIN pack_empleado.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){
            lista.add(new Empleado(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (String)resultado.getString(3),
                    (String)resultado.getString(4),
                    (String)resultado.getString(5),
                    (String)resultado.getString(6),
                    (String)resultado.getString(7),
                    (String)resultado.getString(8),
                    (String)resultado.getString(9)));
        }
        conexion.cerrarConexion();
        return lista;


     }

 public void borrar( String usuario) throws SQLException{

        String query = "BEGIN pack_empleado.eliminar(?);END;";
System.out.println(usuario);
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setString(1,usuario );
        cst.execute();
        cst.close();
        conexion.cerrarConexion();



     }


}
