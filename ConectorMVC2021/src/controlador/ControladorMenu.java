
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Frm_Insertar;
import vista.Frm_Menu;

public class ControladorMenu implements ActionListener{
    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    
    public ControladorMenu(Frm_Menu vMe, Frm_Insertar VIn){
        this.vMe = vMe;
        this.vIn = VIn;
        
        vMe.btnInsertar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vMe.btnInsertar){
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        }
    }
    
}
