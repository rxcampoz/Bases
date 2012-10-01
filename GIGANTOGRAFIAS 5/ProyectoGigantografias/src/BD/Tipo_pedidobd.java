/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Tipo_pedido;
import Listas.ListaTipoPedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Diego
 */
public class Tipo_pedidobd {

    static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();
    public Tipo_pedidobd(){}



    public  void ingresar(Tipo_pedido tp) throws SQLException{
        String query = "BEGIN pack_tipo_pedido.ingreso(?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1,tp.getId_tipo_pedido() );
        cst.setString(2,tp.getNombre());
        cst.setFloat(3,tp.getCosto());
        cst.setString(4,tp.getDescripcion() );
        
        cst.execute();
        cst.close();


    }


    public ListaTipoPedido cargar() throws SQLException{
     ListaTipoPedido lista = new ListaTipoPedido();
        String query = "BEGIN pack_tipo_pedido.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){
            lista.add(new Tipo_pedido(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (float)resultado.getFloat(3),
                    (String)resultado.getString(4)));
        }
        conexion.cerrarConexion();
        return lista;


     }


    public Tipo_pedido buscar(String id) throws SQLException{
         Tipo_pedido cli = new Tipo_pedido();
         System.out.println("dentro del bd");
      String query = "BEGIN pack_tipo_pedido.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1, id);
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);
          
         if(resultado.next()){
             
            cli = new Tipo_pedido(resultado.getString(1),resultado.getString(2) ,resultado.getFloat(3) ,resultado.getString(4));

         }else{
            //JOptionPane.showMessageDialog(null,"No se encontro\n ninguna coinsidencia");


         }

     conexion.cerrarConexion();
     return cli;
     }




}
