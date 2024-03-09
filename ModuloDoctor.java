package src;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ModuloDoctor extends JFrame {
    static DefaultTableModel modeloTablaCitas = new DefaultTableModel();
  
    public ModuloDoctor() {     

        // Añade componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(new JLabel("Bienvenido a la interfaz del doctor"));
        add(panel);

        // Crea un nuevo panel con tres botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(new JButton("Botón 1"));
        panelBotones.add(new JButton("Botón 2"));
        panelBotones.add(new JButton("Botón 3"));
        add(panelBotones, BorderLayout.SOUTH);

        // Establece un tamaño para la ventana
        setSize(500, 500);   

        // Crea un panel principal con un diseño de tres columnas
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 3));
        panelPrincipal.add(new JLabel("Columna 1"));
        panelPrincipal.add(new JLabel("Columna 2"));
        panelPrincipal.add(new JLabel("Columna 3"));
        add(panelPrincipal, BorderLayout.CENTER);
    }
}