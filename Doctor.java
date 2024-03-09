package src;

public class Doctor extends Usuario {
    private String nombres;
    private static String apellidos;
    private String contrasena;
    private String especialidad;
    private String genero;
    private String telefono;
    private String edad;

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

}