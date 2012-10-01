/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Registro_pedidobd;
import Listas.ListaRegistroPedido;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Registro_pedido {

    String cedula_o_RUC ;
String usuario ;
	String		id_pedido ;
    public Registro_pedido() {
    }

    public Registro_pedido(String cedula,String usuario,String id_pedido) {
        this.cedula_o_RUC=cedula;
        this.usuario=usuario;
        this.id_pedido=id_pedido;
    }

    public static void ingresar_registro_pedido(Registro_pedido p) throws SQLException{

        Registro_pedidobd rp = new Registro_pedidobd();
        rp.ingresar(p);
        
    }

    public static void borrar_registro_pedido(String p) throws SQLException{

        Registro_pedidobd rp = new Registro_pedidobd();
        rp.eliminar(p);


    }

    public static ListaRegistroPedido Mostrar(ListaRegistroPedido rp) throws SQLException{
        Registro_pedidobd rp_bd = new Registro_pedidobd();
        rp = rp_bd.cargar();

        return rp ;
    }




























    public String getCedula_o_RUC() {
        return cedula_o_RUC;
    }

    public void setCedula_o_RUC(String cedula_o_RUC) {
        this.cedula_o_RUC = cedula_o_RUC;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
