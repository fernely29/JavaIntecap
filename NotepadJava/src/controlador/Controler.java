/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloLogico;
import vista.FrmVentana;

/**
 *
 * @author FERNE
 */
public class Controler implements ActionListener {

    FrmVentana vista = new FrmVentana();
    ModeloLogico modelo = new ModeloLogico();

    public Controler(FrmVentana vista, ModeloLogico modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.jMenuItem1.addActionListener(this);
        this.vista.jMenuItem2.addActionListener(this);
        this.vista.jMenuItem3.addActionListener(this);
        this.vista.jMenuItem4.addActionListener(this);
        this.vista.jMenuItem5.addActionListener(this);
    }

    private void open() {
        modelo.setSeleccion(vista.jFileChooser1.showOpenDialog(vista.jMenu1));
        if (modelo.getSeleccion() == 0) {
            try {
                BufferedReader reader = null;
                File archivo = vista.jFileChooser1.getSelectedFile();
                reader = new BufferedReader(new FileReader(archivo));
                modelo.setLinea(reader.readLine());
                while (modelo.getLinea() != null) {
                    vista.jTextArea.append(modelo.getLinea());
                    vista.jTextArea.append(System.getProperty("line.separator"));
                    modelo.setLinea(reader.readLine());
                }
                reader.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModeloLogico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ModeloLogico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void save() {
        modelo.setSeleccion(vista.jFileChooser1.showSaveDialog(vista.jTextArea));
        if (modelo.getSeleccion() == 0) {
            try {
                PrintWriter escribir = null;
                File archivo = vista.jFileChooser1.getSelectedFile();
                escribir = new PrintWriter(archivo);
                escribir.print(vista.jTextArea.getText());
                escribir.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mayusculas() {
        vista.jTextArea.setText(vista.jTextArea.getText().toUpperCase());
    }

    private void minuscula() {
        vista.jTextArea.setText(vista.jTextArea.getText().toLowerCase());
    }

    private void negrita() {
        Font font = new Font("Arial", Font.BOLD, 12);
        vista.jTextArea.setFont(font);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jMenuItem1) {
            this.open();
        }
        if (e.getSource() == vista.jMenuItem2) {
            this.save();
        }
        if(e.getSource() == vista.jMenuItem3){
            this.mayusculas();
        }
        if(e.getSource()== vista.jMenuItem4){
            this.minuscula();
        }
        if(e.getSource() == vista.jMenuItem5){
            this.negrita();
        }
    }
}
