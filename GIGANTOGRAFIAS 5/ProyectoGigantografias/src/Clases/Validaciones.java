/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.awt.event.*;

/**
 *
 * @author cltsmalc
 */
public class Validaciones {

    public  Validaciones(){/*Por defecto*/ }

    /******Descripcion:Metodo que retorna
            0 si cadena esta vacia.
            1 cadena no esta vacia y es correcta.
            -1 si cadena no esta vacia y es incorrecta.********/
    public int validarCadena(String cadena){
        int cont=0;
        cadena=cadena.toUpperCase();
        if(cadena.isEmpty())return 0;
        else{
            for(int i=0;i<cadena.length();i++){
                if(cadena.charAt(i)>= 'A'&& cadena.charAt(i)<= 'Z' ||cadena.charAt(i)==' '||cadena.charAt(i)>='0'&& cadena.charAt(i)<='9')
                    cont++;
            }
        }
        if(cont==cadena.length())
            return 1;
        else return -1;
    }
    
    
    /******Descripcion:Metodo que retorna
            0 si el ruc esta vacio.
            1 si el ruc no esta vacio y es correcto.
            -1 si el ruc no esta vacio y es incorrecto.********/
    public int validarRuc(String ruc){
        int cont=0;
        if(ruc.isEmpty())return 0;
        else{
            if(ruc.length()==13){
                for(int i=0;i<ruc.length();i++){
                    if(ruc.charAt(i)>='0' && ruc.charAt(i)<='9')
                        cont++;
                }
            }
        }
        if(cont==ruc.length()) return 1;
        else return -1;
    }

    /******Descripcion:Metodo que retorna
            0 si la cedula esta vacio.
            1 si la cedula no esta vacio y es correcto.
            -1 si si la cedula no esta vacio y es incorrecto.********/
    public int validarCedula(String asociado){
        int cont=0;
        if(asociado.isEmpty())return 0;
        else{
            if(asociado.length()==10){
                for(int i=0;i<asociado.length();i++){
                    if(asociado.charAt(i)>='0' && asociado.charAt(i)<='9')
                        cont++;
                }
            }
        }
        if(cont==asociado.length()) return 1;
        else return -1;
    }

    /******Descripcion:Metodo que retorna
            0 si el telefono esta vacio.
            1 si el telefono no esta vacio y es correcto.
            -1 si el telefono no esta vacio y es incorrecto.********/
    public int validarTelefono(String telefono){
        int cont=0;
        if(telefono.isEmpty())return 0;
        else{
            telefono=telefono.toUpperCase();
            if(telefono.length()<=9){
                for(int i=0;i<telefono.length();i++){
                    if(i==0){
                        if(telefono.charAt(i)>='0')
                            cont++;
                    }
                    else if(i==1){
                        if(telefono.charAt(i)>='2'&& telefono.charAt(i)<='9')
                            cont++;
                    }
                    else {
                        if(telefono.charAt(i)>='0'&&telefono.charAt(i)<='9')
                            cont++;
                    }
                }
            }
        }
        if(telefono.length()==cont)return 1;
        else return -1;
    }

    /******Descripcion:Metodo que retorna
            0 si la direccion esta vacio.
            1 si la direccion no esta vacio y es correcto.
            -1 si lad direccion no esta vacio y es incorrecto.********/
    public int validarDireccion(String direccion){
        int cont=0;
        if(direccion.isEmpty())return 0;
        else{
            direccion = direccion.toUpperCase();
            for(int i=0;i<direccion.length();i++){
                if(direccion.charAt(i)>='A'&&direccion.charAt(i)<='Z'||direccion.charAt(i)==' '||direccion.charAt(i)=='-'||direccion.charAt(i)>='0'&&direccion.charAt(i)<='9'||direccion.charAt(i)=='.')
                    cont++;
            }
        }
        if(direccion.length()==cont)return 1;
        else return -1;
    }

    /*----------------------------------------------------------------------------------*
            Procedimientos de Validaciones de las las entradas de cajas de texto)
     -----------------------------------------------------------------------------------*/

    public static void SoloNumeros(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
        char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();

        if(!(caract >= '0' && caract <= '9')){
                    evt.consume(); // ignorar el evento de teclado
                }
                if (txt.getText().length()>=10){
                    evt.consume();
                }

        }

    public static void SoloLetras(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
      char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();

        if(!(caract >= 'A' && caract <= 'Z')&& (caract != ' ')){
                    evt.consume();}
        if(txt.getText().length()>20)
            evt.consume();
    }

    public static void SoloNumyLetras(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
    char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();

        if(!(caract >= 'A' && caract <= 'Z') && !(caract >= '0' && caract <= '9')&& (caract != ' ')){
                    evt.consume(); // ignorar el evento de teclado
                }
    }

    public static void validaRUC(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
        char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();

        if (!(caract >= '0' && caract <= '9')) { evt.consume();} // ignorar el evento de teclado
        if (txt.getText().length() >= 13) { evt.consume(); }
    }
    
    public static void validaTelefono(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
    char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();

        if(!(caract >= '0' && caract <= '9')){ evt.consume();} // ignorar el evento de teclado
        if (txt.getText().length()>=9){ evt.consume(); }
    }

    public static void validaDecimal(java.awt.event.KeyEvent evt,javax.swing.JTextField txt){
    char caract;
        // Convierte TODO ingreso a mayusculas
        String letra = (evt.getKeyChar() + "").toUpperCase();
        evt.setKeyChar(letra.charAt(0));
        caract = evt.getKeyChar();
        if(!(caract >= '0' && caract <= '9') && (caract != '.')){
                    evt.consume();}
    }

  
    /*BORRAR TABLA*/
    public static void LimpiarTabla(javax.swing.JTable tabla){
                for (int i=0 ;i<tabla.getRowCount();i++){
                    for (int j=0 ;j<tabla.getColumnCount();j++){
                        tabla.setValueAt(null, i, j);
                    }
                }
        }

}//fin de clase
