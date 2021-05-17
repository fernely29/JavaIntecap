/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepadjava;

import controlador.Controler;
import modelo.ModeloLogico;
import vista.FrmVentana;

/**
 *
 * @author FERNE
 */
public class NotepadJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FrmVentana ventana = new FrmVentana();
        ModeloLogico model = new ModeloLogico();
        Controler controlador = new Controler(ventana, model);
        ventana.setVisible(true);
    }
    
}
