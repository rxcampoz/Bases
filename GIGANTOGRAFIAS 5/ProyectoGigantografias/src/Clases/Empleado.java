/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Empleado_bd;
import Listas.ListaEmpleados;
import java.sql.SQLException;

/**
 *
 * @author ricardo
 */
public class Empleado  {
    private String usuario;
    private String password;
     private String nombre;
      private String apellido;
       private String cedula;
        private String direccion;
         private String telefono;
          private String departamento;
           private String tipo;
    
public Empleado(){}
   
    public Empleado(String usuario, String password, String nombre, String apellido, String cedula, String direccion, String telefono, String departamento, String tipo){
        this.usuario=usuario;
        this.password = password;
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.direccion=direccion;
        this.telefono=telefono;
        this.departamento = departamento ;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




public static boolean Ingreso_sistema(String usuario,String password) throws SQLException{
    Empleado_bd  s = new Empleado_bd();
   if(s.es_empleado(usuario, password)){

   return true ;
   }

    return false ;
 
}

public static Empleado buscar_empleado(String usuario) throws SQLException{
Empleado empleado = new Empleado();

Empleado_bd e_bd = new Empleado_bd();
empleado = e_bd.buscar(usuario);



return empleado ;
}

public static void Ingresar_empleado(Empleado e) throws SQLException{


    Empleado_bd  e_db = new Empleado_bd();

    e_db.insertar(e);

}

public static Empleado Modificar_empleado(Empleado e) throws SQLException{

Empleado_bd e_bd = new Empleado_bd();

e_bd.Modificar(e);



return e_bd.buscar( e.usuario);
}


public static ListaEmpleados Mostrar_empleados(ListaEmpleados e) throws SQLException{
Empleado_bd e_bd = new Empleado_bd();
e = e_bd.cargar();

return e ;
}


public static void borrar_empleado( String cedula) throws SQLException{

Empleado_bd e_bd = new Empleado_bd();

e_bd.borrar( cedula);



}




















    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
    
    


}
