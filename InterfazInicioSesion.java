package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase principal que representa la ventana de inicio de sesión
public class InterfazInicioSesion extends JFrame {
    // Definición de variables miembro
    private final Font mainFont = new Font("Tahoma", Font.BOLD, 20);
    private final Font TituloFont = new Font("Tahoma", Font.PLAIN, 20);
    public static JTextField cajaCodigo;
    private JTextField cajaPassword;

    // Método para inicializar la ventana de inicio de sesión
    public void initialize() {
        // Creación del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta para el campo "Código"
        JLabel etiquetaCodigo = new JLabel("Código", SwingConstants.CENTER);
        etiquetaCodigo.setFont(mainFont);

        // Campo de texto para ingresar el código
        cajaCodigo = new JTextField();
        cajaCodigo.setFont(mainFont);

        // Etiqueta para el campo "Password"
        JLabel etiquetaPassword = new JLabel("Password", SwingConstants.CENTER);
        etiquetaPassword.setFont(mainFont);

        // Campo de texto para ingresar la contraseña
        cajaPassword = new JPasswordField();
        cajaPassword.setFont(mainFont);

        // Botón para iniciar sesión
        JButton botonIniciarSesion = new JButton("LOGIN");
        botonIniciarSesion.setFont(TituloFont);
        botonIniciarSesion.setBackground(new Color(51, 190, 255));
        botonIniciarSesion.setBorderPainted(false);
        botonIniciarSesion.addActionListener(new ActionListener() {
            // Evento al hacer clic en el botón de iniciar sesión
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = cajaCodigo.getText();
                String password = new String(((JPasswordField) cajaPassword).getPassword());

                if (codigo.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                    return;
                }

                // Verificar si el usuario es un administrador
                if (codigo.equals(Main.administrador.getCodigo()) && password.equals(Main.administrador.getContrasena())) {
                    JOptionPane.showMessageDialog(null, "Login exitoso como administrador");
                    SwingUtilities.invokeLater(() -> {
                        InterfazAdministrador interfazAdministrador = new InterfazAdministrador(Main.doctores, Main.usuarios, Main.productos);
                        interfazAdministrador.setVisible(true);
                    });
                    return;
                }

                // Verificar si el usuario es un doctor o paciente
                for (Usuario usuario : Main.usuarios) {
                    if (usuario.getCodigo().equals(codigo) && usuario.getContrasena().equals(password)) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombres() + " " + Usuario.getApellidos());
                        if (usuario instanceof Doctor) {
                            ModuloDoctor interfazDoctor = new ModuloDoctor();
                            interfazDoctor.setVisible(true);
                        } else {
                            ModuloPaciente interfazPaciente = new ModuloPaciente(usuario);
                             interfazPaciente.initialize();
                            interfazPaciente.setVisible(true);
                        }
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        });

        // Botón para crear una cuenta nueva
        JButton botonCrearCuenta = new JButton("¿No tienes cuenta? Registrate");
        botonCrearCuenta.setFont(mainFont);
        botonCrearCuenta.setForeground(new Color(1, 70, 144));
        botonCrearCuenta.setBorderPainted(false);
        botonCrearCuenta.setContentAreaFilled(false);
        botonCrearCuenta.addActionListener(new ActionListener() {
            // Evento al hacer clic en el botón de crear cuenta
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazUsuario nuevoUsuario = new InterfazUsuario();
                nuevoUsuario.initialize();
            }
        });

        // Icono de usuario
        ImageIcon userIcon = new ImageIcon("proyect\\proyect\\proyect\\src\\fotoUsuario.png");
        Image userImage = userIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(userImage);
        JLabel labelUser = new JLabel(userIcon);

        // Panel de formulario con campos de código y contraseña
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(etiquetaCodigo);
        formPanel.add(cajaCodigo);
        formPanel.add(etiquetaPassword);
        formPanel.add(cajaPassword);

        // Panel de botones para iniciar sesión y crear cuenta
        JPanel paneldeBotones = new JPanel();
        paneldeBotones.setLayout(new GridLayout(3, 2, 5, 5));
        paneldeBotones.setOpaque(false);
        paneldeBotones.add(botonIniciarSesion);
        paneldeBotones.add(botonCrearCuenta);

        // Panel principal que contiene todos los componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(207, 234, 247));
        mainPanel.add(labelUser, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(paneldeBotones, BorderLayout.SOUTH);
        add(mainPanel);

        // Configuración de la ventana
        setTitle("Login");
        setSize(300, 300);
        setMinimumSize(new Dimension(600, 450));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        InterfazInicioSesion proyecto1 = new InterfazInicioSesion();
        proyecto1.initialize();
    }
}
