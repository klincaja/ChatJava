package com.klincaja.backEnd.classes;

import java.io.Serializable;

/**
 * Created by Klincaja on 10/11/16.
 */
public class Message implements Serializable{
    public static final long serialVersionUID = 1L;

    private short idMessage;

    public Message(short idMessage){
        this.idMessage = idMessage;
    }

    public short getIdMessage() {
        return idMessage;
    }
}
