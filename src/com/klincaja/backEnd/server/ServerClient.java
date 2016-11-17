package com.klincaja.backEnd.server;

import com.klincaja.backEnd.classes.ClientServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Klincaja on 09/11/16.
 */
public class ServerClient extends ClientServer implements Runnable{
    public ServerClient(ObjectOutputStream oos, ObjectInputStream ois) {
        super(oos, ois);
    }

    @Override
    public void commandosListener(Object o) {

    }

    @Override
    public void sendMessage(Object o) {

    }

    @Override
    public void run() {

    }
}
