package src;

public class Producto {
 
    public static Producto producto;
    private String descripcion;
    private String nombre;
    private String cantidad;
    private String precio;
    private String codigo;
    

    public Producto(String codigo, String nombre, String descripcion, String cantidad, String precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCantidad(){
        return cantidad;
    }

    public void setCantidad(String cantidad){
        this.cantidad = cantidad;
    }

    public String getPrecio(){
        return precio;
    }

    public void setPrecio(String precio){
        this.precio = precio;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }    
}