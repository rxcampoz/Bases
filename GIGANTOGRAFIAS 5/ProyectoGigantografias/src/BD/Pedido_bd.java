/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Pedido;
import Listas.ListaPedidos;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Diego
 */
public class Pedido_bd {
     static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();

    public Pedido_bd(){}

    public void insertar(Pedido p) throws SQLException{
           float f  = (float)Float.valueOf(p.getCosto());
        String query = "BEGIN pack_pedido.ingreso(?,?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

System.out.println(f);
        cst.setString(1,p.getId_pedido() );
        cst.setString(2,p.getTipo() );
        cst.setFloat(3, f);
        cst.setString(4, p.getDescripcion());
        cst.setString(5, p.getEstado());
        cst.setDate(6, (Date) p.getFecha_ingreso());
        cst.setDate(7, (Date) p.getFecha_entrega());
        cst.execute();
        cst.close();
    }

    public Pedido buscar_id(String id_pedido) throws SQLException{
     Pedido p = new Pedido(id_pedido, "", "", "", "", null, null);
      String query = "BEGIN pack_pedido.buscar_id(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1,p.getId_pedido() );
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            p.setId_pedido((String)resultado.getString(1));

         }else{
         p.setId_pedido("");

         }

     conexion.cerrarConexion();
     return p;



    }

    public Pedido buscar(String id_pedido) throws SQLException{
     Pedido p = new Pedido();
      String query = "BEGIN pack_pedido.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1,id_pedido );
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            p = new Pedido((String)resultado.getString(1), (String)resultado.getString(2), (String)resultado.getString(3),(String)resultado.getString(4), (String)resultado.getString(5), (java.sql.Date)resultado.getDate(6), (java.sql.Date)resultado.getDate(7));

         }else{
         p.setId_pedido("");

         }

     conexion.cerrarConexion();
     return p;



    }


    public ListaPedidos cargar() throws SQLException{
     ListaPedidos lista = new ListaPedidos();
        String query = "BEGIN pack_pedido.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){
            lista.add(new Pedido(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (String)resultado.getString(3),
                    (String)resultado.getString(4),
                    (String)resultado.getString(5),
                    (java.sql.Date)resultado.getDate(6),
                    (java.sql.Date)resultado.getDate(7)
                    ));
        }
        conexion.cerrarConexion();
        return lista;


     }

    public void modificar(Pedido e) throws SQLException{

    String query = "BEGIN pack_pedido.modificar(?,?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1,e.getId_pedido());
        cst.setString(2, e.getTipo());
        cst.setFloat(3,Float.valueOf(e.getCosto()) );
        cst.setString(4, e.getDescripcion());
        cst.setString(5, e.getEstado());
        cst.setDate(6, (Date) e.getFecha_ingreso());
        cst.setDate(7, (Date) e.getFecha_entrega());

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

          public ListaPedidos cargar_intervalo_fecha(java.sql.Date fecha1 , java.sql.Date fecha2) throws SQLException{
     ListaPedidos lista = new ListaPedidos();
        String query = "BEGIN pack_pedido.intervalo_fecha(?,?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setDate(1, fecha1);
        cst.setDate(2, fecha2);
        cst.registerOutParameter(3, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(3);
        while(resultado.next()){
            lista.add(new Pedido(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (String)resultado.getString(3),
                    (String)resultado.getString(4),
                    (String)resultado.getString(5),
                    (java.sql.Date)resultado.getDate(6),
                    (java.sql.Date)resultado.getDate(7)
                    ));
        }
        conexion.cerrarConexion();
        return lista;


     }


}
