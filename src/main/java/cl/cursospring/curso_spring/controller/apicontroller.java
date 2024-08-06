package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1")
public class apicontroller {

    @GetMapping("/hola")
    public String holamundoget(){
        return "Hola Mundo get desde api";
    }

    @PostMapping("/hola")
    public String holaMundopost(){
        return "Hola Mundo post desde api";  
    }

    @PutMapping("/hola")
    public String holamundoput() {
        return "hola mundo put desde api";
    }

    @DeleteMapping("/hola")
    public String holaMundodelete(){
        return "Hola Mundo delete desde api";       
    }
}
