/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_user;



import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
/**
 * Nombre de la clase : Imagen
 * Descripcion : contiene la interfas para ponerle una imagen de fondo a la ventana
 * Extiende de : JDesktopPane
 * @author Robinson
 *
 */

	public class Imagen extends JDesktopPane {
		private ImageIcon background;

		public Imagen(String ruta){
			background = new ImageIcon( ruta );
		}

		public void paintComponent( Graphics g ){
			super.paintComponent( g );
			background.paintIcon( this, g, 0, 0 );
		}

		public Dimension getPreferredSize(){
			return new Dimension( background.getIconWidth(),background.getIconHeight() );
		}
	}
