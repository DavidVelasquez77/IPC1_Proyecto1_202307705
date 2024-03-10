package src;
import java.util.Objects;

public class Doctor extends Usuario {
    public static Doctor doctor;
    private String nombres;
    private static String apellidos;
    private String contrasena;
    private String especialidad;
    private String codigo;
    private String genero;
    private String telefono;
    private String edad;
    private String horario;

    public Doctor(String codigo, String contrasena, String nombres, String apellidos, String especialidad, String genero, String telefono, String edad) {
        super(codigo, contrasena, nombres, apellidos, genero, edad);
        this.nombres = nombres;
        this.codigo = codigo;
        Doctor.apellidos = apellidos;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.genero = genero;
        this.telefono = telefono;
        this.edad = edad;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        Doctor.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Doctor doctor = (Doctor) obj;
        return Objects.equals(nombres, doctor.nombres);
        // Compara otros campos si es necesario
    }











}