package com.klincaja.backEnd.client;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klincaja
 */
public abstract class Client extends Observable {
    public static final String IPSERVER  = "127.0.0.1";
    
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private int port;
    private InetAddress serverAddr = null;
    private Socket socket;
    private Thread thread;
    private boolean connected;
    
    public Client(int port){
        this.port = port;
    }
    
    public void closeClient(){
        try {
            thread.join();
            socket.close();
            objectOutputStream.close();
            objectInputStream.close();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract void sendMessage(Object o);
    public abstract void commandosListener(Object o);

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public int getPort() {
        return port;
    }

    public InetAddress getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(InetAddress serverAddr) {
        this.serverAddr = serverAddr;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    
}
