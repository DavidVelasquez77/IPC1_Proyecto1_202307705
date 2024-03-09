package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario extends JFrame {
    final private Font mainFont = new Font("Aptos", Font.BOLD, 20);
    private final Font TituloFont = new Font("Aptos", Font.PLAIN, 20);
    JTextField cajaPassword, cajaNombre, cajaApellido, cajaEdad;


    public void initialize() {

        /********* Form panel **********/

        // Creación de etiquetas y cajas de texto
        JLabel etiquetaNombre = new JLabel("Nombres");
        etiquetaNombre.setFont(mainFont);

        cajaNombre = new JTextField();
        cajaNombre.setFont(mainFont);
        cajaNombre.setColumns(15); // Ajusta el ancho de la caja de texto (en caracteres)

        JLabel etiquetaApellido = new JLabel("Apellidos");
        etiquetaApellido.setFont(mainFont);

        cajaApellido = new JTextField();
        cajaApellido.setFont(mainFont);
        cajaApellido.setColumns(15); // Ajusta el ancho de la caja de texto (en caracteres)

        JLabel etiquetaPassword = new JLabel("Password");
        etiquetaPassword.setFont(mainFont);

        cajaPassword = new JPasswordField();
        cajaPassword.setFont(mainFont);
        cajaPassword.setColumns(15); // Ajusta el ancho de la caja de texto (en caracteres)

        JLabel lblGenero = new JLabel("Género");
        lblGenero.setFont(mainFont);

        JLabel etiquetaEdad = new JLabel("Edad");
        etiquetaEdad.setFont(mainFont);

        cajaEdad = new JTextField();
        cajaEdad.setFont(mainFont);
        cajaEdad.setColumns(15); // Ajusta el ancho de la caja de texto (en caracteres)

        String[] generos = {"Selecciona la opción", "Masculino", "Femenino"};
        JComboBox<String> cajaGenero = new JComboBox<>(generos);
        cajaGenero.setFont(mainFont);

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
        datosPanel.add(etiquetaApellido, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        datosPanel.add(cajaApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        datosPanel.add(etiquetaPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        datosPanel.add(cajaPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        datosPanel.add(lblGenero, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        datosPanel.add(cajaGenero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        datosPanel.add(etiquetaEdad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        datosPanel.add(cajaEdad, gbc);

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
                String Apellido = cajaApellido.getText();
                String Edad = cajaEdad.getText();
                String Password = new String(cajaPassword.getText());
                String Genero = (String) cajaGenero.getSelectedItem();
                if (Nombre.isEmpty() || Apellido.isEmpty() || Edad.isEmpty() || Password.length() == 0 || Genero.equals("Selecciona uno")) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;
                }
                int codigo = (int) (Math.random() * 1000000);
                String codigoString = "U" + Integer.toString(codigo);
                JOptionPane.showMessageDialog(null, "Cuenta creada con éxito, tu código es: " + codigo);
                Usuario nuevoUsuario = new Usuario(codigoString, Password, Nombre, Apellido, Genero, Edad);
                InterfazAdministrador.addUsuario(nuevoUsuario);
                Main.usuarios.add(nuevoUsuario);
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

        setTitle("Crear Cuenta");
        setContentPane(panelPrincipal);
        setSize(450, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        InterfazUsuario nuevoUsuario = new InterfazUsuario();
        nuevoUsuario.initialize();
    }
}