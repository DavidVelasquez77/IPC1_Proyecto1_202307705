package src;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {

    public static Administrador administrador = new Administrador("202307705", "proyecto1IPC1", "administrador");
    public static List<Doctor> doctores = new ArrayList<>();
    public static HashMap<String, ArrayList<Cita>> citasPorPaciente = new HashMap<>();
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static List<Cita> citas = new ArrayList<>();
    public static List<Horario> horarios = new ArrayList<>();


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

        SwingUtilities.invokeLater(() -> {
            InterfazInicioSesion interfazInicioSesion = new InterfazInicioSesion();
            interfazInicioSesion.initialize();
        });
    }

    public static void actualizarDoctorEnLista(Doctor doctor) {
        for (int i = 0; i < InterfazAdministrador.modeloTablaDoctores.getRowCount(); i++) {
            if (InterfazAdministrador.modeloTablaDoctores.getValueAt(i, 0).equals(doctor.getCodigo())) {
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getNombres(), i, 1);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(Doctor.getApellidos(), i, 2);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getEspecialidad(), i, 4);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getContrasena(), i, 3);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getGenero(), i, 5);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getTelefono(), i, 6);
                InterfazAdministrador.modeloTablaDoctores.setValueAt(doctor.getEdad(), i, 7);
                return;
            }
        }
    }

    public static void actualizarPacienteEnLista(Usuario usuario) {
        for (int i = 0; i < InterfazAdministrador.modeloTablaUsuarios.getRowCount(); i++) {
            if (InterfazAdministrador.modeloTablaUsuarios.getValueAt(i, 0).equals(usuario.getCodigo())) {
                InterfazAdministrador.modeloTablaUsuarios.setValueAt(usuario.getNombres(), i, 1);
                InterfazAdministrador.modeloTablaUsuarios.setValueAt(Usuario.getApellidos(), i, 2);
                InterfazAdministrador.modeloTablaUsuarios.setValueAt(usuario.getContrasena(), i, 3);
                InterfazAdministrador.modeloTablaUsuarios.setValueAt(usuario.getGenero(), i, 4);
                InterfazAdministrador.modeloTablaUsuarios.setValueAt(usuario.getEdad(), i, 5);
                return;
            }
        }
    }

    public static void actualizarProductoEnLista(Producto producto) {
        for (int i = 0; i < InterfazAdministrador.modeloTablaProducto.getRowCount(); i++) {
            if (InterfazAdministrador.modeloTablaProducto.getValueAt(i, 0).equals(producto.getCodigo())) {
                InterfazAdministrador.modeloTablaProducto.setValueAt(producto.getNombre(), i, 1);
                InterfazAdministrador.modeloTablaProducto.setValueAt(producto.getCantidad(), i, 2);
                InterfazAdministrador.modeloTablaProducto.setValueAt(producto.getDescripcion(), i, 3);
                InterfazAdministrador.modeloTablaProducto.setValueAt(producto.getPrecio(), i, 4);
                return;
            }
        }
    }
}
