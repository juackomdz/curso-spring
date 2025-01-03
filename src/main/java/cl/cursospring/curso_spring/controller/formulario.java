package cl.cursospring.curso_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.cursospring.curso_spring.model.UsuarioModel;
import io.swagger.v3.oas.annotations.Hidden;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@Hidden
@RequestMapping("/formulario")
public class formulario {

    //formulario de manera sencilla
    //--------------------------------------------------
    @GetMapping("/home")
    public String home() {
        return "formularios/home";
    }
    
    @PostMapping("/home")
    @ResponseBody
    public String homePost(@RequestParam(name = "username")String username, @RequestParam(name = "password")String pass) {

        return "hola "+username+" tu password es: "+pass;
    }
    //---------------------------------------------------

    //formulario con objetos
    //--------------------------------------------------
    @GetMapping("/objeto")
    public String objeto() {
        return "formularios/objeto";
    }
    
    @PostMapping("/objeto")
    @ResponseBody
    public String objetoPost(UsuarioModel modelo) {

        return "<h1>Objeto</h1>hola "+modelo.getUsername()+" password: "+modelo.getPass();
    }

    @GetMapping("/objeto2")
    public String objeto2(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "formularios/objeto2";
    }
    
    @PostMapping("/objeto2")
    @ResponseBody
    public String objeto2Post(UsuarioModel modelo) {
        
        return "<h1>Objeto 2</h1>hola "+modelo.getUsername()+" password: "+modelo.getPass();
    }
    //---------------------------------------------------
}
