package cl.cursospring.curso_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.EjemploModel;
import cl.cursospring.curso_spring.utilidades.Utilidades;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class apicontroller {

    @GetMapping("/hola")
    public String holamundoget(){
        return "Hola Mundo get desde api";
    }

    @GetMapping("/hola/{id}")
    public String holaconparametro(@PathVariable("id") String id){
        return "Hola Mundo con parametro ="+id;
    }

    @PostMapping("/hola")
    public String holaMundopost(){
        return "Hola Mundo post desde api";  
    }

    /* 
    {
    "nombre":"juan",
    "apellido":"perez",
    "descripcion":"jefe",
    "precio":200
    }
*/

    @PostMapping("/metodo-json")
    public String metodo_json(@RequestBody EjemploModel req){
        return "datos= "+req.getNombre()+" "+req.getApellido();
    }


    @PutMapping("/hola")
    public String holamundoput() {
        return "hola mundo put desde api";
    }

    @DeleteMapping("/hola")
    public String holaMundodelete(){
        return "Hola Mundo delete desde api";       
    }


    @GetMapping("/response")
    public ResponseEntity<String> respuesta(){
        return ResponseEntity.ok("Hola Mundo response");
    }

    
    @GetMapping("/response-custom")
    public ResponseEntity<Object> respuesta_json(){
        return Utilidades.generateResponse(HttpStatus.OK, "response custom");
    }
    
}
