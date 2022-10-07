package interfaz;
// Autor @DavidBP014
// Redimensionar imagenes
import backend.Venta;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmVentas extends javax.swing.JInternalFrame {

    //VARIABLES GLOBALES
    Float precioUnidad;

    public frmVentas() {
        initComponents();
    }

    private void RealizarVentar() {
        if (txt_buscarInformacion.getText().equals("Código cliente, Código empleado, Código articulo")) {
            JOptionPane.showMessageDialog(this, "Es necesario brindar los tres códigos para realizar la correcta búsqueda");
        } else {
            String cadenaDatos = "";
            cadenaDatos = txt_buscarInformacion.getText();
            String[] codigos= cadenaDatos.split(",");

            if (codigos.length != 3) {
                JOptionPane.showMessageDialog(this, "Es necesario suministrar los 3 códigos.");

                txt_nombreCliente.setText("--.--");
                txt_apellidoCliente.setText("--.--");
                txt_nombreEmpleado.setText("--.--");
                txt_apellidoEmpleado.setText("--.--");
                txt_nombreArticulo.setText("--.--");
                txt_precio.setText("--.--");
                txt_cantidad.setText("--.--");
                txt_cantidadArticulos.setText("");
                txt_totalPagar.setText("--.--");

                txt_buscarInformacion.setText("Código cliente, Código empleado, Código articulo");
                txt_buscarInformacion.requestFocus();
                txt_buscarInformacion.selectAll();

                //Luego de guardar en la db ventas: no permite que se pueda escribir la cantidad
                txt_cantidadArticulos.setEnabled(false);

            } else {

                boolean habilitarCantidad = false;

                Venta venta = new Venta(codigos[0],codigos[1],codigos[2]);
                ArrayList<String> info = venta.buscar(this);
                if (!info.contains(""))
                {
                    habilitarCantidad = true;

                    txt_nombreCliente.setText(info.get(0));
                    txt_apellidoCliente.setText(info.get(1));
                    txt_nombreEmpleado.setText(info.get(2));
                    txt_apellidoEmpleado.setText(info.get(3));
                    txt_nombreArticulo.setText(info.get(4));
                    txt_precio.setText(info.get(5));
                    txt_cantidad.setText(info.get(6));
                }
                else
                {
                    txt_nombreCliente.setText("--.--");
                    txt_apellidoCliente.setText("--.--");
                    txt_nombreEmpleado.setText("--.--");
                    txt_apellidoEmpleado.setText("--.--");
                    txt_nombreArticulo.setText("--.--");
                    txt_precio.setText("--.--");
                    txt_cantidad.setText("--.--");
                    txt_cantidadArticulos.setText("");
                    txt_totalPagar.setText("--.--");

                    txt_buscarInformacion.setText("Código cliente, Código empleado, Código articulo");
                    txt_buscarInformacion.requestFocus();
                    txt_buscarInformacion.selectAll();
                }
                if (habilitarCantidad) {
                    //PERMITE AGREGAR CANTIDAD AL INPUT
                    txt_cantidadArticulos.setEnabled(true);
                } else {
                    //evitar agregar cantidad si el codigo es incorrecto
                    txt_cantidadArticulos.setEnabled(false);    
                }
                
            }

        }
    }

    //Permitir solo numeros en el input
    private void inputNumeros(java.awt.event.KeyEvent evt) {
        char key = (char) evt.getKeyChar();
        if (Character.isDigit(key)) {
            evt.setKeyChar(key);
        } else {
            evt.consume();
        }
    }
};
