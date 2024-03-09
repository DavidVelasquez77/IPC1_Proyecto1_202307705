        package src;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.util.List;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

        public class InterfazAdministrador extends JFrame { 
            static DefaultTableModel modeloTablaDoctores = new DefaultTableModel();
            static DefaultTableModel modeloTablaUsuarios = new DefaultTableModel();
            static DefaultTableModel modeloTablaProducto = new DefaultTableModel();
            private JTabbedPane tabbedPane;

            public InterfazAdministrador(List<Doctor> doctores, List<Usuario> usuarios, List<Producto> productos){
                initComponents(doctores, usuarios, productos);
            }

            private void initComponents(List<Doctor> doctores, List<Usuario> usuarios, List<Producto> productos) {
                setTitle("Administrador");
                setSize(1200, 300);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                getContentPane().setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo

                tabbedPane = new JTabbedPane(); 

                // Crear pestaña de Doctores
                JPanel panelDoctores = new JPanel(new BorderLayout());
                panelDoctores.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo
                JTable tablaDoctores = new JTable();

                JLabel tituloPanelDoctores = new JLabel("Listado Doctores");
                tituloPanelDoctores.setHorizontalAlignment(SwingConstants.CENTER);
                panelDoctores.add(tituloPanelDoctores, BorderLayout.NORTH);
                if (modeloTablaDoctores.getColumnCount() == 0) {
                modeloTablaDoctores.addColumn("Codigo");
                modeloTablaDoctores.addColumn("Nombres");
                modeloTablaDoctores.addColumn("Apellidos");
                modeloTablaDoctores.addColumn("Contraseña");
                modeloTablaDoctores.addColumn("Especialidad");
                modeloTablaDoctores.addColumn("Genero");
                modeloTablaDoctores.addColumn("Telefono");
                modeloTablaDoctores.addColumn("Edad");
                }
                for (Doctor doctor : doctores) {
                    modeloTablaDoctores.addRow(new Object[]{
                        doctor.getCodigo(), // Agregar código
                        doctor.getNombres(), // Agregar nombres
                        Doctor.getApellidos(), // Agregar apellidos
                        doctor.getEspecialidad(), // Agregar especialidad
                        doctor.getGenero(), // Agregar genero
                        doctor.getTelefono(), // Agregar teléfono
                        doctor.getEdad() // Agregar edad
                    });
                }
                tablaDoctores.setModel(modeloTablaDoctores);
                JScrollPane scrollPaneDoctores = new JScrollPane(tablaDoctores);
                panelDoctores.add(scrollPaneDoctores, BorderLayout.CENTER);


                //************************  botones de doctor ****************************
                JPanel panelBotonDoctores = new JPanel(new FlowLayout(FlowLayout.LEADING));
                panelBotonDoctores.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo

                JButton botonRegistrarDoctor = new JButton("Registrar Doctor");
                botonRegistrarDoctor.setForeground(Color.BLACK); // Establecer color de letras negro
                botonRegistrarDoctor.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonDoctores.add(botonRegistrarDoctor);
                botonRegistrarDoctor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InterfazCrearDoctor interfazCrearDoctor = new InterfazCrearDoctor();
                        interfazCrearDoctor.initialize();
                    }
                });

                JButton botonActualizarDoctor = new JButton("Actualizar Doctor");
                botonActualizarDoctor.setForeground(Color.BLACK); // Establecer color de letras negro
                botonActualizarDoctor.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonDoctores.add(botonActualizarDoctor);
                botonActualizarDoctor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código del doctor a actualizar:");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            Doctor doctor = buscarDoctorPorCodigo(codigo);
                            if (doctor != null) {
                                InterfazActualizarDoctor interfazActualizarDoctor = new InterfazActualizarDoctor(doctor);
                                interfazActualizarDoctor.initialize();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró un doctor con el código proporcionado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });

                JButton botonEliminarDoctor = new JButton("Eliminar Doctor");
                botonEliminarDoctor.setForeground(Color.BLACK); // Establecer color de letras negro
                botonEliminarDoctor.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonDoctores.add(botonEliminarDoctor);
                botonEliminarDoctor.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código del doctor a eliminar:");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            eliminarDoctorPorCodigo(codigo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });

                panelDoctores.add(panelBotonDoctores, BorderLayout.EAST);

                //************* Crear pestaña de Pacientes******************

                JPanel panelUsuarios = new JPanel(new BorderLayout());
                panelUsuarios.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo

                JLabel tituloPanelUsuarios = new JLabel("Listado Usuarios");
                tituloPanelUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
                panelUsuarios.add(tituloPanelUsuarios, BorderLayout.NORTH);
                if (modeloTablaUsuarios.getColumnCount() == 0) {
                modeloTablaUsuarios.addColumn("Codigo");
                modeloTablaUsuarios.addColumn("Nombres");
                modeloTablaUsuarios.addColumn("Apellidos");
                modeloTablaUsuarios.addColumn("Contraseña");
                modeloTablaUsuarios.addColumn("Genero");
                modeloTablaUsuarios.addColumn("Edad");
                }   
                for (Usuario usuario : usuarios) {
                    modeloTablaUsuarios.addRow(new Object[]{
                        usuario.getCodigo(), // Agregar código
                        usuario.getNombres(), // Agregar nombres
                        Usuario.getApellidos(), // Agregar apellidos
                        usuario.getContrasena(), // Agregar contraseña
                        usuario.getGenero(), // Agregar genero
                        usuario.getEdad() // Agregar edad
                    });
                }

                JTable tablaUsuarios = new JTable(modeloTablaUsuarios);
                JScrollPane scrollPaneUsuarios = new JScrollPane(tablaUsuarios);
                panelUsuarios.add(scrollPaneUsuarios, BorderLayout.CENTER);

                //************************  botones de usuarios ****************************
                JPanel panelBotonUsuarios = new JPanel(new FlowLayout(FlowLayout.LEADING));
                panelBotonUsuarios.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo

                JButton botonRegistrarUsuario = new JButton("Registrar paciente");
                botonRegistrarUsuario.setForeground(Color.BLACK);
                botonRegistrarUsuario.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonUsuarios.add(botonRegistrarUsuario);
                botonRegistrarUsuario.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InterfazUsuario interfazCrearUsuario = new InterfazUsuario();
                        interfazCrearUsuario.initialize();
                    }
                });

                JButton botonActualizarUsuario = new JButton("Actualizar Paciente");
                botonActualizarUsuario.setForeground(Color.BLACK);
                botonActualizarUsuario.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonUsuarios.add(botonActualizarUsuario);
                botonActualizarUsuario.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código del paciente a actualizar:");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            Usuario usuario = buscarPacientePorCodigo(codigo);
                            if (usuario != null) {
                                InterfazActualizarPaciente interfazActualizarPaciente = new InterfazActualizarPaciente(usuario);
                                interfazActualizarPaciente.initialize();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró un paciente con el código proporcionado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });

                JButton botonEliminarUsuario = new JButton("Eliminar Paciente");
                botonEliminarUsuario.setForeground(Color.BLACK);
                botonEliminarUsuario.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                panelBotonUsuarios.add(botonEliminarUsuario);
                botonEliminarUsuario.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código del doctor a eliminar:");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            eliminarUsuarioPorCodigo(codigo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });
        

                panelUsuarios.add(panelBotonUsuarios, BorderLayout.EAST);

                //************* Crear pestaña de Productos******************

                JPanel panelProductos = new JPanel(new BorderLayout());
                panelProductos.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo

                JLabel tituloPanelProducto = new JLabel("Listado de productos");
                tituloPanelProducto.setHorizontalAlignment(SwingConstants.CENTER);
                panelProductos.add(tituloPanelProducto, BorderLayout.NORTH);
                if (modeloTablaProducto.getColumnCount() == 0) {
                modeloTablaProducto.addColumn("Codigo");
                modeloTablaProducto.addColumn("Nombre");
                modeloTablaProducto.addColumn("Cantidad");
                modeloTablaProducto.addColumn("Descripción");
                modeloTablaProducto.addColumn("Precio");
                }
                for (Producto producto : productos) {
                    modeloTablaProducto.addRow(new Object[]{
                        producto.getCodigo(), // Agregar código
                        producto.getNombres(), // Agregar nombres
                        producto.getCantidad(), // Agregar cantidad
                        producto.getDescripcion(), // Agregar descripcion
                        producto.getPrecio(), // Agregar precio
                    });
                }

                JTable tablaProducto = new JTable(modeloTablaProducto);
                JScrollPane scrollPaneProducto = new JScrollPane(tablaProducto);
                panelProductos.add(scrollPaneProducto, BorderLayout.CENTER);
                //************************  botones de producto ****************************
                JPanel panelBotonProducto = new JPanel(new FlowLayout(FlowLayout.LEADING));
                panelBotonProducto.setBackground(new Color(207, 234, 247)); // Establecer color celeste de fondo
                
                JButton botonRegistrarProducto = new JButton("Registrar Producto");
                botonRegistrarProducto.setForeground(Color.BLACK);
                botonRegistrarProducto.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                botonRegistrarProducto.setBounds(10, 14, 2, 2);
                panelBotonProducto.add(botonRegistrarProducto);
                botonRegistrarProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InterfazCrearProducto interfazCrearProducto = new InterfazCrearProducto();
                        interfazCrearProducto.initialize();
                    }
                });

                JButton botonActualizarProducto = new JButton("Actualizar Producto");
                botonActualizarProducto.setForeground(Color.BLACK);
                botonActualizarProducto.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                botonActualizarProducto.setBounds(10, 20, 2, 2);
                panelBotonProducto.add(botonActualizarProducto);
                botonActualizarProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String codigo = JOptionPane.showInputDialog("Ingrese el código del prodcuto a actualizar:");
                        if (codigo != null && !codigo.trim().isEmpty()) {
                            Producto producto = buscarProductoPorCodigo(codigo); // Corrección aquí
                            if (producto != null) {
                                InterfazActualizarProducto InterfazActualizarProducto = new InterfazActualizarProducto(producto);
                                InterfazActualizarProducto.initialize();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró un producto con el código proporcionado.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });
                JButton botonEliminarProducto = new JButton("Eliminar Producto");
                botonEliminarProducto.setForeground(Color.BLACK);
                botonEliminarProducto.setBackground(new Color(51, 190, 255)); // Establecer color de fondo celeste
                botonEliminarProducto.setBounds(10, 26, 2, 2);
                panelBotonProducto.add(botonEliminarProducto);
                botonEliminarProducto.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String producto = JOptionPane.showInputDialog("Ingrese el código del producto a eliminar:");
                        if (producto != null && !producto.trim().isEmpty()) {
                            eliminarProductoPorCodigo(producto);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe proporcionar un código válido.");
                        }
                    }
                });

                panelProductos.add(panelBotonProducto, BorderLayout.EAST);

                tabbedPane.addTab("Doctores", panelDoctores);
                tabbedPane.addTab("Usuarios", panelUsuarios);
                tabbedPane.addTab("Productos", panelProductos);
                getContentPane().add(tabbedPane);
            }

            public static void addDoctor(Doctor doctor) {
                modeloTablaDoctores.addRow(new Object[]{doctor.getCodigo(), doctor.getNombres(), Doctor.getApellidos(), doctor.getContrasena(), doctor.getEspecialidad(), doctor.getGenero(), doctor.getTelefono(), doctor.getEdad()});
            }

            public static void addUsuario(Usuario usuario){
                modeloTablaUsuarios.addRow(new Object[]{usuario.getCodigo(), usuario.getNombres(), Usuario.getApellidos(), usuario.getContrasena(), usuario.getGenero(), usuario.getEdad()});
            }
            public static void addProducto(Producto producto){
                 modeloTablaProducto.addRow(new Object[]{producto.getCodigo(), producto.getNombres(), producto.getCantidad(), producto.getDescripcion(), producto.getPrecio()});
            }

            public void eliminarDoctorPorCodigo(String codigo) {
                for (int i = 0; i < modeloTablaDoctores.getRowCount(); i++) {
                    if (modeloTablaDoctores.getValueAt(i, 0).equals(codigo)) {
                        modeloTablaDoctores.removeRow(i);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "No se encontró un doctor con el código proporcionado.");
            }
            public Doctor buscarDoctorPorCodigo(String codigo) {
                for (Usuario doctor : Main.usuarios) {
                    if (doctor instanceof Doctor && doctor.getCodigo().equals(codigo)) {
                        return (Doctor) doctor;
                    }
                }
                return null;
            }
            public void eliminarUsuarioPorCodigo(String codigo) {
                for (int i = 0; i < modeloTablaUsuarios.getRowCount(); i++) {
                    if (modeloTablaUsuarios.getValueAt(i, 0).equals(codigo)) {
                        modeloTablaUsuarios.removeRow(i);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "No se encontró un usuario con el código proporcionado.");
            }

            public Usuario buscarPacientePorCodigo(String codigo) {
                for (Usuario usuario : Main.usuarios) {
                    if (usuario instanceof Usuario && usuario.getCodigo().equals(codigo)) {
                        return (Usuario) usuario;
                    }
                }
                return null;
            }
            
            public void eliminarProductoPorCodigo(String codigo) {
                for (int i = 0; i < modeloTablaProducto.getRowCount(); i++) {
                    if (modeloTablaProducto.getValueAt(i, 0).equals(codigo)) {
                        modeloTablaProducto.removeRow(i);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "No se encontró un producto con el código proporcionado.");
            }

            public Producto buscarProductoPorCodigo(String codigo) { // Corrección aquí
                for (Producto producto : Main.productos) {
                    if (producto instanceof Producto && producto.getCodigo().equals(codigo)) {
                        return producto; // Corrección aquí
                    }
                }
                return null;
            }

        }
