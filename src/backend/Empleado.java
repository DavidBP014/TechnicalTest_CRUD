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
public class Empleado extends Persona
{
    private String fecha_nacimiento;
    private String usuario;
    private String contrasena;
    
    public Empleado(String codigo,String nombre, String apellido, int edad, String telefono, String fechaN, String usuario, String contrasena) 
    {
        super(codigo, nombre, apellido, edad, telefono);
        this.fecha_nacimiento = fechaN;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Empleado() 
    {
        super("", "", "", 0, "");
        this.fecha_nacimiento = "";
        this.usuario = "";
        this.contrasena = "";
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    @Override
    public void registrar(Component parent) 
    {
        Crud crudCliente = new Crud();
        boolean done = crudCliente.create("INSERT INTO empleado VALUES('" + this.codigo + "','"+
                  this.nombre + "','" + this.apellido + "'," + this.edad +
                    ",'" + this.telefono + "','" + this.fecha_nacimiento + "','" + this.usuario + "','" + this.contrasena + "')");
        if (done)
            JOptionPane.showMessageDialog(parent, "Empleado registrado correctamente");
        else
            JOptionPane.showMessageDialog(parent, "Ocurrio un error al registrar el empleado");
    }

    @Override
    public void buscar(Component parent,String codigo) 
    {
        Crud crudCliente = new Crud();
        ArrayList <String> data = crudCliente.read("SELECT * FROM empleado WHERE empleado.codigo = '" + codigo + "'");
        
        if (data != null)
        {
            this.codigo = data.get(0);
            this.nombre = data.get(1);
            this.apellido = data.get(2);
            this.edad = Integer.parseInt(data.get(3));
            this.telefono = data.get(4);
            this.fecha_nacimiento = data.get(5);
            this.usuario = data.get(6);
            this.contrasena = data.get(7);
        }
        else
        {
            JOptionPane.showMessageDialog(parent, "Empleado no encontrado");
        }
    }

    @Override
    public void eliminar(Component parent) 
    {
        Crud crudCliente = new Crud();
        crudCliente.delete("DELETE FROM venta WHERE venta.cod_emp = '" + this.codigo + "'");
        crudCliente.delete("DELETE FROM empleado WHERE empleado.codigo = '" + this.codigo + "'");
        
        if (this.codigo.equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Por favor busque un Empleado valido.");
        }
        else
        {
            this.codigo = "";
            this.nombre = "";
            this.apellido = "";
            this.edad = 0;
            this.telefono = "";     
            this.fecha_nacimiento = "";
            this.usuario = "";
            this.contrasena = "";
            JOptionPane.showMessageDialog(parent, "Empleado eliminado correctamente.");
        }
    }

    @Override
    public void actualizar(Component parent, String codigo,String nombre, String apellido, int edad,String direccion, String telefono)
    {
        try {
            throw new Exception("Error. Funcion no disponible en esta clase");
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actualizar(Component parent,String codigo,String nombre, String apellido, int edad, String telefono, String fechaN, String usuario, String contrasena) 
    {
        if (this.codigo.equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Por favor busque un empleado valido");
        }
        else
        {
            Crud crudCliente = new Crud();
            crudCliente.update("UPDATE empleado SET codigo='" + codigo + "',nombre='" + nombre + "',edad=" + edad +
                    ",telefono='" + telefono + "',fecha_nacimiento='" + fechaN + "',usuario='" + 
                            usuario + "',contrasena='" + contrasena + "' WHERE codigo='" + this.codigo +"'");   
            
            JOptionPane.showMessageDialog(parent, "Empleado actualizado correctamente");
        }
    }
    
}
