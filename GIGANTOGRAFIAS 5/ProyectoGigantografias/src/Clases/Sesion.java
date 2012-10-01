/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Diego
 */
public class Sesion {

    private static Empleado duenio_de_sesion = new Empleado();

    public Sesion(Empleado E){
        duenio_de_sesion = E ;
    }

    public static Empleado getDuenio_de_sesion() {
        return duenio_de_sesion;
    }


}
