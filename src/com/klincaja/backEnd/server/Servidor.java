package com.klincaja.backEnd.server;

import com.klincaja.backEnd.classes.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Klincaja on 09/11/16.
 */
public class Servidor extends Server implements Runnable{

    public Servidor(int port) {
        super(port);
    }

    @Override
    public void sendAll() {
    }

    @Override
    public void startServer() {
        setThreadServer(new Thread(this));
        getThreadServer().start();
    }

    @Override
    public void run() {
        try{
            while(isConnectedServer()){
                setSocket(this.getServerSocket().accept());
                setObjectOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
                setObjectInputStream(new ObjectInputStream(getSocket().getInputStream()));
                getClients().add(new ServerClient(getObjectOutputStream(),getObjectInputStream()));
            }
        }catch(Exception ex){
            System.out.println("Ocurrio un problema al intentar recibir un nuevo cliente [Class LobbyServer] Linea 37\n"+ex.getMessage());
        }finally{
            setPackageDataError(getPackageDataError()+1);
        }
    }

}
