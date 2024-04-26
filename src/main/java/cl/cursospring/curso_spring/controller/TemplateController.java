package cl.cursospring.curso_spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/")
    public String home(Model model) {

        String nombre = "joaquin";
        String pais = "chile";
        model.addAttribute("nombre", nombre);
        model.addAttribute("country", pais);
        return "template/home";
    }

    @GetMapping("/parametros")
    public String getMethodName(Model model) {

        Integer num1=11;
        Integer num2=10;
        Integer cifra=12345;
        Date fecha = new Date();

        List<String> paises =  new ArrayList<String>();
        paises.add("chile");
        paises.add("colombia");
        paises.add("argentina");
        paises.add("venezuela");

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("fecha", fecha);
        model.addAttribute("cifra", cifra);
        model.addAttribute("paises", paises);
        return "template/parametros";
    }
    
    
}
