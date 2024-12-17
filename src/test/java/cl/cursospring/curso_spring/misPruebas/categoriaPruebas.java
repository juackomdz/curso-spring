package cl.cursospring.curso_spring.misPruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import cl.cursospring.curso_spring.model.CategoriaModel;
import cl.cursospring.curso_spring.repository.ICategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class categoriaPruebas {

    @Autowired
    private ICategoriaRepository repositorio;

    @Test
    @Rollback(false)
    public void crearCategoria(){
        CategoriaModel guardar = this.repositorio.save(new CategoriaModel("categoria prueba","slug prueba"));
        System.out.println(guardar.getId());
        assertNotNull(guardar);
    }

    @Test
    public void buscarCategoria(){
        Integer idCategoria = 11;
        Optional<CategoriaModel> categoria = this.repositorio.findById(idCategoria);

        //assertEquals(idCategoria, categoria.get().getId());

        assertTrue(categoria.isPresent());
    }

    @Test
    public void buscarCategoriaNull(){
        Integer idCategoria = 2;
        Optional<CategoriaModel> categoria = this.repositorio.findById(idCategoria);

        assertFalse(categoria.isPresent());
    }
}
