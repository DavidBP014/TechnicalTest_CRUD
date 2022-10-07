package backend;
import database.*;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * // Autor @DavidBP014
 */
public class Cliente extends Persona
{
    private String direccion;

    public Cliente(String codigo,String nombre, String apellido, int edad,String direccion, String telefono) 
    {
        super(codigo, nombre, apellido, edad, telefono);
        this.direccion = direccion;
    }

    public Cliente() 
    {
        super("", "", "", 0, "");
        this.direccion = "";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void registrar(Component parent) 
    {
        Crud crudCliente = new Crud();
        boolean done = crudCliente.create("INSERT INTO cliente VALUES('" + this.codigo + "','"+
                  this.nombre + "','" + this.apellido + "'," + this.edad +
                    ",'" + this.direccion + "','" + this.telefono + "')");
        if (done)
            JOptionPane.showMessageDialog(parent, "Cliente registrado correctamente");
        else
            JOptionPane.showMessageDialog(parent, "Ocurrio un error al registrar el cliente");
    }

    @Override
    public void buscar(Component parent,String codigo) 
    {
        Crud crudCliente = new Crud();
        ArrayList <String> data = crudCliente.read("SELECT * FROM cliente WHERE cliente.codigo = '" + codigo + "'");
        
        if (data != null)
        {
            this.codigo = data.get(0);
            this.nombre = data.get(1);
            this.apellido = data.get(2);
            this.edad = Integer.parseInt(data.get(3));
            this.direccion = data.get(4);
            this.telefono = data.get(5);
        }
        else
        {
            JOptionPane.showMessageDialog(parent, "Cliente no encontrado");
        }
    }

    @Override
    public void eliminar(Component parent) 
    {
        Crud crudCliente = new Crud();
        crudCliente.delete("DELETE FROM venta WHERE venta.cod_clie = '" + this.codigo + "'");
        crudCliente.delete("DELETE FROM cliente WHERE cliente.codigo = '" + this.codigo + "'");
        
        if (this.codigo.equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Por favor busque un cliente valido.");
        }
        else
        {
            this.codigo = "";
            this.nombre = "";
            this.apellido = "";
            this.edad = 0;
            this.direccion = "";
            this.telefono = "";            
            JOptionPane.showMessageDialog(parent, "Cliente eliminado correctamente.");
        }
    }
    
    @Override
    public void actualizar(Component parent,String codigo,String nombre, String apellido, int edad, String telefono, String fechaN, String usuario, String contrasena)
    {
        try {
            throw new Exception("Error. Funcion no disponible en esta clase");
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actualizar(Component parent,String codigo,String nombre, String apellido, int edad,String direccion, String telefono) 
    {
        if (this.codigo.equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Por favor busque un cliente valido");
        }
        else
        {
            Crud crudCliente = new Crud();
            crudCliente.update("UPDATE cliente SET codigo='" + codigo + "',nombre='" + nombre + "',edad=" + edad +
                    ",dir='" + direccion + "',telefono='" + telefono + "' WHERE codigo='" + this.codigo +"'");   
            
            JOptionPane.showMessageDialog(parent, "Cliente actualizado correctamente");
        }
    }
    
}
