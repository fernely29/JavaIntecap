package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaisDAO implements ConsultasDAO{ 

    @Override
    public void insertar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta= "INSERT INTO tbl_pais(nombre_pais, capital_pais, poblacion_pais) VALUES ('"+p.getNombre_pais()+"','"+p.getCapital_pais()+"',"+p.getPoblacion_pais()+");";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.err.println("Mensaje Insertar "+e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void actualizar(PaisVO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(PaisVO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PaisVO> consultarTabla() {
        Conector c =  new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta= "SELECT *FROM tbl_pais;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                PaisVO pvo = new PaisVO();
                pvo.setId_pais(rs.getInt(1));
                pvo.setNombre_pais(rs.getString(2));
                pvo.setCapital_pais(rs.getString(3));
                pvo.setPoblacion_pais(rs.getLong(4));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Mensaje mostrar Datos: "+e.getMessage());
        }                       
        return info;
    }
    
}
