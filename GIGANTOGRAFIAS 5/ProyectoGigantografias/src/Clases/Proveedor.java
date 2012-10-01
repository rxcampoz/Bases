/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author ricardo
 */
public class Proveedor {
    private String idProveedor;
    private String nombre;
    private int calificacion;
    private String comentario;

    public Proveedor(String idProveedor, String nombre, int calificacion, String comentario){
        this.idProveedor=idProveedor;
        this.nombre=nombre;
        this.calificacion=calificacion;
        this.comentario=comentario;

    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
