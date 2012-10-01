/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import BD.Material_bd;
import Listas.ListaMateriales;
import java.sql.SQLException;

/**
 *
 * @author ricardo
 */
public class Material {
    private String idMaterial;
    private String nombreM;
    private float costo;
    private String descripcionM;
    private String cantidad;
    private String tipo;


    public Material(){}

    public Material(String idMaterial,String descripcionM,String nombreM, float costo,String cantidad,String tipo){
        this.idMaterial=idMaterial;
        this.nombreM=nombreM;
        this.descripcionM=descripcionM;
        this.costo=costo;
        this.cantidad=cantidad;
        this.tipo=tipo;
       
    }

   public static void Ingresar_material(Material m) throws SQLException{

    Material_bd  m_db = new Material_bd();

    m_db.insertar(m);


}

   public static Material buscar_material(String id_material) throws SQLException{
Material material = new Material();

Material_bd m_bd = new Material_bd();
material = m_bd.buscar(id_material);

return material;
}




 public static Material Modificar_material(Material m) throws SQLException{

Material_bd m_bd = new Material_bd();

m_bd.Modificar(m);

return m_bd.buscar( m.idMaterial);
}

 public static ListaMateriales Mostrar_materiales(ListaMateriales m) throws SQLException{
Material_bd m_bd = new Material_bd();
m = m_bd.cargar();

return m ;
}

 public static void borrar_material(String id_material) throws SQLException{

Material_bd m_bd = new Material_bd();

m_bd.borrar(id_material);



}

    public String getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcionM() {
        return descripcionM;
    }

   
    public String getNombreM() {
        return nombreM;
    }

    
    public void setDescripcionM(String descripcionM) {
        this.descripcionM = descripcionM;
    }

  
    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    
    public float getCosto() {
        return costo;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  



}
