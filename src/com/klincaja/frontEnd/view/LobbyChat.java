package com.klincaja.frontEnd.view;

import com.klincaja.backEnd.classes.Canal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Klincaja on 16/11/16.
 */
public class LobbyChat extends JFrame {

    private JList<Canal> canalJList;
    private JPanel panelCanales;
    private JPanel panelCentral;

    public LobbyChat (){
        super("Lobby Chat");
        initComponents();
    }

    private void initComponents() {

        //Configuramos nuestro JFrame
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        //--------------------------

        //PanelCanal
        panelCanales = new JPanel(new GridLayout(3,1,5,5));
        canalJList = new JList<Canal>();




    }
}
