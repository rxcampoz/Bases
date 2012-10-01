/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_user;

import javax.swing.JFrame;

/**
 *
 * @author Robinson
 */
public class Main {

     public static Ventanas Inicio = new Ventanas();
     public static Ventanas Modo_Usuario = new Ventanas();
     
      public static Ventanas Cliente = new Ventanas();
      public static Ventanas buscar_Pedido = new Ventanas();
      public static Ventanas modificar_Pedido = new Ventanas();
      public static Ventanas cancelar_Pedido = new Ventanas();
      public static Ventanas Ingresar_cliente = new Ventanas();
      
      public static Ventanas Borrar_cliente = new Ventanas();
       public static Ventanas modificar_cliente = new Ventanas();
     public static Ventanas ingresar_material = new Ventanas();
    public static void main(String[] args) {
        
        Inicio.ventana_Inicio();
        Inicio.ventana.setVisible(true);
       Modo_Usuario.ventana_Sistema_modo_usuario();
       
       Cliente.ventana_Cliente();
       buscar_Pedido.Ventana_Buscar_Pedido();
       modificar_Pedido.ventana_Modificar_Pedidos();
       cancelar_Pedido.ventana_Suspender_pedido();
        
       
        Borrar_cliente.ventana_Borrar_Cliente();
        modificar_cliente.ventana_modificar_Cliente();
       ingresar_material.ventana_Ingresar_material();

       /////////////////////////////////////////////////////////////////////////////////
       

        
    }

}
