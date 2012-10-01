/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author ricardo
 */
public class Empresa {
    
    private String idEmpresa;
    private String nombreEmpresa;
    private String ubicacion;
    private String RUC;
    private String telefono;
    private String anio;
    private String mision;
    private String vision;
    private String tipo;

    public Empresa(String idEmpresa, String nombreEmpresa, String ubicacion, String RUC, String telefono, String anio, String mision, String vision, String tipo) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.ubicacion = ubicacion;
        this.RUC = RUC;
        this.telefono = telefono;
        this.anio = anio;
        this.mision = mision;
        this.vision = vision;
        this.tipo = tipo;
    }

    public String getRUC() {
        return RUC;
    }

    public String getAnio() {
        return anio;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getMision() {
        return mision;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getVision() {
        return vision;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }



}
