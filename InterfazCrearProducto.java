package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearProducto extends  JFrame {
    final private Font mainFont = new Font("Aptos", Font.BOLD, 20);
    private final Font TituloFont = new Font("Aptos", Font.PLAIN, 20);
    JTextField  cajaNombre, cajaCantidad, cajaDescripcion, cajaPrecio;

    public void initialize() {

        /********* Form panel **********/

        // Creación de etiquetas y cajas de texto
        JLabel etiquetaNombre = new JLabel("Nombres");
        etiquetaNombre.setFont(mainFont);

        cajaNombre = new JTextField();
        cajaNombre.setFont(mainFont);
        cajaNombre.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaCantidad = new JLabel("Cantidad");
        etiquetaCantidad.setFont(mainFont);

        cajaCantidad = new JTextField();
        cajaCantidad.setFont(mainFont);
        cajaCantidad.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaDescripcion = new JLabel("Descripcion");
        etiquetaDescripcion.setFont(mainFont);

        cajaDescripcion = new JTextField();
        cajaDescripcion.setFont(mainFont);
        cajaDescripcion.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaPrecio = new JLabel("Precio");
        etiquetaPrecio.setFont(mainFont);

        cajaPrecio = new JTextField();
        cajaPrecio.setFont(mainFont);
        cajaPrecio.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande


        // Creación del panel de datos con GridBagLayout
        JPanel datosPanel = new JPanel(new GridBagLayout());
        datosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        datosPanel.setOpaque(false);

        // Configuración de GridBagConstraints para las etiquetas y cajas de texto
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        datosPanel.add(etiquetaNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        datosPanel.add(cajaNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        datosPanel.add(etiquetaCantidad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        datosPanel.add(cajaCantidad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        datosPanel.add(etiquetaDescripcion, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        datosPanel.add(cajaDescripcion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        datosPanel.add(etiquetaPrecio, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        datosPanel.add(cajaPrecio, gbc);

        /********* Buttons Panel **********/

        // Creación del panel de botones
        JButton botonCrearCuenta = new JButton("SIGN UP");
        botonCrearCuenta.setFont(TituloFont);
        botonCrearCuenta.setBackground(new Color(51, 190, 255));
        botonCrearCuenta.setBorderPainted(false);
        botonCrearCuenta.setForeground(getForeground());
        botonCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = cajaNombre.getText();
                String Cantidad = cajaCantidad.getText();
                String Descripcion = cajaDescripcion.getText();
                String Precio = cajaPrecio.getText();
                if (Nombre.isEmpty() || Cantidad.isEmpty() || Descripcion.isEmpty() || Precio.length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;
                }
                int codigo = (int) (Math.random() * 1000000);
                String codigoString = "P" + Integer.toString(codigo);
                JOptionPane.showMessageDialog(null, "Producto creado con éxito, su código es: " + codigo);
                Producto nuevoProducto = new Producto(codigoString, Nombre, Cantidad, Descripcion , Precio);
                InterfazAdministrador.addProducto(nuevoProducto);
                Main.productos.add(nuevoProducto);
                dispose();
            }   
        });

        JButton botonDeVolver = new JButton("Volver");
        botonDeVolver.setFont(mainFont);
        botonDeVolver.setForeground(new Color(1, 40, 144));
        botonDeVolver.setBorderPainted(false);
        botonDeVolver.setContentAreaFilled(false);
        botonDeVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(botonCrearCuenta);
        buttonPanel.add(botonDeVolver);
        buttonPanel.setLayout(new GridLayout(3, 2, 5, 5));
        buttonPanel.setOpaque(false);

        /********* Add components to main panel **********/

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(207, 234, 247));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(datosPanel, BorderLayout.NORTH);
        panelPrincipal.add(buttonPanel, BorderLayout.SOUTH);

        add(panelPrincipal);

        /********* Frame settings **********/

        setTitle("Crear Producto");
        setContentPane(panelPrincipal);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // Si Nimbus no está disponible, puedes establecer el LookAndFeel a otro que te guste.
                // Si no puedes establecer ningún LookAndFeel, la aplicación seguirá utilizando el LookAndFeel predeterminado.
            }
        InterfazCrearProducto nuevoProducto = new InterfazCrearProducto();
        nuevoProducto.initialize();
        
    }
}


