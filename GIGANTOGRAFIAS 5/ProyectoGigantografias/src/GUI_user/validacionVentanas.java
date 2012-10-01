/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_user;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author arturo
 */
public class validacionVentanas {
    public validacionVentanas(){

     }

     public static void accionValidarLetras(final JTextField textoAnalizar){
           String texto = new String();
           do{
             texto = new String(textoAnalizar.getText());
            if(!(validacion.validarLetra(texto))){

             texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);
              
            }
         }while(!(validacion.validarLetra(texto)));

         
      }


     public static void accionValidarNumeros(final javax.swing.JTextField textoAnalizar){
          String  texto = new String();
          do{
            texto = new String(textoAnalizar.getText());
            if(!(validacion.validarNumero(texto))){
              texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);
               
            }
          }while(!(validacion.validarNumero(texto)));

        
     }


     public static void validarEmail(final javax.swing.JTextField textoAnalizar){
        String  texto = new String();
        texto = new String(textoAnalizar.getText());
        if(validacion.validarEmail(texto)){
          
          textoAnalizar.setText("");
          
        }

        

     }

     public static void validarContraseña(final javax.swing.JPasswordField textoAnalizar){
          String texto ;

     do{
     texto = new String(textoAnalizar.getText());
     if(!(validacion.validarNumeros_y_Letras(texto))){
            texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);
     }

     }while(!(validacion.validarNumeros_y_Letras(texto)));


     }

      public static void validarLetras_y_Numeros(final javax.swing.JTextField textoAnalizar){
          String texto ;

     do{
     texto = new String(textoAnalizar.getText());
     if(!(validacion.validarNumeros_y_Letras(texto))){
            texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);
     }

     }while(!(validacion.validarNumeros_y_Letras(texto)));


     }
       public static void accionValidarCosto(final javax.swing.JTextField textoAnalizar){
          String  texto = new String();
          do{
            texto = new String(textoAnalizar.getText());
            if(!(validacion.validarCosto(texto))){
              texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);

            }
          }while(!(validacion.validarCosto(texto)));


     }

        public static void validarLetras_y_Espacios(final javax.swing.JTextField textoAnalizar){


                String texto = new String();
           do{
             texto = new String(textoAnalizar.getText());
            if(!(validacion.validarLetra_y_espacio(texto))){

             texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);

            }
         }while(!(validacion.validarLetra_y_espacio(texto)));

     }

          
 public static void validarLetras_Numeros_y_Espacios(final javax.swing.JTextField textoAnalizar){


                String texto = new String();
           do{
             texto = new String(textoAnalizar.getText());
            if(!(validacion.validarLetra_numeros_y_espacio(texto))){

             texto = texto.substring(0,texto.length()-1);
               textoAnalizar.setText(texto);

            }
         }while(!(validacion.validarLetra_numeros_y_espacio(texto)));

     }

 

 /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  12 de enero del 2011*/

 public static boolean esta_vacio(String cadena){
 if(cadena.isEmpty()){
 return true ;

 }else{
 return false;
 }
 }

 public  String disminuirTamanio(String s, int tam){




     return "f";
 }
     




     }