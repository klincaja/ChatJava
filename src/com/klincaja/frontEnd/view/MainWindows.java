package com.klincaja.frontEnd.view;

import com.klincaja.frontEnd.viewAlert.CampoVacioException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Klincaja on 10/11/16.
 */
public class MainWindows extends JFrame implements ActionListener{

    private JButton btnIniciar,btnSalir;
    private JLabel lbTitulo;
    private JTextField txtUsuario;
    private JPanel panel;
    public MainWindows(){
        super("Chat Java ");
        initComponents();
    }

    private void initComponents() {
        // Configuramos nuestro JFRAME
        this.setSize(300,400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
        //------------------------------------------

        //Componentes
        this.panel = new JPanel(new GridLayout(4,1,0,5));
        this.panel.setBorder(new EmptyBorder(100,50,100,50));
        this.btnIniciar = new JButton("Iniciar");
        this.btnSalir = new JButton("Salir");
        this.txtUsuario = new JTextField(20);
        this.lbTitulo = new JLabel("INGRESE SU USUARIO");
        this.lbTitulo.setBorder(new EmptyBorder(0,30,0,0));
        this.btnSalir.addActionListener(this);
        this.btnIniciar.addActionListener(this);
        this.txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(txtUsuario.getText().length()>20){
                    e.consume();
                }
            }
        });

        //Agregamos a nuestro ContentPane
        panel.add(lbTitulo);
        panel.add(txtUsuario);
        panel.add(btnIniciar);
        panel.add(btnSalir);
        add(panel,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIniciar){
            if(txtUsuario.getText().length()==0){
                //throw new CampoVacioException();
            }
        }
        if(e.getSource() == btnSalir){
            dispose();
        }
    }
}
