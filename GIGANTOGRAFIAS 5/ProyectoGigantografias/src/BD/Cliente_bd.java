/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Cliente;
import Listas.ListaClientes;
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
public class Cliente_bd {
    static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();

    public Cliente_bd(){}

     public void insertar(Cliente cliente) throws SQLException{
        String query = "BEGIN pack_cliente.ingreso(?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

         
        cst.setString(1, cliente.getNombre());
        cst.setString(2, cliente.getApellido());
        cst.setString(3, cliente.getCedula_o_RUC());
        cst.setString(4, cliente.getTelefono());
        cst.execute();
        cst.close();
    }

     public Cliente buscar(String cedula_o_ruc) throws SQLException{
         Cliente cli = new Cliente(null,null,null,null);
      String query = "BEGIN pack_cliente.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
       
        cst.setString(1, cedula_o_ruc);
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            cli = new Cliente(resultado.getString(1),resultado.getString(2) ,resultado.getString(3) ,resultado.getString(4));

         }else{
            JOptionPane.showMessageDialog(null,"No se encontro\n ninguna coinsidencia");
           

         }

     conexion.cerrarConexion();
     return cli;
     }


     public void Modificar(Cliente c) throws SQLException{

     String query = "BEGIN pack_cliente.modificar(?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

         
        cst.setString(1, c.getNombre());
        cst.setString(2, c.getApellido());
        cst.setString(3, c.getCedula_o_RUC());
        cst.setString(4, c.getTelefono());
        cst.execute();
        cst.close();



     }

     public ListaClientes cargar() throws SQLException{
     ListaClientes lista = new ListaClientes();
        String query = "BEGIN pack_cliente.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){
            lista.add(new Cliente(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (String)resultado.getString(3),
                    (String)resultado.getString(4)));
        }
        conexion.cerrarConexion();
        return lista;

     
     }

     public void borrar( String cedula_o_RUC) throws SQLException{

        String query = "BEGIN pack_cliente.eliminar(?);END;";
System.out.println(cedula_o_RUC);
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setString(1,cedula_o_RUC );
        cst.execute();
        cst.close();
        conexion.cerrarConexion();



     }






}
