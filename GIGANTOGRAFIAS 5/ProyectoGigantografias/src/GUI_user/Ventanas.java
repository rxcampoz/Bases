/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI_user;

import BD.Conexion;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Sesion;
import GUI.vAdministrador;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 *
 * @author Robinson
 */
public class Ventanas extends JFrame  {
        JFrame ventana ;
        JButton cerrar , ingresar , Boton1 , Boton2 , Boton3 , Boton4 ;
        JLabel Label1 , Label2 , Label3 , Label4 , Label5 , Label6 , Label7 ;
        JTextField Text1, Text2, Text3, Text4, Text5;
        JPasswordField Password;
        JPanel Panel1,Panel2,Panel3;
        JComboBox jComboBox1,jComboBox2 ;
        JTextArea TextArea1;
        public Ventanas(){}

        public void ventana_Inicio(){
            Imagen fondo = new Imagen("Photoshop_tools.jpg");
            ventana = new JFrame("Ingreso al sistema");
            Label1 = new JLabel("SISTEMA PARA NEGOCIOS Y GIGANTOGRAFIA");
              Label2 = new JLabel("SGV");
             
             Label3= new JLabel("USER");
             Label4 = new JLabel("PASSWORD");
             cerrar = new JButton("Cerrar");
             ingresar = new JButton("Ingresar");
             Text1 = new JTextField(15);
             Password = new JPasswordField(20);


               cerrar.setFont(new Font("Forte", Font.ITALIC, 25));
                cerrar.setBounds(600,450,100,40);
                cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ventana.dispose();}});
               ingresar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(!(validacionVentanas.esta_vacio(Text1.getText()))&&!(validacionVentanas.esta_vacio(Password.getText()))){
                    try {
                        if (Empleado.Ingreso_sistema(Text1.getText(), Password.getText())) {
                            
                            Main.Inicio.ventana.dispose();
                             Sesion sesion_abierta = new Sesion(Empleado.buscar_empleado(Text1.getText()));
System.out.println(Empleado.buscar_empleado(Text1.getText()).getTipo());
                             if(Empleado.buscar_empleado(Text1.getText()).getTipo().equals("EMPLEADO") ){

                                 Main.Modo_Usuario.ventana.setVisible(true);
                             }else{

                             vAdministrador V_A = new vAdministrador();
                             V_A.setVisible(true);

                             }

                           
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o Clave incorrecta");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                       if(validacionVentanas.esta_vacio(Text1.getText())){
                       JOptionPane.showMessageDialog(null,"Ingrese un usuario");
                       }

                        if(validacionVentanas.esta_vacio(Password.getText())){
                       JOptionPane.showMessageDialog(null,"Ingrese un Password");
                       }

                }
                }

               });
               ingresar.setFont(new Font("Forte", Font.ITALIC, 17));
                ingresar.setBounds(450,450,100,40);
                Label1.setBounds(50,10,600,50);//para el ancho y largo
                Label1.setFont(new Font("Ravie", Font.ITALIC, 16));
		Label1.setForeground(Color.ORANGE);
                Label2.setBounds(300,50,600,50);//para el ancho y largo
                Label2.setFont(new Font("Ravie", Font.ITALIC, 30));
		Label2.setForeground(Color.ORANGE);
                Label3.setBounds(10,400,600,50);//para el ancho y largo
                Label3.setFont(new Font("Ravie", Font.ITALIC, 20));
		Label3.setForeground(Color.ORANGE);
                Label4.setBounds(10,450,600,50);//para el ancho y largo
                Label4.setFont(new Font("Ravie", Font.ITALIC, 20));
		Label4.setForeground(Color.ORANGE);
                Text1.setBounds(190,408,160,25);
                 Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarLetras(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarLetras(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarLetras(Text1);}
                 });

               Password.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarContraseña(Password);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarContraseña(Password);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarContraseña(Password);}
                 });

                Password.setBounds(190,458,160,25);
                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(cerrar);
                fondo.add(ingresar);
                fondo.add(Text1);
                fondo.add(Password);
                ventana.setSize(768, 576);
             
             ventana.setLocationRelativeTo(null);
             Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);
             
             
 }
        public void ventana_Sistema_modo_usuario(){
            Imagen fondo = new Imagen("iniciose.jpg");
            ventana = new JFrame("Sistema Modo Usuario");
                    Boton1 = new JButton("Pedidos");
                    Boton2 = new JButton("Clientes");
                    Boton3 = new JButton("Materiales");
                    Boton1.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {

                     // Main.Pedidos.ventana.setVisible(true);

                            VPedidos P = new VPedidos();
                              P.setVisible(true);

                             

                         }});
                         Boton2.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                        VCliente vc = new VCliente();
                        vc.setVisible(true);

                         }});
                         Boton3.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                       VMaterial M = new VMaterial();
                       M.setVisible(true);
                         }});
                    cerrar = new JButton("Cerrar");
                    Label1 = new JLabel("Sistema Para Negocio de Gigantografia");
                    Label2 = new JLabel("y Vallas Publicitarias");
                    Panel1 = new JPanel();
                    Panel2 = new JPanel();
                    Panel1.setLayout(new GridLayout(2, 1, 5, 5));
                    Panel2.setLayout(new GridLayout(3, 1, 5, 5));

        Label1.setFont(new Font("CASTELLAR", Font.ROMAN_BASELINE, 16));
        Label2.setFont(new Font("CASTELLAR", Font.ROMAN_BASELINE, 16));
        Label1.setForeground(Color.getHSBColor(12, 60, 50));
        Label2.setForeground(Color.getHSBColor(12, 60, 50));
        Boton1.setFont(new Font("Ravie", Font.ITALIC, 20));
        Boton2.setFont(new Font("Ravie", Font.ITALIC, 20));
        Boton3.setFont(new Font("Ravie", Font.ITALIC, 15));
        cerrar.setFont(new Font("Ravie", Font.ITALIC,14));

     cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ventana.dispose();}});
               
                    Label1.setBounds(20,20,450,25);
                  Label2.setBounds(150,50,260,25);
                  Boton1.setBounds(160,150,160,40);
                  Boton2.setBounds(160,210,160,40);
                  Boton3.setBounds(160,270,160,40);
                  cerrar.setBounds(200,400,100,50);

                    fondo.add(Label1);
                    fondo.add(Label2);
                     fondo.add(Boton1);
                     fondo.add(Boton2);
                     fondo.add(Boton3);
                     fondo.add(cerrar);
              ventana.setSize(485, 574);
             ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             ventana.setLocationRelativeTo(null);
               Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);
        }

      /*  public void ventana_Pedidos(){
                 Imagen fondo = new Imagen("11514686_1.jpg");
                ventana = new JFrame("Pedidos");
                    Boton1 = new JButton("Ingresar Pedido");
                    Boton2 = new JButton("Buscar Pedido");
                    Boton3 = new JButton("Cancelar Pedido");

                    Boton1.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      VPedido vp = new VPedido();
                      vp.setVisible(true);
                         }});
                         Boton2.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      Main.buscar_Pedido.ventana.setVisible(true);
                         }});
                         Boton3.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      Main.cancelar_Pedido.ventana.setVisible(true);
                         }});
                    Boton1.setBounds(80,80,150,40);
                     Boton2.setBounds(80,160,150,40);
                     Boton3.setBounds(80,220,150,40);
                    fondo.add(Boton1);
                    fondo.add(Boton2);
                    fondo.add(Boton3);
                    ventana.setSize(300,400);
                    ventana.setLocationRelativeTo(null);
               Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);

        }*/
        
        public void Ventana_Buscar_Pedido(){
            Imagen fondo = new Imagen("11514686_1.jpg");
                ventana = new JFrame("Buscar Pedidos");
                Boton1 = new JButton("Modificar");
                Boton2 = new JButton("Aceptar");
                Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Tipo :");
                Label3 = new JLabel("Costo :");
                Label4 = new JLabel("Mes de ingreso :");
                Label5 = new JLabel("Codigo :");
                Label1.setForeground(Color.black);
Label1.setForeground(Color.white);
Label2.setForeground(Color.white);
Label3.setForeground(Color.white);
Label4.setForeground(Color.white);
Label5.setForeground(Color.white);
                jComboBox1 = new JComboBox();
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre" }));
Boton1.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      Main.modificar_Pedido.ventana.setVisible(true);
                         }});
                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();
                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
                 });



                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Numeros(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Numeros(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Numeros(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(50,130,100,20);
                 Text3.setEditable(false);
                 jComboBox1.setBounds(10,170,100,30);
                 Text5.setBounds(10,220,350,30);

                 Boton1.setBounds(40,300,100,30);
                 Boton2.setBounds(230,300,100,30);

                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(jComboBox1);
                fondo.add(Text5);
                fondo.add(Boton1);
                fondo.add(Boton2);
                ventana.setSize(400,400);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);


        }

        public void ventana_Modificar_Pedidos(){
         Imagen fondo = new Imagen("11514686_1.jpg");
                ventana = new JFrame("Modificar Pedido");
                Boton1 = new JButton("Modificar");

                Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Tipo :");
                Label3 = new JLabel("Costo :");
                Label4 = new JLabel("Descripcion :");
                Label5 = new JLabel("Estado :");
                Label1.setForeground(Color.black);
Label1.setForeground(Color.white);
Label2.setForeground(Color.white);
Label3.setForeground(Color.white);
Label4.setForeground(Color.white);
Label5.setForeground(Color.white);

                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();
                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
                 });
                 Text4.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
                 });
                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(50,130,100,20);
                 Text4.setBounds(10,170,350,30);
                 Text5.setBounds(10,220,350,30);

                 Boton1.setBounds(130,300,100,30);


                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(Text4);
                fondo.add(Text5);
                fondo.add(Boton1);

                ventana.setSize(400,400);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);
        }

        public void ventana_Suspender_pedido(){
         Imagen fondo = new Imagen("11514686_1.jpg");
                ventana = new JFrame("Cancelar Pedido");
                Boton1 = new JButton("Suspender Pedido");

                Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Tipo :");
                Label3 = new JLabel("Costo :");
                Label4 = new JLabel("Descripcion :");
                Label5 = new JLabel("Estado :");
Label1.setForeground(Color.white);
Label2.setForeground(Color.white);
Label3.setForeground(Color.white);
Label4.setForeground(Color.white);
Label5.setForeground(Color.white);
                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();

                Text1.setEnabled(false);
                Text2.setEnabled(false);
                Text3.setEnabled(false);
                Text4.setEnabled(false);
                Text5.setEnabled(false);

                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
                 });
                 Text4.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
                 });
                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(50,130,100,20);
                 Text4.setBounds(10,170,350,30);
                 Text5.setBounds(10,220,350,30);

                 Boton1.setBounds(100,300,200,30);


                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(Text4);
                fondo.add(Text5);
                fondo.add(Boton1);

                ventana.setSize(400,400);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);

        }

        public void ventana_Cliente(){
                Imagen fondo = new Imagen("xxxla-isla-de-las-ballenas-voladoras-monticulo-ondas.jpg");
                ventana = new JFrame("Cliente");
                    Boton1 = new JButton("Ingresar Cliente");
                    Boton2 = new JButton("Buscar Cliente");
                    Boton3 = new JButton("Borrar Cliente");
                    Boton1.setBounds(80,80,150,40);
                     Boton2.setBounds(80,160,150,40);
                     Boton3.setBounds(80,220,150,40);

                     Boton1.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      VIngresar_Cliente ingresar_cliente = new VIngresar_Cliente();
                      ingresar_cliente.setVisible(true);
                         }});
                         Boton2.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                             
                              


                             //  aqui ///////////////////////////////////////////////////////////////////////////////////////////////
                         }});
                         Boton3.addActionListener(new ActionListener() {
                         public void actionPerformed(ActionEvent e) {
                      Main.Borrar_cliente.ventana.setVisible(true);
                         }});
                    fondo.add(Boton1);
                    fondo.add(Boton2);
                    fondo.add(Boton3);
                    ventana.setSize(300,400);
                    ventana.setLocationRelativeTo(null);
               Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);



        }
        

        public void ventana_modificar_Cliente(){

                 Imagen fondo = new Imagen("xxxla-isla-de-las-ballenas-voladoras-monticulo-ondas.jpg");
                ventana = new JFrame("Modificar Datos del Cliente");
                 Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Apellido :");
                Label3 = new JLabel("Cedula :");
                Label4 = new JLabel("Domicilio :");
                Label5 = new JLabel("Telefono :");
Label1.setForeground(Color.CYAN);
Label2.setForeground(Color.CYAN);
Label3.setForeground(Color.CYAN);
Label4.setForeground(Color.CYAN);
Label5.setForeground(Color.CYAN);
                Boton1 = new JButton("Modificar");

                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();
                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
           Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
                 });
                 Text4.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
                 });
                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(52,130,150,20);
                 Text4.setBounds(10,170,350,30);
                 Text5.setBounds(52,220,150,20);

                 Boton1.setBounds(290,220,90,40);

                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(Text4);
                fondo.add(Text5);
                fondo.add(Boton1);

                

                ventana.setSize(400,300);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);



        }

       

         public void ventana_Borrar_Cliente(){

                Imagen fondo = new Imagen("xxxla-isla-de-las-ballenas-voladoras-monticulo-ondas.jpg");
                ventana = new JFrame("Borrar Cliente");
                 Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Apellido :");
                Label3 = new JLabel("Cedula :");
                Label4 = new JLabel("Domicilio :");
                Label5 = new JLabel("Telefono :");
Label1.setForeground(Color.CYAN);
Label2.setForeground(Color.CYAN);
Label3.setForeground(Color.CYAN);
Label4.setForeground(Color.CYAN);
Label5.setForeground(Color.CYAN);
                Boton1 = new JButton("Borrar");

                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();
                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text3);}
                 });
                 Text4.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
                 });
                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarNumeros(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(52,130,150,20);
                 Text4.setBounds(10,170,350,30);
                 Text5.setBounds(52,220,150,20);

                 Boton1.setBounds(290,220,90,40);

                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(Text4);
                fondo.add(Text5);
                fondo.add(Boton1);



                ventana.setSize(400,300);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);

         }

         public void ventana_Ingresar_material(){
            Imagen fondo = new Imagen("thumb_photoshop.gif");
                ventana = new JFrame("Ingresar Material");
                Label1 = new JLabel("Nombre :");
                Label2 = new JLabel("Tipo :");
                Label3 = new JLabel("Costo :");
                Label4 = new JLabel("Descripcion :");
                Label5 = new JLabel("Estado :");
Label1.setForeground(Color.black);
Label2.setForeground(Color.black);
Label3.setForeground(Color.black);
Label4.setForeground(Color.black);
Label5.setForeground(Color.black);

                Boton1 = new JButton("Ingresar");
                Text1 = new JTextField();
                Text2 = new JTextField();
                Text3 = new JTextField();
                Text4 = new JTextField();
                Text5 = new JTextField();
                 Label1.setBounds(5,0,150,60);
                 Label2.setBounds(5,50,150,60);
                 Label3.setBounds(5,100,150,60);
                 Label4.setBounds(5,130,150,60);
                 Label5.setBounds(5,180,150,60);
            Text1.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_y_Espacios(Text1);}
                 });
                 Text2.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text2);}
                 });
                 Text3.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarCosto(Text3);}
                 });
                 Text4.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyTyped(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
            public void keyReleased(KeyEvent e) {validacionVentanas.validarLetras_Numeros_y_Espacios(Text4);}
                 });
                 Text5.addKeyListener(new KeyListener(){
             public void keyPressed(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyTyped(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
            public void keyReleased(KeyEvent e) {validacionVentanas.accionValidarLetras(Text5);}
                 });
                 Text1.setBounds(10,40,350,30);
                 Text2.setBounds(10,90,350,30);
                 Text3.setBounds(50,130,100,20);

                 Text4.setBounds(10,170,350,30);
                 Text5.setBounds(10,220,350,30);

                  Boton1.setBounds(150,260,90,40);

                fondo.add(Label1);
                fondo.add(Label2);
                fondo.add(Label3);
                fondo.add(Label4);
                fondo.add(Label5);
                fondo.add(Text1);
                fondo.add(Text2);
                fondo.add(Text3);
                fondo.add(Text4);
                fondo.add(Text5);
                fondo.add(Boton1);







               ventana.setSize(400,350);
               ventana.setLocationRelativeTo(null);
            Container contenedor = ventana.getContentPane();
             contenedor.add(fondo);
        }

      


   
    
}
