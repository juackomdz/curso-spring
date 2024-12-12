package cl.cursospring.curso_spring.misPruebas;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
