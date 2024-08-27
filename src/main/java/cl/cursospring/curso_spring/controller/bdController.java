package cl.cursospring.curso_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.CategoriaModel;
import cl.cursospring.curso_spring.service.CategoriaService;

@RestController
@RequestMapping("/api/v1")
public class bdController {

    @Autowired
    private CategoriaService categoriaservice;

    @GetMapping("/get-categoria")
    public List<CategoriaModel>  getCategorias() {
        return categoriaservice.listar();
    }

}
