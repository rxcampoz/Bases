/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Pedido_bd;
import Listas.ListaPedidos;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ricardo
 */
public class Pedido {


 String id_pedido ;
String tipo ;
 String costo;
String  descripcion ;
String  estado ;
java.sql.Date  fecha_ingreso ;
java.sql.Date fecha_entrega ;

    public Pedido(){}

     public Pedido(String id_pedido , String tipo , String costo,String  descripcion,String  estado,java.sql.Date  fecha_ingreso ,java.sql.Date fecha_entrega ){
      this.id_pedido = id_pedido;
        this.tipo = tipo;
        this.costo = costo;
        this.descripcion = descripcion;
         this.estado = estado;
         this.fecha_ingreso =  fecha_ingreso;
        this.fecha_entrega =   fecha_entrega;

     }


     public static void Ingresar_pedido(String id_pedido ,String tipo , String costo,String  descripcion,String  estado,java.sql.Date  fecha_ingreso ,java.sql.Date fecha_entrega) throws SQLException{

         Pedido p = new Pedido(id_pedido,tipo, costo, descripcion, estado, fecha_ingreso, fecha_entrega);
         Pedido_bd p_bd = new Pedido_bd();
         p_bd.insertar(p);


     }

     public static boolean buscar_id(String id) throws SQLException{
        Pedido_bd p_bd = new Pedido_bd();
        Pedido p = new Pedido();
        p = p_bd.buscar_id(id);

        if(p.getId_pedido()!=""){
        return true ;
        }

     return false ;
     }

     public static Pedido buscar_pedido(String id_pedido) throws SQLException{
        Pedido pedido = new Pedido();

        Pedido_bd e_bd = new Pedido_bd();
        pedido = e_bd.buscar(id_pedido);



        return pedido ;
}

     public static void modificar_pedido(Pedido e) throws SQLException{
            Pedido_bd pbd = new Pedido_bd();
                pbd.modificar(e);

     }

     public static ListaPedidos Mostrar_pedidos(ListaPedidos c) throws SQLException{
    Pedido_bd c_bd = new Pedido_bd();
    c = c_bd.cargar();

    return c ;
    }

    public static void eliminar_pedido(String id_pedido) throws SQLException{

Pedido_bd pbd = new Pedido_bd() ;

pbd.eliminar(id_pedido);


    }







    public static ListaPedidos Mostrar_pedidos_intervalo_fecha(java.sql.Date fecha1 , java.sql.Date fecha2) throws SQLException{
    ListaPedidos c = new ListaPedidos();
        Pedido_bd c_bd = new Pedido_bd();
    c = c_bd.cargar_intervalo_fecha(fecha1, fecha2);

    return c ;
    }



    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(java.sql.Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(java.sql.Date fecha_ingreso) {
        this.fecha_ingreso =  fecha_ingreso;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }






}
