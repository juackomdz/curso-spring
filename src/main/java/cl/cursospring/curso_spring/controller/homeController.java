package cl.cursospring.curso_spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class homeController {

    @Value("${curso.spring.ejemplo}")
    private  String nombre;

    @GetMapping("/")
    public String home() {
        return  "home/home";
    }

    @GetMapping("/nosotros")
    @ResponseBody
    public String nosotros(){
        return "hola desde sitio nosotros";
    }

    @GetMapping("/producto/{id}")
    @ResponseBody
    public String producto(@PathVariable("id")  int id){
        return "producto="+id;
    }

    // Para pasar parametros a una url a traves de querystring --> =?nombre=juan&apellido=perez
    @GetMapping("/query-string")
    @ResponseBody
    public String query(@RequestParam("id") int id){
        return "producto="+id;
    }

    @GetMapping("/valores")
    @ResponseBody
    public String valores() {
        return "hola ="+this.nombre;
    }
    
}
