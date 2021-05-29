
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Frm_Insertar;
import vista.Frm_Menu;
import vista.Frm_Mostrar;

public class ControladorMenu implements ActionListener{
    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    Frm_Mostrar vMo = new Frm_Mostrar();
    
    public ControladorMenu(Frm_Menu vMe, Frm_Insertar VIn, Frm_Mostrar vMo){
        this.vMe = vMe;
        this.vIn = VIn;
        this.vMo = vMo;
        //Esto es solo una prueba!!!
        
        vMe.btnInsertar.addActionListener(this);
        vMe.btnMostrar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vMe.btnInsertar){
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        } 
        if(e.getSource()== vMe.btnMostrar){
            vMo.setVisible(true);
            vMo.setLocationRelativeTo(null);
        }
    }
    
}
