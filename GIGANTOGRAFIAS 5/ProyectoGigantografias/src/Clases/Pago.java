/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author ricardo
 */
public class Pago {
    private String idPago;
    private String tipo;
   

    public Pago(String idPago,String tipo){
        this.idPago=idPago;
        this.tipo=tipo;
    }

    public String getIdPago() {
        return idPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}

