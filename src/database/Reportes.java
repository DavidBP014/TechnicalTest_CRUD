package database;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
// Autor @DavidBP014
public class Reportes {

    public Reportes() {
    }

    String cadenaConexion = "jdbc:sqlserver://;database=videotienda;integratedSecurity=true";

    public ResultSet listar(String query) {
        ResultSet rsLista = null;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rsLista = rs;

        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsLista;
    }

    public ResultSet ventasXVendedor(String codigoEmpleado) {
        ResultSet rsVentasXvendedor = null;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("Select * from venta where cod_emp = '" + codigoEmpleado + "';");

            rsVentasXvendedor = rs;
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsVentasXvendedor;
    }
    
     public ResultSet DatosVendedores(String codigoArticulo) {
        ResultSet rsVentasXvendedor = null;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from empleado where codigo in (select DISTINCT cod_emp from venta where cod_art = '" + codigoArticulo + "')");
            rsVentasXvendedor = rs;
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsVentasXvendedor;
    }

    public ResultSet buscar(String query) {
        ResultSet filtraID = null;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            filtraID = rs;
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filtraID;

    }

}
