package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.model.PostsDTO;
import cl.cursospring.curso_spring.model.ResponseWageModel;
import cl.cursospring.curso_spring.model.ResponseWebClient;
import cl.cursospring.curso_spring.service.WebClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api2")
public class apicontroller2 {

    @Autowired
    private WebClientService service;

    @GetMapping("/consumir")
    public ResponseEntity<Flux<ResponseWebClient>> consumir_api() {

        System.out.println("respuesta="+service.getPost());
        
        return ResponseEntity.ok(service.getPost());
    }

    @GetMapping("/consumir/{id}")
    public ResponseEntity<Flux<ResponseWebClient>> consumir_api2(@PathVariable Integer id) {

        System.out.println("respuesta="+service.getPost());
        
        return ResponseEntity.ok(service.getPostId(id));
    }
    
    /* 
    @PostMapping("/wage-cap/{presupuesto}/{cl}/{pe}/{re}")
    public ResponseEntity<Object> wage(@PathVariable int presupuesto, @PathVariable int cl, @PathVariable int pe, @PathVariable int re) {
        
        int dineroGrupo = presupuesto/3;

        int sueldoClaves = dineroGrupo/cl;
        int sueldoPrimerEquipo = dineroGrupo/pe;
        int sueldoRecambio = dineroGrupo/re;
        //System.out.println("presupuesto="+presupuesto);

        ResponseWageModel response = new ResponseWageModel(sueldoClaves, sueldoPrimerEquipo, sueldoRecambio);
        
        return ResponseEntity.ok(response);
    }
    */

    @PostMapping("/consumir-post/")
    public ResponseEntity<Mono<ResponseWebClient>> post(@RequestBody ResponseWebClient entity) {
        
        return new ResponseEntity<>(service.postTodo(entity), HttpStatus.CREATED);
    }
    

}
