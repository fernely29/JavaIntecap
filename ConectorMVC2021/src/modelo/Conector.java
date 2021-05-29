/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Telma Morales
 */
public class Conector {

    //Declaracion de variable que se utilizaran en lal conexion
    private String driver = "com.mysql.jdbc.Driver";
    private String servidor = "127.1.1.0";
    private String usuario = "root";
    private String password = "";
    private String bd = "bd_java_con1";
    private String cadena;

    //Declarar mi objeto que me permite realizar una conexion
    Connection con;

    //Declara el objeto que permite realizar consultas sql insert, update, delete
    Statement st;

    //metodos para la conexion 
    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.servidor + "/" + this.bd;
        try {
            Class.forName(this.driver).newInstance();
            this.con = DriverManager.getConnection(this.cadena, this.usuario, this.password);
        } catch (Exception e) {
            System.err.println("Mensaje 1: " + e.getMessage());
        }
    }

    //METODO PARA DESCONECTAR
    public void desconectar() {
        try {
            this.con.close();
        } catch (Exception e) {
            System.err.println("Mensaje 2: " + e.getMessage());
        }
    }
    //Metodo para realizar dirversar consultas como insert, update, delete

    public int consultas_multiples(String consulta) {
        int resultado;
        try {
            this.conectar();
            this.st = this.con.createStatement();
            resultado = this.st.executeUpdate(consulta);
            
        } catch (Exception e) {
            System.err.println("Mensaje 3: "+e.getMessage());
            return 0;
        }
        finally{
            this.desconectar();
        }
        return resultado;
    }
    //Metodo para obtener data de una tabla en base de datos, select
    public ResultSet consulta_datos(String consulta){
        try {
            this.conectar();
            ResultSet resultado = null;
            this.st = this.con.createStatement();
            resultado = st.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {
            System.err.println("Mensaje 4: "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
        return null;
    }
}
