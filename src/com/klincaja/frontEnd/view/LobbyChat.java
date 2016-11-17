package com.klincaja.frontEnd.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Klincaja on 16/11/16.
 */
public class LobbyChat extends JFrame {


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

    }
}
