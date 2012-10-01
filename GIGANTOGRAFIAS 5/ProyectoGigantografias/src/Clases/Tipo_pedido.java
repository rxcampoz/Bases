/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Tipo_pedidobd;
import Listas.ListaTipoPedido;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Tipo_pedido {

               String  id_tipo_pedido ;
                String nombre ;
              float    costo ;

    
            String 	descripcion ;

        public Tipo_pedido(){
           id_tipo_pedido ="";
                 nombre ="";
                  costo =0;
             	descripcion="" ;

        }

         public Tipo_pedido(String  id_tipo_pedido,String nombre, float    costo , String descripcion ){
           this.id_tipo_pedido = id_tipo_pedido;
                 this.nombre =nombre;
                  this.costo =costo;
             	this.descripcion=descripcion ;

        }


        public static void ingresar_tipo_pedido_a_la_bd(Tipo_pedido tp) throws SQLException{

        Tipo_pedidobd tp_bd = new Tipo_pedidobd();

        tp_bd.ingresar(tp);


        }

        public static ListaTipoPedido Mostrar_Tipo_pedido(ListaTipoPedido l) throws SQLException{

        Tipo_pedidobd tp_bd = new Tipo_pedidobd();
            l = tp_bd.cargar();
        return l ;
        }

        public static Tipo_pedido buscar_tipo_pedido_id(String id) throws SQLException{
        Tipo_pedido tp = new Tipo_pedido();
        Tipo_pedidobd p = new Tipo_pedidobd();
 
        tp = p.buscar(id);
            System.out.println(tp.getCosto());





        return tp ;
        }


























         public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_tipo_pedido() {
        return id_tipo_pedido;
    }

    public void setId_tipo_pedido(String id_tipo_pedido) {
        this.id_tipo_pedido = id_tipo_pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
