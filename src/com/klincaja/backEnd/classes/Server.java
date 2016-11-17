package com.klincaja.backEnd.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klincaja
 *
 */
public abstract class Server {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    
    private ServerSocket serverSocket;
    private Socket socket;
    
    private Thread threadServer;
    
    private int port;
    private int packageDataError = 0;

    
    private boolean connectedServer ;
    
    private String serverInfo;
    
    private ArrayList<ClientServer> clients;

    public abstract void sendAll();
    public abstract void startServer();


    public Server(int port){
        try {
            this.port = port;
            serverSocket = new ServerSocket(port);
            System.out.println("com.klincaja.backEnd.server.Servidor iniciado correctamente IP: "+ Inet4Address.getLocalHost().getHostAddress()+" Puerto: "+port);
            connectedServer = true;       

        } catch (IOException ex) {
            connectedServer = false;
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        clients = new ArrayList<ClientServer>();
        saveInfo();
    }
        
       
    private void saveInfo() {
    }

    public void closeServer(){
        try {
            this.getObjectInputStream().close();
            this.getObjectOutputStream().close();
            this.connectedServer = false;
            this.threadServer.join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isConnectedServer() {
        return connectedServer;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Thread getThreadServer() {
        return threadServer;
    }

    public void setThreadServer(Thread threadServer) {
        this.threadServer = threadServer;
    }

    public ArrayList<ClientServer> getClients() {
        return clients;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPackageDataError() {
        return packageDataError;
    }

    public void setPackageDataError(int packageDataError) {
        this.packageDataError = packageDataError;
    }


}
