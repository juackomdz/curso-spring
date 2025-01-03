package cl.cursospring.curso_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.cursospring.curso_spring.model.CategoriaModel;
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

    @GetMapping("/categorias/add")
    public String categorias_add(Model model) {
        CategoriaModel cate = new CategoriaModel();
        model.addAttribute("categoria", cate);
        return "jparepository/categorias_add";
    }

    @PostMapping("/categorias/add")
    public String categorias_add_post(Model model, CategoriaModel cate) {
        model.addAttribute("categoria", cate);
        this.service.guardar(cate);
        return "jparepository/categorias_add";
        
    }

    @GetMapping("/categorias/edit/{id}")
    public String categorias_edit(@PathVariable Integer id, Model model) {
        CategoriaModel cate = this.service.buscarId(id);
        model.addAttribute("categoria", cate);
        return "jparepository/categorias_editar";
    }
    
    @PostMapping("categorias/edit/{id}")
    public String categorias_edit_post(@PathVariable Integer id, Model model, CategoriaModel cate) {
        model.addAttribute("categoria", cate);
        this.service.guardar(cate);
        return "jparepository/categorias_editar";
    }

    @GetMapping("categorias/delete/{id}")
    public String categorias_delete(@PathVariable Integer id){
        
        try {
            this.service.eliminar(id);
            return "jparepository/categorias";
        } catch (Exception e) {
            return "jparepository/categorias";
        }
    }
}
