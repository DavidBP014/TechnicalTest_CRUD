package interfaz;
// Autor @DavidBP014
import database.Reportes;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmReporte extends javax.swing.JInternalFrame {

    //Titulo de las tablas
    String tituloVenta[] = {
        "Codigo",
        "Cod_emp",
        "Cod_cli",
        "Cod_art",
        "Fecha",
        "Hora",
        "Cantidad",
        "Valor"
    };

    String titulosClientes[] = {
        "Codigo",
        "Nombre",
        "Apellido",
        "Edad",
        "Dirección",
        "Teléfono",};

    String titulosEmpleados[] = {
        "Codigo",
        "Nombre",
        "Apellido",
        "Edad",
        "Fecha nacimiento",
        "Teléfono",
        "Usuario",
        "Contraseña"
    };

    String titulosArticulos[] = {
        "Codigo",
        "Titulo",
        "Género",
        "Precio",
        "Cantidad",
        "Tipo"
    };

    //Tabla para clientes,modelos,articulos,ventas
    DefaultTableModel modeloGeneral = new DefaultTableModel();

    //Tablas del modelo general
    DefaultTableModel modeloIDcliente = new DefaultTableModel();
    DefaultTableModel modeloIDempleado = new DefaultTableModel();
    DefaultTableModel modeloIDarticulo = new DefaultTableModel();

    DefaultTableModel modeloBusquedaGeneral = new DefaultTableModel();
    DefaultTableModel modeloBusquedaInfo = new DefaultTableModel();

    public frmReporte() {
        initComponents();
    }

    //Detectar la tecla enter
    private boolean teclaEnter(java.awt.event.KeyEvent evt) {
        boolean result = false;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            result = true;
        }
        return result;
    }
};
