package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Insertar;

public class ControladorInsertar implements ActionListener{
    
    
    
    Frm_Insertar vista = new Frm_Insertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorInsertar(Frm_Insertar vista, PaisVO pvo, PaisDAO pdao){
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vista.btnInsertarDato.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
    }
    public void limpiar(){
        vista.txtPais.setText("");
        vista.txtCapital.setText("");
        vista.txtPoblacion.setText("");
    }
    private void insertarPais(){
        pvo.setNombre_pais(vista.txtPais.getText());
        pvo.setCapital_pais(vista.txtCapital.getText());
        pvo.setPoblacion_pais(Long.parseLong(vista.txtPoblacion.getText()));
        
        pdao.insertar(pvo);
        
        JOptionPane.showMessageDialog(null, "Datos Guardados exitosamente");
        limpiar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnInsertarDato){
            this.insertarPais();
        }if(e.getSource() == vista.btnCancelar){
            vista.dispose();
        }
    }
    
}
