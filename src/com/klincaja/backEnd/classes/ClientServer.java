package com.klincaja.backEnd.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klincaja
 */
public abstract class ClientServer {

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInpuStream;
    private boolean Connected = false;  
    private Thread thread;
    private int packageDataError = 0;
    
    
    public ClientServer(ObjectOutputStream oos, ObjectInputStream ois){
        this.objectOutputStream = oos;
        this.objectInpuStream = ois;
        this.Connected = true;
    }

    public void closeClient(){
        try {
            this.Connected = false;
            this.objectOutputStream.close();
            this.objectInpuStream.close();
            this.thread.join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            System.out.println("Se desconecto");
        }
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInpuStream;
    }

    public boolean isConnected() {
        return Connected;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
    
    public abstract void commandosListener(Object o);
    public abstract void sendMessage(Object o);

    public int getPackageDataError() {
        return packageDataError;
    }

    public void setPackageDataError(int packageDataError) {
        this.packageDataError = packageDataError;
    }

}
