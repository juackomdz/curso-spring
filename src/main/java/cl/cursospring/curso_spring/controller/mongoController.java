package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.CategoriaMongoModel;
import cl.cursospring.curso_spring.model.ProductoMongoModel;
import cl.cursospring.curso_spring.service.CategoriaMongoService;
import cl.cursospring.curso_spring.service.ProductoMongoService;
import cl.cursospring.curso_spring.utilidades.Utilidades;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/mongodb")
public class mongoController {

    @Autowired
    private CategoriaMongoService service;

    @Autowired
    private ProductoMongoService productoService;

    @GetMapping("/categorias")
    public List<CategoriaMongoModel> listar_categorias() {
        return service.listar();
    }
    
    @GetMapping("/home")
    public String home() {
        return "Hola Mundo Mongo";
    }
    
    @PostMapping("/add-categoria")
    public ResponseEntity<Object> agregar_categoria(@RequestBody CategoriaMongoModel entity) {
        service.guardar(entity);
        return ResponseEntity.ok("Guardado con exito");
    }
    
    @PutMapping("/edit-slug")
    public ResponseEntity<Object> editar_categoria(@RequestBody CategoriaMongoModel entity) {
        CategoriaMongoModel cate = this.service.buscarPorNombre(entity.getNombre());

        cate.setSlug(entity.getSlug());

        service.guardar(cate);
        
        return ResponseEntity.ok("Editado correctamente");
    }

    @DeleteMapping("/delete/{nombre}")
    public ResponseEntity<Object> eliminar_categoria(@PathVariable String nombre) {
       try {
            service.eliminar(nombre);
            return ResponseEntity.ok("Eliminado con exito");
       } catch (Exception e) {
            return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "No se pudo eliminar");
       }
    }


    /*
     * {
      "nombre":"producto 1",
      "slug":"producto nuevo 1",
      "descripcion":"descripcion nueva",
      "precio":12345,
      "foto":"foto 1",
      "categoriaId":{"id":"67374ee409b1fc4318b638d0"}
      }
     */
    @PostMapping("/add-producto")
    public ResponseEntity<Object> agregar_producto (@RequestBody ProductoMongoModel entity) {
        
        productoService.guardar(entity);
        
        return Utilidades.generateResponse(HttpStatus.CREATED, "Creado con exito");
    }
    
    @GetMapping("/productos")
    public List<ProductoMongoModel> listar_productos() {
        return productoService.listar();
    }
    
    @PutMapping("/edit-producto/{nombre}")
    public ResponseEntity<Object> editar_producto(@PathVariable String nombre, @RequestBody ProductoMongoModel entity) {
       try {
            ProductoMongoModel produ = productoService.buscarPorNombre(nombre);
            produ.setDescripcion(entity.getDescripcion());
            produ.setPrecio(entity.getPrecio());
            produ.setSlug(entity.getSlug());
            produ.setFoto(entity.getFoto());

            productoService.guardar(produ);

            return Utilidades.generateResponse(HttpStatus.OK, "Editado con exito");
       } catch (Exception e) {
             return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "No se pudo editar");
       }
        
        
    }

    @DeleteMapping("/delete-producto/{nombre}")
    public ResponseEntity<Object> eliminar_producto(@PathVariable String nombre) {
        try {
            productoService.eliminar(nombre);
            return ResponseEntity.ok("Eliminado con exito");
            } catch (Exception e) {
                return Utilidades.generateResponse(HttpStatus.BAD_REQUEST, "No se pudo eliminar");
        }
    }
}
