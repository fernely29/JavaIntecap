package conectormvc2021;

import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import modelo.Conector;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.Frm_Insertar;
import vista.Frm_Menu;

public class ConectorMVC2021 {

    public static void main(String[] args) {
        // TODO code application logic here
//        Conector c = new Conector();
//        c.conectar();

//Vistas
        Frm_Menu m = new Frm_Menu();
        Frm_Insertar fi = new Frm_Insertar();
        
        //Accesos a los datos
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        
        //Controladores        
        ControladorMenu cm = new ControladorMenu(m, fi);
        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        
        
        m.setVisible(true);
        m.setLocationRelativeTo(null);

    }

}
