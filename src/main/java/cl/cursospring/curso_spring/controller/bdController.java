package cl.cursospring.curso_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.CategoriaModel;
import cl.cursospring.curso_spring.service.CategoriaService;
import cl.cursospring.curso_spring.utilidades.Utilidades;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class bdController {

    @Autowired
    private CategoriaService categoriaservice;

    @GetMapping("/get-categoria")
    public List<CategoriaModel>  getCategorias() {
        return categoriaservice.listar();
    }

    @GetMapping("/get-categoria/{id}")
    public CategoriaModel getCategoria(@PathVariable("id") Integer id) {
        return categoriaservice.buscarId(id);
    }

    /*
     * 
     * {
    "nombre":"categoria nueva",
    "slug":"cat new"
    }
     */
    @PostMapping("/add-categoria")
    public ResponseEntity<Object> categoria_post(@RequestBody CategoriaModel entity) {
        categoriaservice.guardar(entity);
        return Utilidades.generateResponse(HttpStatus.CREATED, "creado con exito");
    }

    @PutMapping("/edit-categoria/{id}")
    public ResponseEntity<Object> categoria_put(@PathVariable("id") Integer id, @RequestBody CategoriaModel entity){
        CategoriaModel cate = this.categoriaservice.buscarId(id);

        cate.setNombre(entity.getNombre());
        cate.setSlug(entity.getSlug());

        categoriaservice.guardar(cate);

        return Utilidades.generateResponse(HttpStatus.OK, "Editado correctamente");
    }

    @DeleteMapping("/delete-categoria/{id}")
    public ResponseEntity<Object> categoria_delete(@PathVariable("id") Integer id) {
       
       try {
            categoriaservice.eliminar(id);
            return Utilidades.generateResponse(HttpStatus.OK, "Eliminado con exito");
       } catch (Exception e) {
            return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "Hubo un error.");
       }
        
    }
}
