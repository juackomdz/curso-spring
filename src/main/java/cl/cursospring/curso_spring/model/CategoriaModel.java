package cl.cursospring.curso_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String slug;

    
    public CategoriaModel() {
    }

    
    public CategoriaModel(String nombre, String slug) {
        this.nombre = nombre;
        this.slug = slug;
    }


    public CategoriaModel(Integer id, String nombre, String slug) {
        this.id = id;
        this.nombre = nombre;
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }

    
}
