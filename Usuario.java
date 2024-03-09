package src;
public class Usuario {
    protected String codigo;
    protected String contrasena;
    protected String nombres;
    protected static String apellidos;
    protected String genero;
    protected String edad;


    public Usuario(String codigo, String contrasena, String nombres, String apellidos, String genero, String edad) {
        
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.nombres = nombres;
        Usuario.apellidos = apellidos;
        this.genero = genero;
        this.edad = edad;
    
    }

    public boolean autenticar(String codigo, String contrasena) {
        return this.codigo.equals(codigo) && this.contrasena.equals(contrasena);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        Usuario.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public static Usuario buscarPacientePorCodigo(String codigo2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPacientePorCodigo'");
    }

    

}