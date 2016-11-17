package com.klincaja.backEnd.client;


import com.klincaja.backEnd.classes.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Klincaja on 09/11/16.
 */
public class Cliente extends Client implements Runnable{


    public Cliente(int port) {
        super(port);
        initComponents();
    }

    @Override
    public void sendMessage(Object o) {
        try {
            getObjectOutputStream().writeObject(o);
            getObjectOutputStream().reset();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void commandosListener(Object o) {
        Message msg = (Message)o;
        switch(msg.getIdMessage()){
            case 1:
                System.out.println("RecibiendoDatos");
                break;
        }
    }

    @Override
    public void run() {
        try {
            setServerAddr(InetAddress.getByName(IPSERVER));
            setSocket(new Socket(getServerAddr(), 4040));

            setObjectOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
            setObjectInputStream(new ObjectInputStream(getSocket().getInputStream()));

            sendMessage(new Message((short) 0));

            setConnected(true);

            while(isConnected()){
                commandosListener(getObjectInputStream().readObject());
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error LobbyClient:"+e.getMessage());
        } finally {
            closeClient();
            //RECONECTANDO
        }
    }

    private void initComponents() {
        setThread(new Thread(this));
        getThread().start();
    }
}
