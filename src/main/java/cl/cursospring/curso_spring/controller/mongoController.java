package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.CategoriaMongoModel;
import cl.cursospring.curso_spring.service.CategoriaMongoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/mongodb")
public class mongoController {

    @Autowired
    private CategoriaMongoService service;

    @GetMapping("/home")
    public String home() {
        return "Hola Mundo Mongo";
    }
    
    @PostMapping("/add-categoria")
    public ResponseEntity<Object> agregar_categoria(@RequestBody CategoriaMongoModel entity) {
        service.guardar(entity);
        return ResponseEntity.ok("Guardado con exito");
    }
    
}
