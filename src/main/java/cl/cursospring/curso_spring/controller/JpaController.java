package cl.cursospring.curso_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import cl.cursospring.curso_spring.service.CategoriaService;




@Controller
@RequestMapping("/jpa-repository")
public class JpaController {

@Autowired
private CategoriaService service;

    @GetMapping("")
    public String home(Model model) {
        return "jparepository/home";
    }
    
    @GetMapping("/categorias")
    public String categorias(Model model) {
        model.addAttribute("datos", service.listar());
        return "jparepository/categorias";
    }
    
}
