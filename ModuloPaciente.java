package src;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class ModuloPaciente extends JFrame{
    final private Font mainFont = new Font("Tahoma", Font.BOLD, 20);
    final private Font TituloFont = new Font("Tahoma", Font.PLAIN, 25);
    final private Font encabezadoFont = new Font("Tahoma", Font.BOLD, 30);
    static DefaultTableModel citasModelTable = new DefaultTableModel();
    JComboBox<String> especialidadComboBox;
    JComboBox<String> doctorComboBox;
    JTextField citaText;
    private static Usuario usuario;

    public ModuloPaciente(Usuario usuario) {
        ModuloPaciente.usuario = usuario;
    }
    public void initialize (){
        Usuario usuarioActual = null;
        for (Usuario usuario : Main.usuarios) {
            if (usuario.getCodigo().equals(InterfazInicioSesion.cajaCodigo.getText())){
                usuarioActual = usuario;
                break;
            }
        }
        if (usuarioActual != null) {
            ModuloPaciente.usuario = usuarioActual;
            String nombrePaciente = ModuloPaciente.usuario.getNombres();
            JTabbedPane pacientePanel = new JTabbedPane();
            pacientePanel.setBackground(new Color(207, 234, 247)); 

            JPanel solicitarCitaPanel = new JPanel(new BorderLayout());
            JLabel bienvenidaLabel = new JLabel("Bienvenido " + nombrePaciente, SwingConstants.CENTER);
            solicitarCitaPanel.add(bienvenidaLabel, BorderLayout.NORTH);
            add(bienvenidaLabel, BorderLayout.NORTH);
            bienvenidaLabel.setFont(encabezadoFont);
            JLabel citaLabel = new JLabel("Motivo de la cita:", SwingConstants.CENTER);
            citaLabel.setFont(TituloFont);
            citaText = new JTextField();
            citaText.setFont(mainFont);

            JLabel especialidadLabel = new JLabel("Especialidad: ", SwingConstants.LEFT);
            especialidadLabel.setFont(mainFont);
            ArrayList<String> especialidades = new ArrayList<>();
            especialidades.add("Seleccione una opción");
            for (Doctor doctor : Main.doctores) {
                String especialidad = doctor.getEspecialidad();
                if (!especialidades.contains(especialidad)) {
                    especialidades.add(especialidad);
                }
            }
            String[] especialidadArray = especialidades.toArray(new String[0]);
            JComboBox<String> especialidadComboBox = new JComboBox<>(especialidadArray);
            especialidadComboBox.setFont(mainFont);
            JLabel doctorLabel = new JLabel("Doctor: ", SwingConstants.LEFT);
            doctorLabel.setFont(mainFont);
            
            ArrayList<String> nombresDoctores = new ArrayList<>();
            nombresDoctores.add("Seleccione una opción");
            String[] nombresDoctoresArray = nombresDoctores.toArray(new String[0]);
            JComboBox<String> doctorComboBox = new JComboBox<>(nombresDoctoresArray);
            especialidadComboBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent arg0) {
                    String especialidadSeleccionada = (String)especialidadComboBox.getSelectedItem();
                    nombresDoctores.clear();
                    nombresDoctores.add("Seleccione una opción");
                    for (Doctor doctor : Main.doctores) {
                        if (doctor.getEspecialidad().equals(especialidadSeleccionada)) {
                            String nombreDoctor = "Dr. " + doctor.getNombres() + " " + Doctor.getApellidos();
                            nombresDoctores.add(nombreDoctor);
                        }
                    }
                    
                    String [] nombresDoctoresArray = nombresDoctores.toArray(new String[0]);                                       
                    doctorComboBox.setFont(mainFont);
                    doctorComboBox.setModel(new DefaultComboBoxModel<>(nombresDoctoresArray));
                }
            });

            if (especialidadComboBox.getItemListeners().length > 0) {
                especialidadComboBox.getItemListeners()[0].itemStateChanged(null);
            }

            JButton mostrarDoctoresButton = new JButton("Mostrar doctores");
            mostrarDoctoresButton.setFont(mainFont);
            mostrarDoctoresButton.setBorderPainted(false);
            mostrarDoctoresButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String especialidadSeleccionada = (String)especialidadComboBox.getSelectedItem();
                    StringBuilder doctoresDisponibles = new StringBuilder();
                    for (Doctor doctor : Main.doctores) {
                        if (doctor.getEspecialidad().equals(especialidadSeleccionada)) {
                            String nombreDoctor = "Dr. " + doctor.getNombres() + " " + Doctor.getApellidos();
                            doctoresDisponibles.append(nombreDoctor).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, doctoresDisponibles.toString(), "Doctores disponibles", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            JButton mostrarHorariosButton = new JButton("Mostrar Horarios");
            mostrarHorariosButton.setFont(mainFont);
            mostrarHorariosButton.setBorderPainted(false);
            mostrarHorariosButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    //Hacer que se muestren los horarios del doctor seleccionado
                }
            });

            JLabel horarioLabel = new JLabel("Seleccionar horario de cita: ", SwingConstants.CENTER);
            horarioLabel.setFont(TituloFont);
            JLabel fechaLabel = new JLabel("Fecha", SwingConstants.LEFT);
            fechaLabel.setFont(mainFont);
            String[] fecha = {"Seleccione la opción", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
            JComboBox<String> fechaComboBox = new JComboBox<>(fecha);
            fechaComboBox.setFont(mainFont);
            JLabel horaLabel = new JLabel("Hora", SwingConstants.LEFT);
            horaLabel.setFont(mainFont);
            String[] hora = {"Seleccione la opción", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};
            JComboBox<String> horaComboBox = new JComboBox<>(hora);
            horaComboBox.setFont(mainFont);

            JButton generarCitaButton = new JButton("Generar Cita");
            generarCitaButton.setFont(mainFont);
            generarCitaButton.setBorderPainted(false);
            generarCitaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String motivoCita = citaText.getText();
                    Cita cita = new Cita(motivoCita, especialidadComboBox.getSelectedItem().toString(), doctorComboBox.getSelectedItem().toString(), fechaComboBox.getSelectedItem().toString());
                    Main.citas.add(cita);      
                    
                    citasModelTable.addRow(new Object[]{citasModelTable.getRowCount() + 1, motivoCita, "Pendiente", fechaComboBox.getSelectedItem().toString(), horaComboBox.getSelectedItem().toString()});
                    generarCitaButton.setEnabled(false);
                    if (motivoCita.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
                        return;
                    }
                }
            });

            JButton editarPerfilButton = new JButton("Editar perfil");
            editarPerfilButton.setFont(mainFont);
            editarPerfilButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InterfazActualizarPaciente actualizarPacienteFrame = new InterfazActualizarPaciente(usuario);
                    actualizarPacienteFrame.initialize();
                }
            });

            // Agrega el botón al panel
            solicitarCitaPanel.add(editarPerfilButton, BorderLayout.EAST);

            JPanel citaLabelPanel = new JPanel();
            citaLabelPanel.setLayout(new BorderLayout());     
            citaLabelPanel.setOpaque(false);
            citaLabelPanel.add(citaLabel, BorderLayout.WEST);

            JPanel boxPanel = new JPanel();
            boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
            boxPanel.setOpaque(false);
            boxPanel.add(citaText);
            boxPanel.add(Box.createRigidArea(new Dimension(0, 50)));

            JPanel especialidadPanel = new JPanel();
            especialidadPanel.setLayout(new BoxLayout(especialidadPanel, BoxLayout.X_AXIS));
            especialidadPanel.setOpaque(false);
            especialidadPanel.add(especialidadLabel);
            especialidadPanel.add(especialidadComboBox);
            especialidadPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            especialidadPanel.add(mostrarDoctoresButton);

            JPanel doctorPanel = new JPanel();
            doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.X_AXIS));
            doctorPanel.add(doctorLabel);
            doctorPanel.add(doctorComboBox);
            doctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));
            doctorPanel.add(mostrarHorariosButton);

            JPanel tituloPanel = new JPanel();
            tituloPanel.setLayout(new BorderLayout()); 
            tituloPanel.setOpaque(false);
            tituloPanel.add(Box.createRigidArea(new Dimension(0, 50)));
            tituloPanel.add(horarioLabel, BorderLayout.WEST);
            tituloPanel.add(editarPerfilButton, BorderLayout.EAST);

            JPanel inferiorPanel = new JPanel();
            inferiorPanel.setLayout(new BoxLayout(inferiorPanel, BoxLayout.X_AXIS));
            inferiorPanel.add(fechaLabel);
            inferiorPanel.add(fechaComboBox);
            inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
            inferiorPanel.add(horaLabel);
            inferiorPanel.add(horaComboBox);
            inferiorPanel.add(Box.createRigidArea(new Dimension(75, 0)));
            inferiorPanel.add(generarCitaButton);

            solicitarCitaPanel.setLayout(new BoxLayout(solicitarCitaPanel, BoxLayout.Y_AXIS));
            solicitarCitaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            solicitarCitaPanel.add(citaLabelPanel);
            solicitarCitaPanel.add(boxPanel);
            solicitarCitaPanel.add(especialidadPanel);
            solicitarCitaPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            solicitarCitaPanel.add(doctorPanel);
            solicitarCitaPanel.add(tituloPanel);
            solicitarCitaPanel.add(inferiorPanel);

            JPanel estadoCitasPanel = new JPanel(new BorderLayout());

            JLabel historialCitasLabel = new JLabel("Historial de citas:", SwingConstants.LEFT);
            historialCitasLabel.setFont(TituloFont);

            if (citasModelTable.getColumnCount() == 0) {
                citasModelTable.addColumn("No.");
                citasModelTable.addColumn("Motivo");
                citasModelTable.addColumn("Estado");
                citasModelTable.addColumn("Fecha");
                citasModelTable.addColumn("Hora");
            }

            JTable citasTable = new JTable(citasModelTable);

            estadoCitasPanel.setLayout(new GridLayout(2,1,5,5));        
            estadoCitasPanel.add(historialCitasLabel, BorderLayout.NORTH);
            estadoCitasPanel.add(new JScrollPane(citasTable), BorderLayout.CENTER);
            estadoCitasPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JPanel pFarmacia = new JPanel(new BorderLayout());

            pacientePanel.addTab("Solicitar Cita", solicitarCitaPanel);
            pacientePanel.addTab("Estado de Cita", estadoCitasPanel);
            pacientePanel.addTab("Farmacia", pFarmacia);
            pacientePanel.setFont(mainFont);



            add(pacientePanel);

            setTitle("Paciente");
            setSize(300, 300);
            setMinimumSize(new Dimension(900, 500));
            setVisible(true);           
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario");
            
        } 
        
        
    }

    public static void main(String[] args) {        
        ModuloPaciente pacienteFrame = new ModuloPaciente(usuario);
        pacienteFrame.initialize();
    }

   
}