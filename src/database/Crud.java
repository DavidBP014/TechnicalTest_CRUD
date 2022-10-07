package database;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// Autor @DavidBP014
public class Crud {
    
    public Crud(){
    
    }
    
    String cadenaConexion = "jdbc:sqlserver://;database=videotienda;integratedSecurity=true";
    
    public boolean create(String query){
        boolean result = false;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query);
            
            result = true;
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error:"+ex);
        }
        return result;
    }

    public ArrayList<String> read(String query){    
        ArrayList<String> result = null;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
        
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            
            while(rs.next()){
                result = new ArrayList<String>();
                for (int i = 1; i <=numberOfColumns;i++) {
                    result.add(rs.getString(i));
                }
            }

            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error: "+ex);
        }
        return result;
    }
    
    public boolean update(String query){
        boolean result=false;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query);
            
            result = true;
            
            stmt.close();
            con.close();
        }catch (SQLException ex) {
            System.out.println("ha ocudrrido un error: "+ex);
        }
        return result;   
    }
    
    public boolean delete(String query){
        boolean ok = false;
        try {
            Connection con = DriverManager.getConnection(cadenaConexion);
            Statement stmt = con.createStatement();
    
            stmt.executeUpdate(query);
            ok = true;
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error: "+ex);
        }
        return ok;
   }
}
