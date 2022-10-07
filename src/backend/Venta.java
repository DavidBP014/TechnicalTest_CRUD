package backend;
import database.Crud;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * // Autor @DavidBP014
 */
public class Venta 
{
    private String cod_cli;
    private String cod_emp;
    private String cod_art;

    public Venta(String cod_cli, String cod_emp, String cod_art) {
        this.cod_cli = cod_cli;
        this.cod_emp = cod_emp;
        this.cod_art = cod_art;
    }
    
    public ArrayList <String> buscar(Component parent)
    {
        ArrayList <String> info = new ArrayList();
        
        Cliente cliente = new Cliente();
        cliente.buscar(parent, this.cod_cli);
        info.add(cliente.getNombre());
        info.add(cliente.getApellido());
        
        Empleado empleado = new Empleado();
        empleado.buscar(parent, this.cod_emp);
        info.add(empleado.getNombre());
        info.add(empleado.getApellido());
        
        Articulo articulo = new Articulo();
        articulo.buscar(parent, this.cod_art);
        info.add(articulo.getTitulo());
        info.add(Float.toString(articulo.getPrecio()));
        info.add(Integer.toString(articulo.getCantidad()));
        
        return info;
    }
    
    public void insertar(int cantidad, Float valor)
    {
        Crud crud = new Crud();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = new Date();
        String []fecha = dateFormat.format(date).split(" ");
        crud.create("INSERT INTO venta VALUES('" + this.cod_emp + "','" + this.cod_cli + "','" + this.cod_art + "','" + fecha[0] + "','" +
                fecha[1] + "'," + cantidad + "," + valor + ")");
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getCod_art() {
        return cod_art;
    }

    public void setCod_art(String cod_art) {
        this.cod_art = cod_art;
    }
    
    
}
