package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazActualizarProducto extends JFrame {
    final private Font mainFont = new Font("Aptos", Font.BOLD, 20);
    private final Font TituloFont = new Font("Aptos", Font.PLAIN, 20);
    JTextField  cajaNombre, cajaCantidad, cajaDescripcion, cajaPrecio;

    private Producto producto;

    public InterfazActualizarProducto(Producto producto) {
        this.producto = producto;
    }

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
              actualizarProducto();
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

      setTitle("Actualizar Producto");
      setContentPane(panelPrincipal);
      setSize(450, 500);
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);

      // Llenar los campos de texto con los datos del doctor
      cajaNombre.setText(producto.getNombres());
      cajaCantidad.setText(producto.getCantidad());
      cajaDescripcion.setText(producto.getDescripcion());
      cajaPrecio.setText(producto.getPrecio());
  }

  private void actualizarProducto() {
      // Obtener los datos actualizados del doctor desde los campos de texto
      String Nombre = cajaNombre.getText();
      String Cantidad = cajaCantidad.getText();
      String Descripcion = cajaDescripcion.getText();
      String Precio = cajaPrecio.getText();

      // Actualizar los datos del doctor
      producto.setNombres(Nombre);
      producto.setCantidad(Cantidad);
      producto.setDescripcion(Descripcion);
      producto.setPrecio(Precio);

      // Mostrar un mensaje de éxito
      JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");

      // Actualizar el doctor en la lista
      Main.actualizarProductoEnLista(producto);

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