package backend;
import database.Crud;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// Autor @DavidBP014 
public class Articulo {

    protected String codigo;
    protected String titulo;
    protected String genero;
    protected float precio;
    protected int cantidad;
    protected String tipo;
    
     public Articulo(){
         
         this.codigo = "";
         this.titulo = "";
         this.genero = "";
         this.precio = 0;
         this.cantidad = 0;
         this.tipo = "";
     }

    public Articulo(String codigo, String titulo, String genero, float precio, int cantidad, String tipo) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    //Metods to work of my CRUD
    public void registrar(Component parent) {
        Crud crudArticulo = new Crud();
        boolean done = crudArticulo.create("INSERT INTO articulo VALUES('" + this.codigo + "','"
                + this.titulo + "','" + this.genero + "','" + this.precio + "','" + this.cantidad + "','" + this.tipo + "')");
        if (done) {
            JOptionPane.showMessageDialog(parent, "Articulo registrado correctamente.");
        } else {
            JOptionPane.showMessageDialog(parent, "Ocurrio un error al registrar el articulo.");
        }
    }

    public void actualizar(Component parent, String codigo, String titulo, String genero, float precio, int cantidad, String tipo) {
        if (this.codigo.equals("")) {
            JOptionPane.showMessageDialog(parent, "Por favor busque un articulo  valido");
        } else {
            Crud articulo = new Crud();
            articulo.update("UPDATE articulo SET codigo='" + codigo + "',titulo='" + titulo + "',genero='" + genero
                    + "',precio=" + precio + ",cantidad=" + cantidad + ",tipo='" + tipo + "' WHERE codigo='" + this.codigo + "'");

            JOptionPane.showMessageDialog(parent, "Articulo actualizado correctamente");
        }
    }

    public void buscar(Component parent, String codigo) {
        Crud articulo = new Crud();
        ArrayList<String> data = articulo.read("SELECT * FROM articulo WHERE articulo.codigo = '" + codigo + "'");

        if (data != null) {
            this.codigo = data.get(0);
            this.titulo = data.get(1);
            this.genero = data.get(2);
            this.precio = Float.parseFloat(data.get(3));
            this.cantidad = Integer.parseInt(data.get(4));
            this.tipo = data.get(5);
        } else {
            JOptionPane.showMessageDialog(parent, "Articulo no encontrado");
        }
    }
    
    public void eliminar(Component parent) 
    {
        Crud articulo = new Crud();
        articulo.delete("DELETE FROM venta WHERE venta.cod_art = '" + this.codigo + "'");
        articulo.delete("DELETE FROM articulo WHERE articulo.codigo = '" + this.codigo + "'");
        
        
        if (this.codigo.equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Por favor busque un articulo válido.");
        }
        else
        {
            this.codigo = "";
            this.titulo = "";
            this.genero = "";
            this.precio = 0;
            this.cantidad = 0;
            this.tipo = "";            
            JOptionPane.showMessageDialog(parent, "Articulo elminado correctamente.");
        }
    }
}
