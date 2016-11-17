package com.klincaja.frontEnd.viewAlert;

import javax.swing.*;

/**
 * Created by Klincaja on 10/11/16.
 */
public class CampoVacioException extends Exception {
    public CampoVacioException(){
        super("Campo vacio");
        JOptionPane.showMessageDialog(null,"Ingrese un usuario el campo esta incompleto","Error campo vacio",JOptionPane.ERROR_MESSAGE);
    }
}
