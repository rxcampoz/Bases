/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Cliente_bd;
import Listas.ListaClientes;
import java.sql.SQLException;

/**
 *
 * @author ricardo
 */
public class Cliente  {
                    String codigo ;
			String nombre ;
                      String  apellido ;
                       String cedula_o_RUC ;
                      String telefono ;
   
    
    public Cliente(){}


      public Cliente(String nombre ,String  apellido , String cedula_o_RUC ,String telefono ){
      
          this.nombre = nombre ;
           this.apellido = apellido ;
            this.cedula_o_RUC = cedula_o_RUC ;
             this.telefono = telefono ;
  }

public static void Ingresar_cliente(Cliente c) throws SQLException{
 

    Cliente_bd  c_db = new Cliente_bd();

    c_db.insertar(c);





}




public static Cliente buscar_cliente(String cedula_o_ruc) throws SQLException{
Cliente cliente = new Cliente();

Cliente_bd c_bd = new Cliente_bd();
cliente = c_bd.buscar(cedula_o_ruc);



return cliente ;
}

public static Cliente Modificar_cliente(Cliente c) throws SQLException{

Cliente_bd c_bd = new Cliente_bd();

c_bd.Modificar(c);






return c_bd.buscar( c.cedula_o_RUC);
}


public static ListaClientes Mostrar_clientes(ListaClientes c) throws SQLException{
Cliente_bd c_bd = new Cliente_bd();
c = c_bd.cargar();

return c ;
}


public static void borrar_cliete( String cedula_o_RUC) throws SQLException{

Cliente_bd c_bd = new Cliente_bd();

c_bd.borrar( cedula_o_RUC);



}





















    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula_o_RUC() {
        return cedula_o_RUC;
    }

    public void setCedula_o_RUC(String cedula_o_RUC) {
        this.cedula_o_RUC = cedula_o_RUC;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




   
    
   

   


}
