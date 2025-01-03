package cl.cursospring.curso_spring.misPruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import cl.cursospring.curso_spring.model.CategoriaModel;
import cl.cursospring.curso_spring.repository.ICategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class categoriaPruebas {

    @Autowired
    private ICategoriaRepository repositorio;

    @Test
    @Rollback(false)
    @Order(1)
    public void crearCategoria(){
        CategoriaModel guardar = this.repositorio.save(new CategoriaModel("categoria prueba","slug prueba"));
        System.out.println(guardar.getId());
        assertNotNull(guardar);
    }

    @Test
    @Order(2)
    public void buscarCategoria(){
        Integer idCategoria = 11;
        Optional<CategoriaModel> categoria = this.repositorio.findById(idCategoria);

        //assertEquals(idCategoria, categoria.get().getId());

        assertTrue(categoria.isPresent());
    }

    @Test
    @Order(3)
    public void buscarCategoriaNull(){
        Integer idCategoria = 2;
        Optional<CategoriaModel> categoria = this.repositorio.findById(idCategoria);
        //System.out.println(categoria.empty());
        assertFalse(categoria.isPresent());
        
    }

    @Test
    @Order(4)
    public void actualizarCategoria(){
        Integer idCategoria = 11;
        String nombreCate = "Categoria 123";
        CategoriaModel categoria = this.repositorio.findById(idCategoria).orElse(null);
        if(categoria != null){
            categoria.setNombre(nombreCate);
            categoria.setSlug("slug prueba actualizada");
            this.repositorio.save(categoria);
        }

        //System.out.println(categoria.getId());
        assertEquals(nombreCate, categoria.getNombre());
    }

    @Test
    @Order(5)
    public void listarCategorias(){
        List<CategoriaModel> categorias = this.repositorio.findAll();
        for(CategoriaModel categoria: categorias){
            System.out.println(categoria.getNombre());
        }
        System.out.println("cantidad="+categorias.size());
        assertFalse(categorias.isEmpty());
    }
           
    @Test
    @Order(6)
    public void eliminarCategoria(){
        Integer id = 11;
        boolean exist = this.repositorio.findById(id).isPresent();
        this.repositorio.deleteById(id);
        boolean noExist = this.repositorio.findById(id).isPresent();
        
        System.out.println("existe="+exist);
        System.out.println("no existe="+noExist);
        assertTrue(exist);
        assertFalse(noExist);
    }
}
