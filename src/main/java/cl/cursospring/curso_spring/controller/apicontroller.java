package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class apicontroller {

    @GetMapping("/hola")
    public String holamundo(){
        return "Hola Mundo desde api";
    }
}
