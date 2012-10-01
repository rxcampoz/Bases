/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Registro_pedido;
import Listas.ListaRegistroPedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Diego
 */
public class Registro_pedidobd {
static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();


    public Registro_pedidobd() {
    }


    public void ingresar(Registro_pedido rp) throws SQLException{

        String query = "BEGIN pack_registro_pedido.ingreso(?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1,rp.getCedula_o_RUC());
        cst.setString(2,rp.getUsuario() );
             cst.setString(3, rp.getId_pedido());
        
        
        cst.execute();
        cst.close();


    }

    public void eliminar(String id_pedido) throws SQLException{

           String query = "BEGIN pack_pedido.eliminar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setString(1,id_pedido );
        cst.execute();
        cst.close();
        conexion.cerrarConexion();

     }

    public ListaRegistroPedido cargar() throws SQLException{
     ListaRegistroPedido lista = new ListaRegistroPedido();
        String query = "BEGIN pack_registro_pedido.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){

            lista.add(new Registro_pedido(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    ""
                    ));
        }
        conexion.cerrarConexion();
        return lista;


     }

}
