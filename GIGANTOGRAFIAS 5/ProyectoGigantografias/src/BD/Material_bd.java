/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import Clases.Material;
import Listas.ListaMateriales;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Gabo
 */
public class Material_bd {
    static CallableStatement cst = null;
    static ResultSet resultado = null;
    Conexion conexion = new Conexion();

    public Material_bd(){}

       public Material buscartipo(String tipo) throws SQLException{
         Material mat = new Material(null,null,null,0,null,null);
      String query = "BEGIN pack_material.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1, tipo);
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            mat = new Material(resultado.getString(1),resultado.getString(2) ,resultado.getString(3),resultado.getFloat(4) ,resultado.getString(5),resultado.getString(6));

         }else{
            JOptionPane.showMessageDialog(null,"No se encontro\n ninguna coinsidencia");

         }
     conexion.cerrarConexion();
     return mat;
     }



     public Material buscar(String id_material) throws SQLException{
         Material mat = new Material(null,null,null,0,null,null);
      String query = "BEGIN pack_material.buscar(?,?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);

        cst.setString(1, id_material);
        
        cst.registerOutParameter(2, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(2);

         if(resultado.next()){
            mat = new Material(resultado.getString(1),resultado.getString(2) ,resultado.getString(3),resultado.getFloat(4) ,resultado.getString(5),resultado.getString(6));

         }else{
            JOptionPane.showMessageDialog(null,"No se encontro\n ninguna coinsidencia");


         }

     conexion.cerrarConexion();
     return mat;
     }

     public void Modificar(Material m) throws SQLException{

     String query = "BEGIN pack_material.modificar(?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1, m.getIdMaterial());
        cst.setString(2, m.getDescripcionM());
        cst.setString(3, m.getNombreM() );
        cst.setFloat(4, m.getCosto());
        cst.setString(5, m.getCantidad() );
        cst.setString(6, m.getTipo() );
        cst.execute();
        cst.close();
     }

         public ListaMateriales cargar() throws SQLException{
     ListaMateriales lista = new ListaMateriales();
        String query = "BEGIN pack_material.mostrar(?);END;";

        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        resultado = ((OracleCallableStatement)cst).getCursor(1);
        while(resultado.next()){
            lista.add(new Material(
                    (String)resultado.getString(1),
                    (String)resultado.getString(2),
                    (String)resultado.getString(3),
                    (Float)resultado.getFloat(4),
                    (String)resultado.getString(5),
                    (String)resultado.getString(6)));
        }
        conexion.cerrarConexion();
        return lista;
     }

      public void borrar( String id_material) throws SQLException{

        String query = "BEGIN pack_material.eliminar(?);END;";
System.out.println(id_material);
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);
        cst.setString(1,id_material );
        cst.execute();
        cst.close();
        conexion.cerrarConexion();

     }


      public void insertar(Material material) throws SQLException{
        String query = "BEGIN pack_material.ingreso(?,?,?,?,?,?); END;";
        conexion.abrirConexion();
        cst = conexion.getConexion().prepareCall(query);


        cst.setString(1, material.getIdMaterial());
        cst.setString(2, material.getDescripcionM());
        cst.setString(3, material.getNombreM() );
        cst.setFloat(4, material.getCosto());
        cst.setString(5, material.getCantidad() );
        cst.setString(6, material.getTipo() );
        cst.execute();
        cst.close();
    }




}
