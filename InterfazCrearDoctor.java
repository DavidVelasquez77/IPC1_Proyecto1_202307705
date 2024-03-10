package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearDoctor extends JFrame {
    final private Font mainFont = new Font("Aptos", Font.BOLD, 20);
    private final Font TituloFont = new Font("Aptos", Font.PLAIN, 20);
    JTextField cajaPassword, cajaNombre, cajaApellido, cajaEdad, cajaEspecialidad, cajaTelefono;

    public void initialize() {

        /********* Form panel **********/

        // Creación de etiquetas y cajas de texto
        JLabel etiquetaNombre = new JLabel("Nombres");
        etiquetaNombre.setFont(mainFont);

        cajaNombre = new JTextField();
        cajaNombre.setFont(mainFont);
        cajaNombre.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaApellido = new JLabel("Apellidos");
        etiquetaApellido.setFont(mainFont);

        cajaApellido = new JTextField();
        cajaApellido.setFont(mainFont);
        cajaApellido.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaespecialidad = new JLabel("Especialidad");
        etiquetaespecialidad.setFont(mainFont);

        cajaEspecialidad = new JTextField();
        cajaEspecialidad.setFont(mainFont);
        cajaEspecialidad.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaPassword = new JLabel("Password");
        etiquetaPassword.setFont(mainFont);

        cajaPassword = new JPasswordField();
        cajaPassword.setFont(mainFont);
        cajaPassword.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel lblGenero = new JLabel("Género");
        lblGenero.setFont(mainFont);

        JLabel etiquetaTelefono = new JLabel("Telefono");
        etiquetaTelefono.setFont(mainFont);

        cajaTelefono = new JTextField();
        cajaTelefono.setFont(mainFont);
        cajaTelefono.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

        JLabel etiquetaEdad = new JLabel("Edad");
        etiquetaEdad.setFont(mainFont);

        cajaEdad = new JTextField();
        cajaEdad.setFont(mainFont);
        cajaEdad.setPreferredSize(new Dimension(250, 30)); // Tamaño más grande

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
        datosPanel.add(etiquetaespecialidad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        datosPanel.add(cajaEspecialidad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        datosPanel.add(etiquetaPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        datosPanel.add(cajaPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        datosPanel.add(lblGenero, gbc); // Agregar etiqueta de género

        gbc.gridx = 1;
        gbc.gridy = 4;
        datosPanel.add(cajaGenero, gbc); // Agregar caja de género

        gbc.gridx = 0;
        gbc.gridy = 5;
        datosPanel.add(etiquetaTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        datosPanel.add(cajaTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        datosPanel.add(etiquetaEdad, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
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
                String Especialidad = cajaEspecialidad.getText();
                String Password = new String(cajaPassword.getText());
                String Telefono = cajaTelefono.getText();
                String Genero = (String) cajaGenero.getSelectedItem();
                if (Nombre.isEmpty() || Apellido.isEmpty() || Edad.isEmpty() || Password.length() == 0 || Genero.equals("Selecciona uno")) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;
                }
                int codigo = (int) (Math.random() * 1000000);
                String codigoString = "D" + Integer.toString(codigo);
                JOptionPane.showMessageDialog(null, "Cuenta creada con éxito, tu código es: " + codigo);
                Doctor nuevoDoctor = new Doctor(codigoString,Password, Nombre, Apellido, Especialidad , Genero, Telefono, Edad);
                InterfazAdministrador.addDoctor(nuevoDoctor, null);
                Main.usuarios.add(nuevoDoctor);
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

        setTitle("Crear Doctor");
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
        InterfazCrearDoctor nuevoDoctor = new InterfazCrearDoctor();
        nuevoDoctor.initialize();
        
    }
}
