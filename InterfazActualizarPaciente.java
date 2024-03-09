package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazActualizarPaciente extends JFrame {
    final private Font mainFont = new Font("Aptos", Font.BOLD, 20);
    private final Font TituloFont = new Font("Aptos", Font.PLAIN, 20);
    JTextField cajaPassword, cajaNombre, cajaApellido, cajaEdad;
    private String[] generos = {"Selecciona la opción", "Masculino", "Femenino"};
    private JComboBox<String> cajaGenero = new JComboBox<>(generos);
    private Usuario paciente;
    
    public InterfazActualizarPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

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

      // Botón para actualizar doctor
      JButton botonActualizar = new JButton("Actualizar");
      botonActualizar.setFont(TituloFont);
      botonActualizar.setBackground(new Color(51, 190, 255));
      botonActualizar.setBorderPainted(false);
      botonActualizar.setForeground(getForeground());
      botonActualizar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              actualizarPaciente();
          }
      });
      

      JButton botonCancelar = new JButton("Cancelar");
      botonCancelar.setFont(mainFont);
      botonCancelar.setForeground(new Color(1, 40, 144));
      botonCancelar.setBorderPainted(false);
      botonCancelar.setContentAreaFilled(false);
      botonCancelar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              dispose();
          }
      });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(botonActualizar);
      buttonPanel.add(botonCancelar);
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

      setTitle("Actualizar Paciente");
      setContentPane(panelPrincipal);
      setSize(450, 500);
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);

      // Llenar los campos de texto con los datos del doctor
      cajaNombre.setText(paciente.getNombres());
      cajaApellido.setText(Usuario.getApellidos());
      cajaPassword.setText(paciente.getContrasena());
      cajaGenero.setSelectedItem(paciente.getGenero());
      cajaEdad.setText(paciente.getEdad());
  }

  private void actualizarPaciente() {
      // Obtener los datos actualizados del doctor desde los campos de texto
      String nombre = cajaNombre.getText();
      String apellido = cajaApellido.getText();
      String password = cajaPassword.getText();
      String genero = (String) cajaGenero.getSelectedItem();
      String edad = cajaEdad.getText();

      // Actualizar los datos del doctor
      paciente.setNombres(nombre);
      paciente.setApellidos(apellido);
      paciente.setContrasena(password);
      paciente.setEdad(edad);
      paciente.setGenero(genero);

      // Mostrar un mensaje de éxito
      JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente.");

      // Actualizar el doctor en la lista
      Main.actualizarPacienteEnLista(paciente);

      // Cerrar la ventana
      dispose();
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
  }
}
