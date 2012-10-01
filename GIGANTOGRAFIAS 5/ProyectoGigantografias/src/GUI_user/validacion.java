/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_user;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author arturo
 */
public class validacion {
//String nombre = new String();
    public validacion(String cadena){

    }

    public static boolean validarNumero(String cadena){

          Pattern p = Pattern.compile("[^0-9]+");

          Matcher m = p.matcher(cadena);
          StringBuffer sb = new StringBuffer();
          boolean resultado = m.find();
          

         if(resultado){
           
            return false;
         }
         else
           return true;
         }

    public static boolean validarLetra(String cadena){
          Pattern p = Pattern.compile("[^A-Za-z]+");
          Matcher m = p.matcher(cadena);
          StringBuffer sb = new StringBuffer();

          boolean resultado = m.find();

         if(resultado){
            
            return false;
         }
         else
           return true;
         }

    public static boolean validarNumeros_y_Letras(String cadena){
          Pattern p = Pattern.compile("[^A-Za-z0-9]+");
          Matcher m = p.matcher(cadena);
          StringBuffer sb = new StringBuffer();

          boolean resultado = m.find();


         if(resultado){

            return false;
         }
         else
           return true;
         }

    public static boolean validarEmail(String cadena){
      //comprueba que no empieze por punto o @;
      Pattern p = Pattern.compile("^\\.|^\\@");
      Matcher m = p.matcher(cadena);


      if (m.find())
         return true;
          //System.err.println("Las direcciones email no empiezan por punto o @");

      // comprueba que no empieze por www.

      p = Pattern.compile("^www.");
      m = p.matcher(cadena);
      if (m.find())
          return true;

      // comprueba que contenga @
      p = Pattern.compile("[@]");
      m = p.matcher(cadena);
      if (!m.find())
          return true;

      	//System.out.println("La cadena no tiene arroba");

      // comprueba que no contenga caracteres prohibidos
      p = Pattern.compile("[^A-Za-z0-9.@_-~#]");
      m = p.matcher(cadena);
      //StringBuffer sb = new StringBuffer();
      boolean resultado = m.find();
      boolean caracteresIlegales = false;

      if(resultado) {
         caracteresIlegales = true;
        return true;
      }
      else
          return false;
    }


    public static boolean validarTextoVacio(String cadena){
        if(!cadena.equals("")){
            return true;
        }
        else
            return false;
    }
   
    public static boolean validarCosto(String cadena){
int i , numero_de_puntos = 0;
          for(i=0;i<cadena.length();i++){
                char c = cadena.charAt(i);
                if(validacion.validarLetra(cadena)){
               // return false
                }
                if(c=='.'){
                numero_de_puntos++ ;
                }


          }


         if( numero_de_puntos != 1 || numero_de_puntos != 0){

            return false;
         }
         else
           return true;
         }

    public static boolean validarLetra_y_espacio(String cadena){
          Pattern p = Pattern.compile("[^A-Za-z ]+");
          Matcher m = p.matcher(cadena);
          StringBuffer sb = new StringBuffer();

          boolean resultado = m.find();

         if(resultado){

            return false;
         }
         else
           return true;
         }

     public static boolean validarLetra_numeros_y_espacio(String cadena){
          Pattern p = Pattern.compile("[^A-Za-z0-9 ]+");
          Matcher m = p.matcher(cadena);
          StringBuffer sb = new StringBuffer();

          boolean resultado = m.find();
         if(resultado){

            return false;
         }
         else
           return true;
         }

}




