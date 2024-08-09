package cl.cursospring.curso_spring.model;

public class EjemploModel {

    private String nombre;
    private String apellido;
    private String descripcion;
    private Integer precio;
    
    public EjemploModel() {
    }

    public EjemploModel(String nombre, String apellido, String descripcion, Integer precio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    
}


